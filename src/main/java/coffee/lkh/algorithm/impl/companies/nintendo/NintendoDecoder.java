package coffee.lkh.algorithm.impl.companies.nintendo;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithmBase;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class NintendoDecoder extends DetailedAlgorithmBase {
    private static final String SIZE = "size";
    private static final String ARRAY_A = "arrayA";
    @Override
    public Map<String, Object> process(Map<String, Object> params) {
        if (!isParametersValid(params)) {
            throw new IllegalArgumentException("32");
        }
        final AtomicInteger size = (AtomicInteger) params.get(SIZE);
        final AtomicIntegerArray encryptedQuery = (AtomicIntegerArray) params.get(ARRAY_A);

        return params;
    }

    @Override
    protected boolean isParametersValid(Map<String, Object> params) {
        return params.containsKey(SIZE)
                && params.containsKey(ARRAY_A)
                && params.get(SIZE) instanceof AtomicInteger
                && params.get(ARRAY_A) instanceof AtomicIntegerArray;
    }
}
