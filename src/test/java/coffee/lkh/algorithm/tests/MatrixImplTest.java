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

        System.out.printf("The result of validSudoku is %b%n", result);
    }

    public char[][] getWrongSudokuArray() {
        return new char[][]{
                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
    }
}
