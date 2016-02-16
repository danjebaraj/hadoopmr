package com.syncfusion

import akka.actor._
import akka.routing._
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration._

import java.io._
import scala.io.Source
import scala.util.Random

case class StartJob(count: Int)
case class SumList(numbers: List[Int])
case class ReportSum(sum: Int)

class Summer() extends Actor() {

  def receive = {
    case SumList(numbers) =>
      var sum = 0
      for (number <- numbers)
        sum += number
      
      println(s"Processing sum in thread ${Thread.currentThread().getId()}")  
      sender ! ReportSum(sum)
  }
}

class Program() extends Actor() {
  var pending = 0
  var cummulativeSum = 0
  
  def receive = {
    case StartJob(count) =>
      val summerRef = context.system.actorOf(RoundRobinPool(10).props(Props[Summer]))
       for(i <- 0 until count){
         val bound = Random.nextInt(100)
        summerRef ! SumList( (0 to bound).toList)
        pending += 1}
    case ReportSum(sum) =>
      println(s"Reporting sum in thread ${Thread.currentThread().getId()}")  
      println(s"Calculated sum is $sum")
      cummulativeSum += sum
      pending -= 1
      if(pending == 0)
        println(s"Cummulative sum is $cummulativeSum")
        context.system.shutdown
  }
}


object Driver {

  def main(args: Array[String]) = {
    println(s"Main thread ${Thread.currentThread().getId()}")  
    val system = ActorSystem("Aggregator")
    val program = system.actorOf(Props[Program])
    program ! StartJob(10)
  }
}