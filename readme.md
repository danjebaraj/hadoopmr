#Code samples for the Girl Develop It presentation on February 16, 2016
#Syncfusion, Morrisville, NC

##Hadoop sample

The hadoopcupcount sample has the following dependencies

* The Syncfusion Big Data Platform
* Available from http://www.syncfusion.com/products/big-data
* Java 1.7 or later (also available with the platform)
* Gradle

The sample can be easily ported to run with any other Hadoop distribution. The only change required should be to update the paths to the Hadoop jars on disk. These are to be changed in the Gradle build file.

##Remaining samples

* The remaining samples are all written in Scala and require Java 1.7+ and SBT to be installed for your system.
* You can navigate to the folder containing the sample and type "Sbt run" to run (assuming SBT has been installed and is configured to be in your path).
* To generate Eclipse project files type and run "sbt eclipse". Once project files have been generated you can import the generated project into Eclipse.

##Note

* Several samples depend on the availability of data under a folder named data. A few files are included by default. You can generate additional files by running the "datagen" project.
* For running the Hadoop sample please generate files with a million rows or so. You can increase a variable named "dataCountPerFile" to increase the number of records in each generated file.