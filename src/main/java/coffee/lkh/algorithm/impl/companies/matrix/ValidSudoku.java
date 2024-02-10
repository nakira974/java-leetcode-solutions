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
        final Set<Character>[] rows = new HashSet[n];
        final Set<Character>[] columns = new HashSet[n];
        final Set<Character>[] subgrids = new HashSet[n];

        for (int i = 0; i < n; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            subgrids[i] = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char digit = board[i][j];
                if (digit != '.') {
                    if (!rows[i].add(digit) || !columns[j].add(digit) || !subgrids[i/3 * 3 + j/3].add(digit)) {
                        return false; // Duplicate found
                    }
                }
            }
        }

        return true; // No duplicates found
    }

}
