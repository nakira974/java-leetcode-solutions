package coffee.lkh.algorithm.impl.companies.nintendo;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithmBase;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class NintendoEncoder extends DetailedAlgorithmBase {
    private static final String SIZE = "size";
    private static final String ARRAY_A = "arrayA";
    private static final String ARRAY_B = "arrayB";

    @Override
    public Map<String, Object> process(Map<String, Object> params) {
        if (!isParametersValid(params)) {
            throw new IllegalArgumentException("Parameters are not valid");
        }

        // Existing query creation logic
        final String[] query = createHexStringArray((String) params.get(ARRAY_A));
        final AtomicReference<BigInteger[]> resultArray = (AtomicReference<BigInteger[]>) params.get(ARRAY_B);
        try {
            // changed to BigInteger to handle larger unsigned long values
            final BigInteger[] a = Arrays.stream(query).map(x -> new BigInteger(x, 16)).toArray(BigInteger[]::new);
            final int size = a.length;
            // change b to BigInteger array
            final BigInteger[] b = new BigInteger[size];
            Arrays.fill(b, BigInteger.valueOf(0));

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    long temp = ((a[i / 32].longValue() >> (i % 32)) & (a[j / 32 + size / 32].longValue() >> (j % 32)) & 1) << ((i + j) % 32);
                    b[(i + j) / 32] = b[(i + j) / 32].xor(BigInteger.valueOf(temp));
                }
            }

            // Putting 'b' now into params, assuming it holds the converted array
            ((AtomicReference<BigInteger[]>) params.get("arrayB")).set((b));
            params.put("hex_chars", a);
        } catch (Exception ex) {
            throw new IllegalArgumentException("String length superior to 256!", ex);
        }

        return params;
    }

    public int[] convertToHexArray(String input) throws Exception {

        int[] hexArray = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            hexArray[i] = Integer.parseInt(Character.toString(c), 16);
        }

        return hexArray;
    }

    public String[] createHexStringArray(String input) {
        final String[] hexStrings = new String[input.length()];
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            hexStrings[i] = Integer.toHexString(c);
        }
        return hexStrings;
    }

    @Override
    protected boolean isParametersValid(Map<String, Object> params) {
        return params.containsKey(SIZE)
                && params.containsKey(ARRAY_A)
                && params.containsKey(ARRAY_B)
                && params.get(SIZE) instanceof AtomicInteger
                && params.get(ARRAY_A) instanceof String
                && params.get(ARRAY_B) instanceof AtomicReference;
    }
}