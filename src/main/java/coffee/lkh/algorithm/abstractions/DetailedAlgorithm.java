package coffee.lkh.algorithm.abstractions;

import java.util.Map;

@FunctionalInterface
public interface DetailedAlgorithm {
    void process(Map<String, Object> params);
}