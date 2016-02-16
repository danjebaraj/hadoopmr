#Steps to run MapReduce Gradle samples through Java API

* Gradle in command line
Open BigData command shell, type 
To build : gradle -p %SYNCBDP_HOME%\Samples\Java\MapReduce\WordCount build
To run   : gradle -p %SYNCBDP_HOME%\Samples\Java\MapReduce\WordCount RunJar

* Gradle in Eclipse
File-> Import-> Import Gradle project.
Choose the Gradle project and click 'Build Model'. Click Finish.
To build : Right click the project, click Run As-> Gradle Build.  
                Under Gradle Tasks type 'build' (or) 'jar', Apply and then click Run.
To run :  Right click the project, click Run As-> Gradle Build.
              Under Gradle Tasks type 'RunJar'

* Gradle in Netbeans
Open the gradle project in Netbeans IDE.
To build : Right click on the project and click 'build'.
To run : Right click on the project click Custom Tasks-> Custom Tasks
             Under 'Tasks' type 'RunJar'
             Click Execute to run the sample.

* Gradle in IntelliJ
Open the gradle project in IntelliJ IDE.
Click View-> Tool Windows-> Gradle to open gradle projects. 
Click on the icon 'Execute Gradle Task'.
Under 'Gradle project' choose the Gradle project for execution.
Under 'Command line',
        To build sample : build  (or) jar (this generates an executable jar file under build/libs folder)
        To run : clean build RunJar
Click OK to run the sample.
