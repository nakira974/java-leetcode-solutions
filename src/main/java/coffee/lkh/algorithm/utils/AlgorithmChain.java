package coffee.lkh.algorithm.utils;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithm;

import java.util.LinkedList;
import java.util.Map;

public class AlgorithmChain {
    private final LinkedList<DetailedAlgorithm> chain;
    private final Map<String, Object> initialParams;

    public AlgorithmChain(Map<String, Object> initialParams) {
        this.chain = new LinkedList<>();
        this.initialParams = initialParams;
    }

    public void addAlgorithm(DetailedAlgorithm algo) {
        chain.addLast(algo);
    }

    public Map<String, Object> execute() {
        Map<String, Object> params = initialParams;

        while (!chain.isEmpty()) {
            DetailedAlgorithm currentAlgorithm = chain.removeFirst();
            params = currentAlgorithm.process(params);
        }

        return params;
    }
}