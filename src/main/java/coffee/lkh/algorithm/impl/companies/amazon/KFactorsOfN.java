package coffee.lkh.algorithm.impl.companies.amazon;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithmBase;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class KFactorsOfN extends DetailedAlgorithmBase {
    private static final String K = "k";
    private static final String N = "n";

        public int kthFactor(int n, int k) {
            int sum =0;
            for(int i=1;i<=n;i++)
            {
                if(n%i==0)
                {
                    sum++;
                }
                if(sum==k)
                {
                    return i;
                }
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
