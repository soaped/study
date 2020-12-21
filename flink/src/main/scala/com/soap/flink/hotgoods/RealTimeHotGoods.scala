//package com.soap.flink.hotgoods
//
//
//import java.io.File
//
//import org.apache.flink.api.java.io.PojoCsvInputFormat
//import org.apache.flink.api.java.typeutils.{PojoTypeInfo, TypeExtractor}
//import org.apache.flink.api.scala._
//import org.apache.flink.core.fs.Path
//import org.apache.flink.streaming.api.TimeCharacteristic
//import org.apache.flink.streaming.api.functions.timestamps.AscendingTimestampExtractor
//import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
//
///**
// * @author yangfuzhao on 2020/9/17.
// */
//object RealTimeHotGoods {
//
//  def main(args: Array[String]): Unit = {
//
//    val env = StreamExecutionEnvironment.getExecutionEnvironment
//    val fileUrl = this.getClass.getClassLoader.getResource("UserBehavior.csv")
//    val filePath = Path.fromLocalFile(new File(fileUrl.toURI))
//
//    val pojoType = TypeExtractor.createTypeInfo(classOf[UserBehavior]).asInstanceOf[PojoTypeInfo[UserBehavior]]
//
//    val fieldOrder = Array[String]("userId", "itemId", "categoryId", "behavior", "timestamp")
//
//    val csvInput = new PojoCsvInputFormat[UserBehavior](filePath, pojoType, fieldOrder)
//
//    val dataSource = env.createInput(csvInput)
//    //设置事件发生时间
//    env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime)
//
//
//    dataSource.assignAscendingTimestamps(new AscendingTimestampExtractor[UserBehavior]() {
//      override def extractAscendingTimestamp(t: UserBehavior): Long = t.timestamp * 1000
//    }).filter(_.behavior.equalsIgnoreCase("pv"))
//      .print("###")
//
//    env.execute("job")
//  }
//}
