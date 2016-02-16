package com.syncfusion

case class Person(name: String, favoriteBeverage: String, cupsPerDay: Int)

object Driver {

  // drop name and extract just beverage and cup count into a list
  def getCupsConsumed(persons: List[Person]) = {
    var lst: List[(String, Int)] = Nil
    persons.foreach  {
        person => 
            lst = (person.favoriteBeverage, person.cupsPerDay) :: lst
      }
    lst
  }
  
  // group and then summarize by group
  def summarize(lst: List[(String, Int)]) = {
    val groupedByBeverage = lst.groupBy(data => data._1)
    
    println(groupedByBeverage)

    // grouped data is of the form
    // beverage -> List of cup numbers
    groupedByBeverage.foreach{case (beverage,listOfCupCounts) => {
            var sum = 0.0
      for ((_, cupCount) <- listOfCupCounts)
        sum += cupCount

      val cupsPerDay = sum / listOfCupCounts.length

      println(f"Average cups consumed by $beverage drinkers is $cupsPerDay%2.2f")
    }}
  }

  def main(args: Array[String]): Unit = {

    val persons = List(
      Person("Mickey", "coffee", 2),
      Person("Donald", "tea", 3),
      Person("Daisy", "tea", 4),
      Person("Clarabelle", "hot chocolate", 2),
      Person("Goofy", "coffee", 1),
      Person("Vitalstatistix", "tea", 3),
      Person("Asterix", "orange juice", 3),
      Person("Tony Stark", "coffee", 4),
      Person("Obelix", "magic potion", 3))

    // Part 1
    // extract a list of just what we need (beverage, count)
    // name is dropped
    val lst = getCupsConsumed(persons)
    println(lst)
    
    // Part 2
    summarize(lst)
  }
}