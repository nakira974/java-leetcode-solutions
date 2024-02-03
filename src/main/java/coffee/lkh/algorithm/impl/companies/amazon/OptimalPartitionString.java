package coffee.lkh.algorithm.impl.companies.amazon;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithmBase;

import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class OptimalPartitionString extends DetailedAlgorithmBase {
    private static final String S = "s";

    @Override
    public Map<String, Object> process(Map<String, Object> params) {
        if(!isParametersValid(params)){
            return null;
        }
        final AtomicReference<String> s = (AtomicReference<String>) params.get(S);

        params.put("result", partitionString(s.get()));
        return params;
    }

    @Override
    protected boolean isParametersValid(Map<String, Object> params) {
        return params.containsKey(S) &&
                params.get(S) instanceof AtomicReference<?>;
    }

    /**Given a string s, partition the string into one or more substrings such that the characters in each substring are unique. That is, no letter appears in a single substring more than once.

     @return the minimum number of substrings in such a partition.

     @apiNote  each character should belong to exactly one substring in a partition.*/

    public int partitionString(String s) {
        int stringLength = s.length();
        int bitmask = 0;
        int numParts = 1;
        byte[] characters = new byte[stringLength];
        s.getBytes(0, stringLength, characters, 0);

        for (byte currentChar : characters) {
            int charMask = 1 << currentChar;

            if ((bitmask & charMask) != 0) {
                ++numParts;
                bitmask = charMask;
            } else {
                bitmask |= charMask;
            }
        }

        return numParts;
    }
}
