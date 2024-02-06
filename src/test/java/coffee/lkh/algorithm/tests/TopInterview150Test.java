package coffee.lkh.algorithm.tests;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithmDelegate;
import coffee.lkh.algorithm.impl.companies.Candy;
import coffee.lkh.algorithm.impl.companies.JumpGame2;
import coffee.lkh.algorithm.impl.companies.MergeKSortedList;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicIntegerArray;

import static coffee.lkh.algorithm.impl.companies.MergeKSortedList.ListNode;

public class TopInterview150Test {


    @Test
    public void testCandy() {
        final Map<String, Object> parameters = new HashMap<>();

        parameters.put("ratings", new int[]{1, 3, 2, 2, 1});

        final DetailedAlgorithmDelegate delegate = new DetailedAlgorithmDelegate(new Candy());
        delegate.process(parameters);
        int result = (Integer) parameters.get("result");

        System.out.printf("The result of candy is %d%n", result);
    }

    @Test
    public void testJumpGame2() {
        final Map<String, Object> parameters = new HashMap<>();

        parameters.put("nums", new AtomicIntegerArray(new int[]{2, 3, 1, 1, 4}));

        final DetailedAlgorithmDelegate delegate = new DetailedAlgorithmDelegate(new JumpGame2());
        delegate.process(parameters);
        int result = (Integer) parameters.get("result");

        System.out.printf("The result of jump game 2 is %d%n", result);
    }

    @Test
    public void testMergeKSortedList() {
        final Map<String, Object> parameters = new HashMap<>();

        ListNode nodeA1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode nodeB1 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode nodeC1 = new ListNode(2, new ListNode(6));

        ListNode[] nodes = {nodeA1, nodeB1, nodeC1};
        parameters.put("lists", nodes);

        final DetailedAlgorithmDelegate delegate = new DetailedAlgorithmDelegate(new MergeKSortedList());
        delegate.process(parameters);
        ListNode result = (ListNode) parameters.get("result");
        System.out.println("The result of k merged sorted list is :");
        System.out.print("{");
        while (result != null) {
            System.out.printf(" %d ", result.getVal());
            result = result.getNext();
        }
        System.out.printf("}%n");
    }
}
