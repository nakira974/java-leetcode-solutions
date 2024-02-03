package coffee.lkh.algorithm.tests;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithmDelegate;
import coffee.lkh.algorithm.impl.companies.CombinaisonGenerator;
import org.greenrobot.eventbus.EventBus;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class CommonAlgoTests {

    @Test
    public void testRecursiveAlgo() {
        final Map<String, Object> parameters = new HashMap<>();
        final List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(23);
        list.add(128);
        final AtomicIntegerArray combination = new AtomicIntegerArray(list.size());
        final AtomicInteger index = new AtomicInteger(0);
        final AtomicInteger start = new AtomicInteger(0);
        parameters.put("list", list);
        parameters.put("combination",combination);
        parameters.put("index", index);
        parameters.put("start", start);

        final EventBus bus = new EventBus();
        final DetailedAlgorithmDelegate delegate = new DetailedAlgorithmDelegate(bus, new CombinaisonGenerator());
        delegate.process(parameters);
    }

}
