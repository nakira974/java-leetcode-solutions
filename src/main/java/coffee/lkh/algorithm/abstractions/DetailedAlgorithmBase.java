package coffee.lkh.algorithm.abstractions;

import java.util.Map;

public abstract class DetailedAlgorithmBase implements DetailedAlgorithm{
    public abstract Map<String, Object> process(Map<String, Object> params);
    protected abstract boolean isParametersValid(Map<String, Object> params);
}
