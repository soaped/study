package com.soap.flink.ttl

import org.apache.flink.api.common.functions.RichFlatMapFunction
import org.apache.flink.api.common.state.StateTtlConfig.TtlTimeCharacteristic
import org.apache.flink.api.common.state.{MapStateDescriptor, StateTtlConfig, ValueState, ValueStateDescriptor}
import org.apache.flink.api.common.time.Time
import org.apache.flink.api.common.typeinfo.{BasicTypeInfo, TypeHint, TypeInformation}
import org.apache.flink.configuration.Configuration
import org.apache.flink.streaming.api.scala._
import org.apache.flink.util.Collector
import org.apache.flink.api.scala.typeutils.CaseClassTypeInfo
import org.apache.flink.streaming.api.TimeCharacteristic

/**
 * @author yangfuzhao on 2021/5/8. 
 */
object TTLTest  {

  def main(args: Array[String]): Unit = {

    val env = StreamExecutionEnvironment.getExecutionEnvironment
//    env.setStateBackend()
    env.setStreamTimeCharacteristic(TimeCharacteristic.IngestionTime)
    val s = new MapStateDescriptor(
      "RulesBroadcastState",
      BasicTypeInfo.STRING_TYPE_INFO,
      TypeInformation.of(new TypeHint[Long]() {}));

    env.fromCollection(List("1", "1", "2", "3", "4"))
      .keyBy(_.toString)
      .broadcast(s)
      //scale 支持状态dataStream API
//      .mapWithState()
//      .flatMap(new WorldCount()).print("###")
    env.execute("ttl")
  }
}

class WorldCount extends RichFlatMapFunction[String, (String,Long)]{
  override def flatMap(in: String, collector: Collector[(String,Long)]): Unit = {
    val v = sum.value()
    if (null != v) {
      sum.update((v._1, v._2 + 1))
    } else {
      sum.update((in, 1))
    }
    collector.collect(sum.value())
  }

  private var sum: ValueState[(String, Long)] = _

  override def open(parameters: Configuration): Unit = {
    super.open(parameters)
    val valueStateDescriptor = new ValueStateDescriptor[(String, Long)]("woldCount", createTypeInformation[(String, Long)])
    sum = getRuntimeContext.getState(valueStateDescriptor)

    /**
     * 设置ttl参数
     * TtlTimeCharacteristic 目前只支持 ProcessingTime
     *  cleanupFullSnapshot
     *  cleanupIncrementally
     *  cleanupInRocksdbCompactFilter
     *  disableCleanupInBackground 优先级最低
     */
    val ttlConfig = StateTtlConfig
      .newBuilder(Time.seconds(5))
      .setUpdateType(StateTtlConfig.UpdateType.OnCreateAndWrite)
      .setStateVisibility(StateTtlConfig.StateVisibility.NeverReturnExpired)
//      .cleanupFullSnapshot()
//      .disableCleanupInBackground()
      .setTtlTimeCharacteristic(TtlTimeCharacteristic.ProcessingTime)
      .build
    valueStateDescriptor.enableTimeToLive(ttlConfig)
    valueStateDescriptor.setQueryable("s")
  }
}
