package com.syncfusion

import java.io._
import scala.util.Random

object Driver {

  val names = Array("William",
    "Ava",
    "Mason",
    "Emma",
    "Noah",
    "Olivia",
    "Liam",
    "Sophia",
    "Elijah",
    "Isabella",
    "James",
    "Madison",
    "Jackson",
    "Abigail",
    "Jacob",
    "Emily",
    "Ethan",
    "Harper",
    "Carter",
    "Elizabeth",
    "Logan",
    "Avery",
    "Michael",
    "Caroline",
    "Gabriel",
    "Mia",
    "Joshua",
    "Chloe",
    "Alexander",
    "Addison",
    "Jayden",
    "Ella",
    "Christopher",
    "Charlotte",
    "Benjamin",
    "Aubrey",
    "Samuel",
    "Skylar",
    "Aiden",
    "Natalie",
    "David",
    "Lillian",
    "Luke",
    "Anna",
    "John",
    "Amelia",
    "Lucas",
    "Evelyn",
    "Caleb",
    "Zoey",
    "Daniel",
    "Layla",
    "Cameron",
    "Hannah",
    "Landon",
    "Sofia",
    "Joseph",
    "Sadie",
    "Matthew",
    "Lily",
    "Levi",
    "Savannah",
    "Dylan",
    "Serenity",
    "Henry",
    "Brooklyn",
    "Jeremiah",
    "Victoria",
    "Wyatt",
    "Paisley",
    "Andrew",
    "Grace",
    "Colton",
    "Peyton",
    "Brayden",
    "Kennedy",
    "Josiah",
    "Scarlett",
    "Hunter",
    "Zoe",
    "Isaac",
    "Allison",
    "Ayden",
    "Aubree",
    "Eli",
    "Aaliyah",
    "Anthony",
    "Claire",
    "Jaxon",
    "Riley",
    "Jonathan",
    "Mackenzie",
    "Grayson",
    "Sarah",
    "Christian",
    "Ariana",
    "Nathan",
    "Autumn",
    "Jordan",
    "Nevaeh",
    "Owen",
    "Aria",
    "Charles",
    "Kaylee",
    "Isaiah",
    "Naomi",
    "Robert",
    "Katherine",
    "Ryan",
    "London",
    "Connor",
    "Reagan",
    "Kayden",
    "Taylor",
    "Thomas",
    "Madelyn",
    "Bryson",
    "Arianna",
    "Oliver",
    "Leah",
    "Austin",
    "Gabriella",
    "Jack",
    "Audrey",
    "Sebastian",
    "Nora",
    "Camden",
    "Stella",
    "Carson",
    "Lydia",
    "Parker",
    "Eleanor",
    "Easton",
    "Penelope",
    "Aaron",
    "Piper",
    "Jace",
    "Kylie",
    "Gavin",
    "Alyssa",
    "Nolan",
    "Annabelle",
    "Chase",
    "Samantha",
    "Bentley",
    "Genesis",
    "Tyler",
    "Trinity",
    "Cooper",
    "Hailey",
    "Brantley",
    "Cora",
    "Hudson",
    "Faith",
    "Kevin",
    "Makayla",
    "Nicholas",
    "Lucy",
    "Evan",
    "Khloe",
    "Jason",
    "Lilly",
    "Zachary",
    "Morgan",
    "Asher",
    "Mary",
    "Brandon",
    "Alexis",
    "Julian",
    "Bella",
    "Ian",
    "Ellie",
    "Kaiden",
    "Brianna",
    "Adrian",
    "Hadley",
    "Jaxson",
    "Bailey",
    "Tristan",
    "Mckenzie",
    "Sawyer",
    "Sophie",
    "Nathaniel",
    "Londyn",
    "Angel",
    "Alexa",
    "Jayceon",
    "Camila",
    "Micah",
    "Kinsley",
    "Dominic",
    "Clara",
    "Miles",
    "Lauren",
    "Brody",
    "Madeline",
    "Braxton",
    "Sydney",
    "Ashton",
    "Melanie",
    "Jose",
    "Xavier")

  val beverages = Array("coffee", "tea", "hot chocolate", "orange juice", "milk", "smoothie")
  val baseCups = 5

  def main(args: Array[String]) = {
    val numberOfDataFiles = 1000
    val dataCountPerFile = 1000

    val appPath = new File(System.getProperty("user.dir")).getParentFile().getAbsolutePath()
    val dataPath = new File(appPath, "data").getAbsolutePath()
    
    def selectRandomEntry(arr: Array[String]) = {
      arr(Random.nextInt(arr.length - 1))
    }

    for (_ <- 0 until numberOfDataFiles) {

      val fileWriter = new FileWriter(dataPath + "\\" + System.nanoTime() + ".txt")
      val printWriter = new PrintWriter(fileWriter)

      try {

        for (_ <- 0 until dataCountPerFile) {
          val name = selectRandomEntry(names)
          val beverage = selectRandomEntry(beverages)
          
          val cups = beverage match {
            case "coffee" => Random.nextInt(baseCups) * 3 + 1
            case "tea" => Random.nextInt(baseCups) * 2 + 1
            case _ => Random.nextInt(baseCups) + 1
          }
          
          printWriter.println(s"$name, $beverage, $cups")
        }

        fileWriter.close()
      } finally {
        fileWriter.close()
      }

    }

    println(s"Data has been generated and saved to $dataPath")
  }
}