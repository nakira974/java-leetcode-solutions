package coffee.lkh.algorithm.tests;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithmDelegate;
import coffee.lkh.algorithm.impl.companies.Candy;
import coffee.lkh.algorithm.impl.companies.CombinaisonGenerator;
import coffee.lkh.algorithm.impl.companies.MergeKSortedList;
import coffee.lkh.algorithm.impl.companies.amazon.KFactorsOfN;
import coffee.lkh.algorithm.impl.companies.amazon.OptimalPartitionString;
import org.greenrobot.eventbus.EventBus;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;

import static coffee.lkh.algorithm.impl.companies.MergeKSortedList.*;

public class AmazonSpring2023Tests {
    @Test
    public void testKthFactor() {
        final Map<String, Object> parameters = new HashMap<>();
        final AtomicInteger k = new AtomicInteger(0);
        final AtomicInteger n = new AtomicInteger(0);

        parameters.put("k",k);
        parameters.put("n", n);

        final EventBus bus = new EventBus();
        final DetailedAlgorithmDelegate delegate = new DetailedAlgorithmDelegate(bus, new CombinaisonGenerator());
        delegate.process(parameters);
    }

    @Test
    public void testPartitionString(){
        final Map<String, Object> parameters = new HashMap<>();
        final AtomicReference<String> s = new AtomicReference<>("gizfdfri");

        parameters.put("s",s);

        final EventBus bus = new EventBus();
        final DetailedAlgorithmDelegate delegate = new DetailedAlgorithmDelegate(bus, new OptimalPartitionString());
        delegate.process(parameters);
        int result = (Integer) parameters.get("result");

        System.out.printf("The result of partition string is %d%n", result);
    }

    @Test
    public void testCandy(){
        final Map<String, Object> parameters = new HashMap<>();

        parameters.put("ratings",new int[]{1,3,2,2,1});

        final EventBus bus = new EventBus();
        final DetailedAlgorithmDelegate delegate = new DetailedAlgorithmDelegate(bus, new Candy());
        delegate.process(parameters);
        int result = (Integer) parameters.get("result");

        System.out.printf("The result of candy is %d%n", result);
    }

    @Test
    public void testMergeKSortedList(){
        final Map<String, Object> parameters = new HashMap<>();

        ListNode nodeA1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode nodeB1 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode nodeC1 = new ListNode(2, new ListNode(6));

        ListNode[] nodes = {nodeA1, nodeB1, nodeC1};
        parameters.put("lists",nodes);

        final EventBus bus = new EventBus();
        final DetailedAlgorithmDelegate delegate = new DetailedAlgorithmDelegate(bus, new MergeKSortedList());
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
