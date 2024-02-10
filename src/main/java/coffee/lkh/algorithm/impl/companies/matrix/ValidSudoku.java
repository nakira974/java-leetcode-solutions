package coffee.lkh.algorithm.impl.companies.matrix;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithmBase;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class ValidSudoku extends DetailedAlgorithmBase {

    private static final String BOARD = "board";

    @Override
    public Map<String, Object> process(Map<String, Object> params) {
        if (!isParametersValid(params)) {
            throw new RuntimeException("Invalid validSudoku parameter board !");
        }
        char[][] board = ((char[][]) params.get(BOARD));
        params.put("result", isValidSudoku(board));
        return params;
    }

    @Override
    protected boolean isParametersValid(Map<String, Object> params) {
        return params.containsKey(BOARD) && params.get(BOARD) instanceof char[][];
    }
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        // Array of sets to store unique digits for each row
        final Set<Character>[] rows = new HashSet[n];
        // Array of sets to store unique digits for each column
        final Set<Character>[] columns = new HashSet[n];
        // Array of sets to store unique digits for each 3x3 subgrid
        final Set<Character>[] subgrids = new HashSet[n];

        for (int i = 0; i < n; i++) {
            // Initialize set for each row
            rows[i] = new HashSet<>();
            // Initialize set for each column
            columns[i] = new HashSet<>();
            // Initialize set for each subgrid
            subgrids[i] = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char digit = board[i][j];
                // Skip empty cells
                if (digit != '.') {
                    // Check if the digit is already present in the corresponding row, column, or subgrid
                    // If so, it means there is a duplicate and the Sudoku board is invalid
                    if (!rows[i].add(digit) || !columns[j].add(digit) || !subgrids[i/3 * 3 + j/3].add(digit)) {
                        // Duplicate found, return false
                        return false;
                    }
                }
            }
        }

        // No duplicates found, Sudoku board is valid
        return true;
    }

}
