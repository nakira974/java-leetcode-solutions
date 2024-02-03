package coffee.lkh.algorithm.impl.companies.amazon;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithmBase;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class KFactorsOfN extends DetailedAlgorithmBase {
    private static final String K = "k";
    private static final String N = "n";

    public int[] getFactors(int number){
        final List<Integer> result = new ArrayList<>();
        helper(number,1,result);
        return result.stream().mapToInt(x->x).toArray();
    }

    private void helper(int number, int current, List<Integer> factors){
        if( current > (int)Math.sqrt(number)){
            return;
        }

        if(number % current == 0){
            factors.add(current);
            int switchValue = number / current;
            if(current != switchValue){
                factors.add(switchValue);
            }
        }
        helper(number, current+1,factors);
    }
    public int kthFactor(int n, int k) {
        int[] factors = getFactors(n);
        Arrays.sort(factors);
        if(k<=factors.length){
            return factors[k-1];
        }
        return -1;
    }

    @Override
    public Map<String, Object> process(Map<String, Object> params) {
        if(!isParametersValid(params)){
            return null;
        }
        final AtomicInteger k = (AtomicInteger) params.get(K);
        final AtomicInteger n = (AtomicInteger) params.get(N);

        params.put("result", kthFactor(k.get(),n.get()));
        return params;
    }

    @Override
    protected boolean isParametersValid(Map<String, Object> params) {
        return params.containsKey(N) &&
                params.containsKey(K)&&
                params.get(K) instanceof AtomicInteger &&
                params.get(N) instanceof AtomicInteger;
    }
}
