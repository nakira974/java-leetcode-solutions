package coffee.lkh.algorithm.tests;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithmDelegate;
import coffee.lkh.algorithm.impl.companies.bfs.LevelOrder;
import coffee.lkh.algorithm.impl.companies.matrix.ValidSudoku;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatrixImplTest {
    @Test
    public void validSudokuTest() {
        final Map<String, Object> parameters = new HashMap<>();

        final DetailedAlgorithmDelegate delegate = new DetailedAlgorithmDelegate(new ValidSudoku());
        parameters.put("board", getWrongSudokuArray());
        delegate.process(parameters);
        Boolean result = (Boolean) parameters.get("result");

        System.out.printf("The result of valid sudoku levelOrder is %b%n", result);
    }

    private String[][] getWrongSudokuArray() {
        return new String[][]{
                {"8", "3", ".", ".", "7", ".", ".", ".", "."},
                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
                {".", "9", "8", ".", ".", ".", ".", "6", "."},
                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
                {".", "6", ".", ".", ".", ".", "2", "8", "."},
                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
                {".", ".", ".", ".", "8", ".", ".", "7", "9"}
        };
    }
}
