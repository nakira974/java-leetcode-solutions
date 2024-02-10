package coffee.lkh.algorithm.impl.companies.arrays;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithmBase;

import java.util.Map;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class TrapRainWater extends DetailedAlgorithmBase {
    private static final String HEIGHT = "height";

    @Override
    public Map<String, Object> process(Map<String, Object> params) {
        if (!isParametersValid(params)) {
            throw new RuntimeException("Params of TrapRainWater are incorrect!");
        }
        final AtomicIntegerArray heightParam = (AtomicIntegerArray) params.get(HEIGHT);
        int[] height = new int[heightParam.length()];
        for (int i = 0; i < heightParam.length(); i++) {
            height[i] = heightParam.get(i);
        }

        params.put("result", trap(height));

        return params;
    }

    @Override
    protected boolean isParametersValid(Map<String, Object> params) {
        return params.containsKey(HEIGHT) & params.get(HEIGHT) instanceof AtomicIntegerArray;
    }
    public int trap(int[] heights) {
        int n = heights.length;
        int waterTrapped = 0;
        int left = 0;
        int right = n - 1;
        int leftMaxHeight = 0;
        int rightMaxHeight = 0;

        // Traverse the heights array from both ends until the pointers meet
        while (left < right) {
            // Check if the height at the left pointer is smaller or equal to the height at the right pointer
            if (heights[left] <= heights[right]) {
                // If the current height is greater than or equal to the left maximum height, update it
                if (heights[left] >= leftMaxHeight) {
                    leftMaxHeight = heights[left];
                } else {
                    // Calculate the amount of water trapped at the current position based on the left maximum height
                    waterTrapped += leftMaxHeight - heights[left];
                }
                // Move the left pointer to the right
                left++;
            } else {
                // If the height at the right pointer is greater than or equal to the right maximum height, update it
                if (heights[right] >= rightMaxHeight) {
                    rightMaxHeight = heights[right];
                } else {
                    // Calculate the amount of water trapped at the current position based on the right maximum height
                    waterTrapped += rightMaxHeight - heights[right];
                }
                // Move the right pointer to the left
                right--;
            }
        }

        return waterTrapped;
    }

}
