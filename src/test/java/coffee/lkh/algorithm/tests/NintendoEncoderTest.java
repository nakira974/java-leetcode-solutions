package coffee.lkh.algorithm.tests;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithm;
import coffee.lkh.algorithm.abstractions.DetailedAlgorithmDelegate;
import coffee.lkh.algorithm.impl.companies.nintendo.NintendoEncoder;
import org.greenrobot.eventbus.EventBus;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class NintendoEncoderTest {

    @Test
    public void testNintendoEncoderAlgorithm() {
        final DetailedAlgorithm nintendoEncoderAlgorithm = new NintendoEncoder();
        final DetailedAlgorithmDelegate delegate = new DetailedAlgorithmDelegate(nintendoEncoderAlgorithm);

        AtomicInteger size = new AtomicInteger();  // Initialize as per your requirements
        final AtomicReference<BigInteger[]> arrayB = new AtomicReference<>();

        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("size", size);
        parameters.put("arrayA", "46508fb7 6677e201");
        parameters.put("arrayB", arrayB);

        try{
            delegate.process(parameters);
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }

        System.out.print("--- Original Sequence\n");
        System.out.print("{");
        for (BigInteger encodedChar :(BigInteger[])parameters.get("hex_chars")){
            System.out.printf(" %s ", encodedChar);
        }
        System.out.print("}\n");
        System.out.printf("--- Sequence length : %d%n", arrayB.get().length);
        System.out.print("--- Encrypted Sequence\n");
        System.out.print("{");
        for (BigInteger encodedChar : arrayB.get()){
            System.out.printf(" %s ", Integer.toHexString(encodedChar.intValue()));
        }
        System.out.print("}\n");
        // Add assertions for expected behavior
    }
}
