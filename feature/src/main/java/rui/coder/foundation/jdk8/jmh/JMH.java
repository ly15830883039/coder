package rui.coder.foundation.jdk8.jmh;

import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import org.openjdk.jmh.annotations.*;

import java.nio.charset.Charset;

/**
 * @author 赵睿
 */
public class JMH {

    @Benchmark
    @Fork(value = 1,warmups =2)
    @BenchmarkMode(Mode.AverageTime)
    public void init(){

    }


    @Fork(value = 1, warmups = 1)
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void benchMurmur3_128(ExecutionPlan plan) {
        for (int i = plan.iterations; i > 0; i--) {
            plan.murmur3.putString(plan.password, Charset.defaultCharset());
        }

        plan.murmur3.hash();
    }

    @State(Scope.Benchmark)
    public static class ExecutionPlan {

        @Param({ "100", "200", "300", "500", "1000" })
        public int iterations;

        public Hasher murmur3;

        public String password = "4v3rys3kur3p455w0rd";

        @Setup(Level.Invocation)
        public void setUp() {
            murmur3 = Hashing.murmur3_128().newHasher();
        }
    }




}
