//package com.soap.flink.wc
//
//import org.apache.flink.api.java.utils.ParameterTool
//import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment
//import org.apache.flink.streaming.api.scala._
//
///**
// * @author yangfuzhao on 2020/8/23.
// */
//object StreamingTest {
//
//  def main(args: Array[String]): Unit = {
//
//    val params = ParameterTool.fromArgs(args)
//    val hostname = params.get("hostname")
//    val port = params.getInt("port")
//    //创建流处理执行环节
//    val env = StreamExecutionEnvironment.getExecutionEnvironment
//    //创建socket stream
//    val textDataStream = env socketTextStream(hostname,port)
//    val woldCount = textDataStream.flatMap(_.split("\\s"))
//      .filter(_.nonEmpty)
//      .map((_,1))
//      .keyBy(0)
//      .sum(1)
//
//    woldCount.print()
//
//    env.execute(this.getClass.getSimpleName)
//
//  }
//
//
//}
