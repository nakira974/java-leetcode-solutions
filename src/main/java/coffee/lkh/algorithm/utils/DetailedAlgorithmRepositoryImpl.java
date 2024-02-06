package coffee.lkh.algorithm.utils;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithm;
import coffee.lkh.algorithm.abstractions.DetailedAlgorithmRepository;

import java.util.HashMap;
import java.util.Map;

public class DetailedAlgorithmRepositoryImpl implements DetailedAlgorithmRepository {

    private final Map<String, DetailedAlgorithm> algorithmMap = new HashMap<>();

    @Override
    public void addAlgorithm(DetailedAlgorithm algo) {
        algorithmMap.put(algo.getClass().getSimpleName(), algo);
    }

    @Override
    public DetailedAlgorithm getAlgorithm(String id) {
        return algorithmMap.get(id);
    }
}