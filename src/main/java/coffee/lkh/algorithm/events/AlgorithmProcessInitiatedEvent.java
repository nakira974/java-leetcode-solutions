package coffee.lkh.algorithm.events;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithm;

public class AlgorithmProcessInitiatedEvent extends DetailedAlgorithmEvent {
    public AlgorithmProcessInitiatedEvent(DetailedAlgorithm source) {
        super(source);
    }
}