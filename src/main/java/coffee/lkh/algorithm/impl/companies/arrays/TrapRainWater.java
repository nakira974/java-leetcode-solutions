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
    public int trap(int[] height) {
        int n = height.length;
        int result = 0;
        int left = 0;
        int right = n - 1;
        int leftMax = 0; // Keeps track of the maximum height on the left side
        int rightMax = 0; // Keeps track of the maximum height on the right side

        while (left < right) {
            if (height[left] <= height[right]) { // If the height at the left pointer is smaller or equal
                if (height[left] >= leftMax) { // Check if it is the new maximum height on the left side
                    leftMax = height[left]; // Update the left maximum
                } else {
                    result += leftMax - height[left]; // Add the trapped water between the left maximum and current height
                }
                left++; // Move the left pointer to the right
            } else { // If the height at the right pointer is smaller
                if (height[right] >= rightMax) { // Check if it is the new maximum height on the right side
                    rightMax = height[right]; // Update the right maximum
                } else {
                    result += rightMax - height[right]; // Add the trapped water between the right maximum and current height
                }
                right--; // Move the right pointer to the left
            }
        }

        return result; // Return the total amount of water trapped
    }

}
