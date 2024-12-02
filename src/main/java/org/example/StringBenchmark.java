package org.example;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class StringBenchmark {
    public static final int NUMBER_OF_ITERATIONS = 1000;

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Warmup(iterations = 5, time = 1)
    @Measurement(iterations = 100, time = 1)
    @Fork(1)
    public String testStringConcatenation() {
        String str = "";
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            str += "a";
        }
        return str;
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Warmup(iterations = 5, time = 1)
    @Measurement(iterations = 100, time = 1)
    @Fork(1)
    public String testStringBuilder() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            builder.append("a");
        }
        return builder.toString();
    }
}