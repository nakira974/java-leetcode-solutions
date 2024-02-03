package coffee.lkh.algorithm.impl.companies.amazon;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithmBase;

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
        int counter = 0;
        int lastStartIndex =0 ;
        StringBuffer temp = new StringBuffer();
        temp.append("");
        for(int i=0;i<s.length();i++){
            temp.append(s.toCharArray()[i]);
            while(lastStartIndex<s.length()){
                boolean valid = true;
                for(int j=0;j<temp.length();j++){
                    if(temp.charAt(j) == s.toCharArray()[i] ){
                        valid = false;
                        break;
                    }
                }
                lastStartIndex++;
                if(valid) temp.append(s.toCharArray()[i++]);
                else continue;
            }
            counter++;
            temp.delete(0, temp.length());
        }
        return counter;
    }
}
