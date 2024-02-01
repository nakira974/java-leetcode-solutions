package coffee.lkh.algorithm.abstractions;

import java.util.Map;

@FunctionalInterface
public interface DetailedAlgorithm {
    Map<String, Object> process(Map<String, Object> params);
}