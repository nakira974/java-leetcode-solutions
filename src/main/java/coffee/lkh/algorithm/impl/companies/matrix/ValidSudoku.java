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

        int rowsCount = board.length;
        int columnsCount = board[0].length;
        if (rowsCount != 9 || columnsCount != 9) {
            return false;
        }
        return checkDuplicates(board);
    }

    public boolean checkDuplicates(char[][] board) {
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (hasDuplicate(board, i, j)) {
                    return true; // Duplicate found within the 3x3 subgrid
                }
            }
        }
        return false; // No duplicates found in any of the 3x3 subgrids
    }

    private boolean hasDuplicate(char[][] board, int rowStart, int colStart) {
        Set<Character> uniqueChars = new HashSet<>();
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                char currentChar = board[i][j];
                if (String.valueOf(currentChar).equals("."))
                    continue;
                if (uniqueChars.contains(currentChar) || Integer.parseInt(String.valueOf(currentChar)) > 9) {
                    return false;
                } else {
                    uniqueChars.add(currentChar);
                }
            }
        }
        return true; // No duplicates found within the subgrid
    }

}
