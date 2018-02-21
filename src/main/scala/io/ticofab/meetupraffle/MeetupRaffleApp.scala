package io.ticofab.meetupraffle

import scala.io.StdIn

object MeetupRaffleApp extends App {

  import scala.io.Source
  import scala.util.Random

  val people = Source.fromResource("list.txt").getLines.toList

  def extractName(names: List[String]): (List[String], String) = {
    val shuffled = Random
      .shuffle(names)
    val winner = shuffled
      .headOption
      .head
    (shuffled.tail, winner)
  }

  def raffle(candidates: List[String]): Unit = {
    StdIn.readLine()
    val (losers, winner) = extractName(candidates)
    println(s"The winner is: $winner")
    raffle(losers)
  }

  println()
  println()
  println("Welcome to the raffle, press any key to extract the winners!")
  raffle(people)
}
