# Practise code for the Coursera course - Algorithms, Part I by Princeton University

###### https://www.coursera.org/learn/algorithms-part1

## 1. Software development tools used

I used Android Studio IDE to write all programs in Java.

#### How to create Java application project in Android Studio

1. Create a build.gradle file with following content.

    ``` gradle

    apply plugin: 'java'

    repositories {
        mavenCentral()
    }

    dependencies {
        testCompile group: "junit", name: "junit", version: "4.+"
    }

    ```

2. Create directories for main java source files.

    ``` bash

    mkdir -p src/main/java

    ```

3. Open created project directory in Android Studio.

    * Click OK button to use Gradle wrapper.

    * Initial gradle build should be successful.

4. Create HelloWorld class.

    * New -> Java Class

    * Name: HelloWorld

    * Click OK button to create HelloWorld class under default package (no any specified Java package).

    * Fill up HelloWorld.java file with content of HelloWorld Java application.

    ``` java

    public class HelloWorld
    {
        public static void main ( String[] args )
        {
            System.out.println ( "Hello, World!" );
        }
    }

    ```

5. Create Run Configuration for this HelloWorld java application.

    * Click on Edit Configurations... option.

    * Add New Configuration -> Select the option - Application.

    * Change name of the new configuration to HelloWorld.

    * Set Main class to HelloWorld.

    * Working directory, Use classpath of module and JRE would be set automatically by Android Studio when Main class was selected.

    * Click OK to set the new configuration.

    * Select the run configuration, Build it.

    * Run HelloWorld.

    * Output should be...

    ```
    Hello, World!

    Process finished with exit code 0
    ```
