package coffee.lkh.algorithm.tests;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithm;
import coffee.lkh.algorithm.abstractions.DetailedAlgorithmDelegate;
import coffee.lkh.algorithm.impl.NintendoEncoder;
import org.greenrobot.eventbus.EventBus;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class NintendoEncoderTest {

    @Test
    public void testNintendoEncoderAlgorithm() {
        EventBus eventBus = new EventBus();
        DetailedAlgorithm nintendoEncoderAlgorithm = new NintendoEncoder();
        DetailedAlgorithmDelegate delegate = new DetailedAlgorithmDelegate(eventBus, nintendoEncoderAlgorithm);

        int size = 5;  // Initialize as per your requirements
        int[] arrayA = new int[]{1,2,3,4,5};  // Initialize as per your requirements
        int[] arrayB = new int[]{6,7,8,9,10};  // Initialize as per your requirements

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("size", size);
        parameters.put("arrayA", arrayA);
        parameters.put("arrayB", arrayB);

        delegate.process(parameters);

        // Add assertions for expected behavior
    }
}
