package coffee.lkh.algorithm.events;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithm;

public class AlgorithmProcessCompletedEvent extends DetailedAlgorithmEvent {
    public AlgorithmProcessCompletedEvent(DetailedAlgorithm source) {
        super(source);
    }
}
