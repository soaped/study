package com.soap.flink.wc

import org.apache.flink.api.scala._



/**
 * @author yangfuzhao on 2020/8/23. 
 */
object WoldCount {

  def main(args: Array[String]): Unit = {

    val env = ExecutionEnvironment.getExecutionEnvironment

    val inputPath = "/Users/soapy/IdeaProjects/study/flink/src/main/resources/test.txt"

    val inputDataSet = env.readTextFile(inputPath)

    inputDataSet.flatMap(_.split(" "))
      .map((_,1))
      .groupBy(0)
      .sum(1)
      .print()

  }
}
