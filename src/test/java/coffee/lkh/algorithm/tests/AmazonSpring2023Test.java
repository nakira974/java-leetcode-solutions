package coffee.lkh.algorithm.tests;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithmDelegate;
import coffee.lkh.algorithm.impl.companies.CombinaisonGenerator;
import coffee.lkh.algorithm.impl.companies.amazon.OptimalPartitionString;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class AmazonSpring2023Test {
    @Test
    public void testKthFactor() {
        final Map<String, Object> parameters = new HashMap<>();
        final AtomicInteger k = new AtomicInteger(0);
        final AtomicInteger n = new AtomicInteger(0);

        parameters.put("k", k);
        parameters.put("n", n);

        final DetailedAlgorithmDelegate delegate = new DetailedAlgorithmDelegate(new CombinaisonGenerator());
        delegate.process(parameters);
    }

    @Test
    public void testPartitionString() {
        final Map<String, Object> parameters = new HashMap<>();
        final AtomicReference<String> s = new AtomicReference<>("gizfdfri");

        parameters.put("s", s);

        final DetailedAlgorithmDelegate delegate = new DetailedAlgorithmDelegate(new OptimalPartitionString());
        delegate.process(parameters);
        int result = (Integer) parameters.get("result");

        System.out.printf("The result of partition string is %d%n", result);
    }
}
