package coffee.lkh.algorithm.abstractions;

public interface DetailedAlgorithmRepository {
    void addAlgorithm(DetailedAlgorithm algo);

    DetailedAlgorithm getAlgorithm(String id);
}