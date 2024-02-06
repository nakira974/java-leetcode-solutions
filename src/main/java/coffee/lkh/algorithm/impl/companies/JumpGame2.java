package coffee.lkh.algorithm.impl.companies;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithmBase;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class JumpGame2 extends DetailedAlgorithmBase {
    private static final String NUMS = "nums";

    @Override
    public Map<String, Object> process(Map<String, Object> params) {
        if (!isParametersValid(params)) {
            throw new RuntimeException("Params of JumGame2 are incorrect!");
        }
        final AtomicIntegerArray numsParam = (AtomicIntegerArray) params.get(NUMS);
        int[] nums = new int[numsParam.length()];
        for (int i = 0; i < numsParam.length(); i++) {
            nums[i] = numsParam.get(i);
        }

        params.put("result", jump(nums));

        return params;
    }


    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        final Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(0);

        for (int i = 1; i < n; i++) {
            while (!deque.isEmpty() && i - deque.peekFirst() > nums[deque.peekFirst()]) {
                deque.pollFirst();
            }

            if (!deque.isEmpty()) {
                dp[i] = dp[deque.peekFirst()] + 1;
            }

            while (!deque.isEmpty() && dp[i] <= dp[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);
        }

        return dp[n - 1];
    }

    @Override
    protected boolean isParametersValid(Map<String, Object> params) {
        return params.containsKey(NUMS) && params.get(NUMS) instanceof AtomicIntegerArray;
    }
}
