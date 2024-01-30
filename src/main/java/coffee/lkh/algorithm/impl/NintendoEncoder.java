package coffee.lkh.algorithm.impl;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithmBase;

import java.util.Map;

public class NintendoEncoder extends DetailedAlgorithmBase {
    private static final String SIZE = "size";
    private static final String ARRAY_A = "arrayA";
    private static final String ARRAY_B = "arrayB";
    
    @Override
    public void process(Map<String, Object> params) {
        if (!isParametersValid(params)) {
            throw new IllegalArgumentException("Parameters are not valid");
        }
        
        int size = (int) params.get(SIZE);
        int[] a = (int[]) params.get(ARRAY_A);
        int[] b = (int[]) params.get(ARRAY_B);
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                b[(i+j)/32] ^= ((a[i/32] >> (i%32)) & (a[j/32 + size/32] >> (j%32)) & 1) << ((i+j)%32);
            }
        }
    }

    @Override
    protected boolean isParametersValid(Map<String, Object> params) {
        return params.containsKey(SIZE)
                && params.containsKey(ARRAY_A)
                && params.containsKey(ARRAY_B)
                && params.get(SIZE) instanceof Integer
                && params.get(ARRAY_A) instanceof int[]
                && params.get(ARRAY_B) instanceof int[];
    }
}