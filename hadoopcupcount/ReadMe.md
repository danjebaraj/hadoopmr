#Steps to run MapReduce Cup Count sample

## Build and run using the command line

* Open a command shell. Ensure that Hadoop and Gradle are on the path. With the Syncfusion Big Data Platform installed this is automatically ensured if you open a shell from the Syncfusion dashboard. With other Hadoop installations please reference directions included with the distribution for running a sample such as the Word Count sample. With other distributions you will also need to modify the Gradle build file to reference the correct Hadoop Jar files to reference during the build. These are by default set to locations to which they are installed and configured by the Syncfusion Big Data platform.

* Navigate to the folder containing this sample.

> To build : gradle build

> To run   : hadoop jar .\build\libs\hadoopcupcount.jar /beveragedata/data-for-hadoop  /outputpath

> /beveragedata/data-for-hadoop - HDFS folder containing files to be scanned. Files to be scanned are assumed to be available in this location.

> /outputpath - denotes path on HDFS where output will be stored

## Using a IDE
**Note:** You may need to install a Gradle plugin depending on your version of the IDE.

### Gradle in Eclipse
* File-> Import-> Import Gradle project.

> To build : Right click the project, click Run As-> Gradle Build.  
                Under Gradle Tasks type 'build' (or) 'jar', Apply and then click Run.
> To run :  Same as under command line option

### Gradle in Netbeans
* Open the gradle project in Netbeans IDE.

> To build : Right click on the project and click 'build'.
> To run :  Same as under command line option

### Gradle in IntelliJ
* Open the gradle project in IntelliJ IDE.
* Click View-> Tool Windows-> Gradle to open gradle projects. 
* Click on the icon 'Execute Gradle Task'.
* Under 'Gradle project' choose the Gradle project for execution.
* Under 'Command line',
        
> To build sample : build  (or) jar (this generates an executable jar file under build/libs folder)

> To run :  Same as under command line option