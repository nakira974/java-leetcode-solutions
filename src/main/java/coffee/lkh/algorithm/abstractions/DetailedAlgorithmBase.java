package coffee.lkh.algorithm.abstractions;

import java.util.Map;

public abstract class DetailedAlgorithmBase implements DetailedAlgorithm{
    public abstract void process(Map<String, Object> params);
    protected abstract boolean isParametersValid(Map<String, Object> params);
}
