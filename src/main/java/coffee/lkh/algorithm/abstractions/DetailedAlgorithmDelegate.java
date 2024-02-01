package coffee.lkh.algorithm.abstractions;

import coffee.lkh.algorithm.events.AlgorithmProcessCompletedEvent;
import coffee.lkh.algorithm.events.AlgorithmProcessInitiatedEvent;
import org.greenrobot.eventbus.EventBus;

import java.util.Map;

public class DetailedAlgorithmDelegate implements DetailedAlgorithm {
    private final EventBus eventBus;
    private final DetailedAlgorithm detailedAlgorithm;

    public DetailedAlgorithmDelegate(EventBus eventBus, DetailedAlgorithm detailedAlgorithm) {
        this.eventBus = eventBus;
        this.detailedAlgorithm = detailedAlgorithm;
    }

    @Override
    public Map<String, Object> process(Map<String, Object> params) {
        this.eventBus.post(new AlgorithmProcessInitiatedEvent(this.detailedAlgorithm));
        final Map<String, Object> result = this.detailedAlgorithm.process(params);
        this.eventBus.post(new AlgorithmProcessCompletedEvent(this.detailedAlgorithm));
        return result;
    }
}