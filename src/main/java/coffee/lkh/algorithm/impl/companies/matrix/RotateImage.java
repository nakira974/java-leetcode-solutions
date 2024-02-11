package coffee.lkh.algorithm.impl.companies.matrix;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithmBase;

import java.util.Map;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class RotateImage extends DetailedAlgorithmBase {
    private final static String MATRIX = "matrix";
    @Override
    public Map<String, Object> process(Map<String, Object> params) {
        if (!isParametersValid(params)) {
            throw new RuntimeException("Params of RotateImage are incorrect!");
        }

        final int[][] matrix = (int[][]) params.get(MATRIX);
        rotate(matrix);
        params.put("result", new Void[]{});

        return params;
    }

    public void rotate(int[][] mat) {
        int n=mat.length;
        // Transpose of matrix
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                int t = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = t;
            }

        // Reverse individual rows
        for (int i = 0; i < n; i++) {
            int low = 0, high = n - 1;
            while (low < high) {
                int t = mat[i][low];
                mat[i][low] = mat[i][high];
                mat[i][high] = t;
                low++;
                high--;
            }
        }
    }
    @Override
    protected boolean isParametersValid(Map<String, Object> params) {
        return params.containsKey(MATRIX) && params.get(MATRIX) instanceof int[][];
    }
}
