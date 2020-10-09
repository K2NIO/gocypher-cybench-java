# What is CyBench

**CyBench** is a Java Benchmark based on [JMH](https://openjdk.java.net/projects/code-tools/jmh/), designed to help developers build high performance Java apps. 
Speed-test Java classes, collections, modules, libraries and other application building blocks under varying runtime conditions. 
Share your results with the community, compare and choose the right libraries for your application. **CyBench** helps you be a better developer.

Download and run CyBench [here](https://www.gocypher.com/cybench/downloads).

# Building CyBench Benchmark
```sh
mvn clean package -P build-jvm,pack-bin
```

# Running User-defined Benchmarks using CyBench

## CyBench Launcher

The CyBench Launcher contains a set of performance tests developed by the CyBench team to benchmark Java Core services. These tests are are executed by default every time CyBench benchmark is executed via `benchmark_run` script and results are automatically submitted to a public [CyBench Repository](https://www.gocypher.com/cybench/).
Default benchmark execution and automated reporting can be configured via `<cybench-home>/conf/cybench-launcher.properties`

### CyBench launcher configuration

Configuration located in file `<cybench-home>/conf/cybench-launcher.properties`

TBD.

### Add Your Benchmark to CyBench Launcher

Attachment and execution of user-defined benchmarks using CyBench launcher:
 * Build a `jar` file with your benchmarks containing `jmh` compiled classes and dependecies
 * Copy benchmark `jar` file to `<cybench-home>` (where `gocypher-benchmarks-client.jar` resides)
 * Configure CyBench Launcher to execute your benchmarks

**NOTE**:
* Custom benchmarks must be implemented using `JMH` framework
* Exported `jar` must contain `class` files generated by `JMH` framework (`jar` file must contain a folder `jmh_generated` with classes having `jmh` suffix ).
* If any files are created during tests (test data files, results files) run they must be deleted after the iteration when benchmark finishes

### Adding Custom Benchmarks for Execution

Update CyBench Launcher configuration located in `<cybench-home>/conf/gocypher-benchmark-client-configuration.properties`:

* __required__: add or update property `customBenchmarks`, set path to jar file which contains your custom benchmark, this path will be added to the `CLASSPATH` of the JVM. Values must be semicolon separated!  

    Rule:
    ```properties
    customBenchmarks=<path to custom jar file1>;<path to custom jar file2>;
    ```
    
    Example:
    ```properties
    customBenchmarks=gocypher-benchmarks-custom-1.0.0.jar;
    ```

* __optional__: register categories for your tests in order to have correct tests classification and better readability and comparison in CyBench portal. If not set then default value (`Custom`) will be written and all custom tests will reside under this category. Values of different classes must be semicolon separated!

    Rule:
    ```properties
    customBenchmarkMetadata=<fully classified benchmark class name>=category:<category name>;\
      <fully classified benchmark class name>=category:<category name>;
    ```
       
    Example:
    ```properties
    customBenchmarkMetadata=com.gocypher.benchmarks.client.CollectionsBenchmarks=category:Collections;
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

    
