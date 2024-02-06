package coffee.lkh.algorithm.tests;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithmDelegate;
import coffee.lkh.algorithm.impl.companies.bfs.LevelOrder;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
