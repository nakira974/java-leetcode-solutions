package coffee.lkh.algorithm.impl.companies.arrays;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithmBase;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class CombinaisonGenerator extends DetailedAlgorithmBase {
    private static final String LIST = "list";
    private static final String COMBINATION = "combination";
    private static final String INDEX = "index";
    private static final String START = "start";

    @Override
    public Map<String, Object> process(Map<String, Object> params) {
        if (!isParametersValid(params)) {
            return null;
        }
        final List<Integer> list = (List<Integer>) params.get(LIST);
        final AtomicIntegerArray combination = (AtomicIntegerArray) params.get(COMBINATION);
        final AtomicInteger index = (AtomicInteger) params.get(INDEX);
        final AtomicInteger start = (AtomicInteger) params.get(START);
        generateCombination(list, combination, index, start);
        return params;
    }

    private void generateCombination(List<Integer> list, AtomicIntegerArray combination, AtomicInteger index, AtomicInteger start) {
        if (index.get() == combination.length()) {
            System.out.print("{ ");
            for (int i = 0; i < combination.length(); i++) {
                System.out.printf(" %d ", combination.get(i));
            }
            System.out.print(" }\n");
        }

        for (int i = start.get(); i < list.size(); i++) {
            combination.set(index.get(), list.get(i));
            generateCombination(list, combination, new AtomicInteger(index.get() + 1), new AtomicInteger(start.get() + 1));
        }

    }

    @Override
    protected boolean isParametersValid(Map<String, Object> params) {
        return params.containsKey(LIST) &&
                params.containsKey(COMBINATION) &&
                params.containsKey(INDEX) &&
                params.containsKey(START) &&
                params.get(LIST) instanceof List &&
                params.get(COMBINATION) instanceof AtomicIntegerArray &&
                params.get(INDEX) instanceof AtomicInteger &&
                params.get(START) instanceof AtomicInteger;
    }
}
