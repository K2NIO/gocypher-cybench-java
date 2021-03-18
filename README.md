# What is CyBench Launcher

**CyBench Launcher** is a standalone Java application designed to execute [JMH](https://openjdk.java.net/projects/code-tools/jmh/) benchmarks. 
Speed-test Java classes, collections, modules, libraries and other application building blocks under varying runtime conditions. 
Share your results with the community, compare and choose the right libraries for your application. 
**CyBench** helps developers build better, faster Java code by benchmarking code performance.

CyBench Launcher contains a set of default performance tests developed by the CyBench team to benchmark Java Core services. These tests are executed by default every time CyBench benchmarks are executed via `cybench` shell script and results are automatically submitted to a public [CyBench Repository](https://www.gocypher.com/cybench/).

Default benchmark execution and automated reporting can be configured via `<cybench-home>/conf/cybench-launcher.properties`
Download and run CyBench [here](https://github.com/K2NIO/gocypher-cybench-java/releases).  Visit our [page](https://www.gocypher.com/cybench/) to analyze your results.

## Building CyBench Benchmark From Source
```sh
mvn clean package -P build-jvm,pack-bin
```
## Running Default Benchmarks using CyBench

After downloading the `gocypher-cybench-java-1.0.0.zip` from the [release page](https://github.com/K2NIO/gocypher-cybench-java/releases) extract the files and run `cybench.bat` (on Windows) or `cybench.sh` (on Unix).

## CyBench launcher configuration

Configuration located in file `<cybench-home>/conf/cybench-launcher.properties`

| Property name        | Description           | Default value  |
| ------------- |-------------| -----:|
| **javaOptions**      | All the property fields that starts with name javaOptions will be used while benchmarking as JVM properties. | - |
| **javaToUsePath**      | Provide full path to java.exe to be used e.g. D:/jdk180_162/bin/java.exe  | - |
| **benchmarks**| Provide jar's with JMH benchmarks which shall be executed with CyBench | - |
| **sendReport**| Choose if the report generated will be automatically uploaded. (true/false)  | true |
| **reportUploadStatus**| Define public or private property for the uploaded report visibility.  | public |
| **reportName**| Choose the uploaded report name. E.g. | - |
| **benchmarkClasses**| Specify benchmarks by including fully qualified benchmark class names which are comma separated. For more information [here](#execute-only-custom-benchmarks)| - |
| **numberOfBenchmarkForks**| Number of separate full executions of a benchmark (warm up+measurement), this is returned still as one primary score item. | 1 |
| **measurementIterations** | Number of measurements per benchmark operation, this is returned still as one primary score item. | 5 |
| **warmUpIterations**| Number of iterations executed for warm up.  |  1 |
| **warmUpSeconds**|  Number of seconds dedicated for each warm up iteration.  |  5  |
| **runThreadCount**| Number of threads for benchmark test execution. |  1 |
| **benchmarkMetadata**| A property which adds extra properties to the benchmarks report such as category or version or context. Configuration pattern is `<fully qualified benchmark class name>=<key1>:<value1>;<key2>:<value2>`. Example which adds category for class CollectionsBenchmarks: `com.gocypher.benchmarks.client.CollectionsBenchmarks=category:Collections;`   |   -  |
| **userProperties**| User defined properties which will be added to benchmarks report section `environmentSettings->userDefinedProperties` as key/value strings. Configuration pattern:`<key1>:<value1>;<key2>:<value2>`. Example which adds a project name:`user.propname1=My Test Project;` |  -  |
| **benchAccessToken** | By providing the "bench" token that you get after creating a workspace in CyBench UI, you can send reports to your private directory, which will be visible only to the users that you authorize. | - |

## Running User-defined Benchmarks using CyBench

### Add Your Benchmark to CyBench Launcher

Attachment and execution of user-defined benchmarks using CyBench launcher:
 * Build a `jar` file with your benchmarks containing `jmh` compiled classes and dependencies.
 * Copy benchmark `jar` file to `<cybench-home>/benchmarks` (where `gocypher-cybench-jvm.jar` resides)
 * [Configure CyBench Launcher](#adding-custom-benchmarks-for-execution) to execute your benchmarks

**NOTE**:
* Custom benchmarks must be implemented using `JMH` framework
* Exported `jar` must contain `class` files generated by `JMH` framework (`jar` file must contain a folder `jmh_generated` with classes having `jmh` suffix ).
* If any files are created during tests (test data files, results files) run they must be deleted after the iteration when benchmark finishes

### Adding Custom Benchmarks for Execution

Update CyBench Launcher configuration located in `<cybench-home>/conf/cybench-launcher.properties`:

* __required__: add or update property `benchmarks`, set path to jar file which contains your JMH benchmark, this path will be added to the `CLASSPATH` of the JVM. Values must be semicolon separated!  

    Rule:
    ```properties
    benchmarks=<path to custom jar file1>;<path to custom jar file2>;
    ```
    
    Example:
    ```properties
    benchmarks=gocypher-cybench-custom-1.0.0.jar;
    ```

* __optional__: register categories for your tests in order to have correct tests classification and better readability and comparison in CyBench portal. If not set then default value (`Custom`) will be written and all custom tests will reside under this category. Values of different classes must be semicolon separated!

    Rule:
    ```properties
    benchmarkMetadata=<fully classified benchmark class name>=category:<category name>;\
      <fully classified benchmark class name>=category:<category name>;
    ```
       
    Example:
    ```properties
    benchmarkMetadata=com.gocypher.benchmarks.client.CollectionsBenchmarks=category:Collections;
    ```
    
### Execute Only Custom Benchmarks

Update CyBench configuration in order to run only user-defined tests:
* add or update property `benchmarkClasses`, specify class names of tests which shall be executed (values must be comma separated).
    
    Rule:
    ```properties
    benchmarkClasses=<fully qualified class name, or class name>,<fully qualified class name, or class name>
    ```
    Example:
    ```properties
    benchmarkClasses=com.gocypher.benchmarks.client.CollectionsBenchmarks,NumberBenchmarks
    ```

    
