package coffee.lkh.algorithm.events;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithm;

public abstract class DetailedAlgorithmEvent {
    private final DetailedAlgorithm source;

    public DetailedAlgorithmEvent(DetailedAlgorithm source) {
        this.source = source;
    }

    public DetailedAlgorithm getSource() {
        return source;
    }
}