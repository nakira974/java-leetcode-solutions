package coffee.lkh.algorithm.impl.companies;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithmBase;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.stream.IntStream;

public class MergeArraySorted extends DetailedAlgorithmBase {
    private static final String NUMS1 = "nums1";
    private static final String NUMS2 = "nums2";
    private static final String M = "m";
    private static final String N = "n";

    @Override
    public Map<String, Object> process(Map<String, Object> params) {
        if(!isParametersValid(params)){
            return null;
        }
        final AtomicIntegerArray nums1 =  (AtomicIntegerArray) params.get(NUMS1);
        final AtomicIntegerArray nums2 = (AtomicIntegerArray) params.get(NUMS2);
        final AtomicInteger m = (AtomicInteger) params.get(M);
        final AtomicInteger n = (AtomicInteger) params.get(N);
        int[] nums1Final = new int[nums1.length()];
        int[] nums2Final = new int[nums2.length()];
        for(int i =0; i<nums1.length();i++){
            nums1Final[i] = nums1.get(i);
        }
        for(int i =0; i<nums2.length();i++){
            nums2Final[i] = nums2.get(i);
        }
        merge(nums1Final, m.get(), nums2Final, n.get());

        return params;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m+n];

        if (m >= 0) System.arraycopy(nums1, 0, result, 0, m);
        int index = 0;
        for(int i=m; i< m+n; i++){
            if(index<nums2.length){
                result[i] = nums2[index];
                index++;
            }
        }
        filter(result);
        System.arraycopy(result,0,nums1, 0, result.length);
    }

    private void filter(int[] array) {
        int n = array.length;

        for (int i = 0; i < n-1; i++) {
            int maxIndex = i;

            for (int j = i+1; j < n; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }

            int temp = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = temp;
        }
    }

    @Override
    protected boolean isParametersValid(Map<String, Object> params) {
        return params.containsKey(NUMS1) &&
                params.containsKey(NUMS2)&&
                params.containsKey(M) &&
                params.containsKey(N) &&
                params.get(NUMS1) instanceof AtomicIntegerArray &&
                params.get(NUMS2) instanceof AtomicIntegerArray &&
                params.get(M) instanceof AtomicInteger &&
                params.get(N) instanceof AtomicInteger;
    }
}
