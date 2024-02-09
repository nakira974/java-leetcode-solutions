package coffee.lkh.algorithm.impl.companies.bfs;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithmBase;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class NumSquares extends DetailedAlgorithmBase {
    private static final String N = "n";


    /**
     * Calculates the minimum number of perfect squares that sum up to a given
     * number.
     *
     * @param n The target number.
     * @return The minimum number of perfect squares that sum up to n.
     */
    public int numSquares(int n) {
        // Create an array to store the minimum number of perfect squares for each
        // number
        int[] dp = new int[n + 1];
        // Initialize the array with maximum values
        Arrays.fill(dp, Integer.MAX_VALUE);
        // Set the base case
        dp[0] = 0;

        // Iterate from 1 to n
        for (int i = 1; i <= n; i++) {
            // Iterate through all possible perfect squares less than or equal to i
            for (int j = 1; j * j <= i; j++) {
                // Update the minimum number of perfect squares for i
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        // Return the minimum number of perfect squares for n
        return dp[n];
    }
    @Override
    public Map<String, Object> process(Map<String, Object> params) {
        if (!isParametersValid(params)) {
            throw new RuntimeException("Invalid BFS numSquares parameter N !");
        }
        int n = ((AtomicInteger) params.get(N)).get();
        params.put("result", numSquares(n));
        return params;
    }

    @Override
    protected boolean isParametersValid(Map<String, Object> params) {
        return params.containsKey(N) && params.get(N) instanceof AtomicInteger;
    }
}
