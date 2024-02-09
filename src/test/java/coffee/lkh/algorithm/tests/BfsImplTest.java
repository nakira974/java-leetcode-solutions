package coffee.lkh.algorithm.tests;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithmDelegate;
import coffee.lkh.algorithm.impl.companies.arrays.CombinaisonGenerator;
import coffee.lkh.algorithm.impl.companies.bfs.LevelOrder;
import coffee.lkh.algorithm.impl.companies.bfs.NumSquares;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class BfsImplTest {

    @Test
    public void levelOrderTest() {
        final Map<String, Object> parameters = new HashMap<>();

        parameters.put("root", new LevelOrder.TreeNode(3, new LevelOrder.TreeNode(9), new LevelOrder.TreeNode(15, new LevelOrder.TreeNode(21), new LevelOrder.TreeNode(9))));

        final DetailedAlgorithmDelegate delegate = new DetailedAlgorithmDelegate(new LevelOrder());
        delegate.process(parameters);
        List<List<Integer>> result = (List<List<Integer>>) parameters.get("result");

        System.out.printf("The result of BFS levelOrder is %n");
        for (List<Integer> innerList : result) {
            for (int num : innerList) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void testNumSquares() {
        final Map<String, Object> parameters = new HashMap<>();
        final AtomicInteger n = new AtomicInteger(12);

        parameters.put("n", n);

        final DetailedAlgorithmDelegate delegate = new DetailedAlgorithmDelegate(new NumSquares());
        delegate.process(parameters);

        int result = (Integer) parameters.get("result");

        System.out.printf("The result of BFS numSquares string is %d%n", result);
    }
}
