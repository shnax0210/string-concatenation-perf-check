# Simple project to check if using StringBuilder is still reasonable in some cases (mainly loops)

## How to run

1) Install java 13 (it can be more new version, but then pom.xml needs to be modified, I just have java 13 on my current
   PC);
2) Install maven;
3) Build jar file: `mvn clean package`
4) Run benchmarks: `java -jar target/string-concatenation-perf-check-1.0-SNAPSHOT.jar`

## Result example

The result is run on MacBook Pro with M1 processor:

| Benchmark                               | Mode | Cnt | Score | Error   | Units |
|-----------------------------------------|------|-----|-------|---------|-------|
| StringBenchmark.testStringBuilder       | avgt | 5   | 0.001 | ± 0.001 | ms/op |
| StringBenchmark.testStringConcatenation | avgt | 5   | 0.018 | ± 0.001 | ms/op |

So, as per result StringBuilder is 0.018 / 0.001 = 18 times faster than string concatenation if we have a loop with 1000
iterations.

If we update the loop to have 10000 iterations (org.example.StringBenchmark.NUMBER_OF_ITERATIONS):

| Benchmark                               | Mode | Cnt | Score | Error   | Units |
|-----------------------------------------|------|-----|-------|---------|-------|
| StringBenchmark.testStringBuilder       | avgt | 5   | 0.011 | ± 0.001 | ms/op |
| StringBenchmark.testStringConcatenation | avgt | 5   | 1.857 | ± 0.119 | ms/op |

So, as per result StringBuilder is 1.857 / 0.011 = 168 times faster than string concatenation if we have a loop with
10000 iterations.
