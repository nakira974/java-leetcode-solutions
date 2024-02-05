package coffee.lkh.algorithm.abstractions;

import coffee.lkh.algorithm.events.AlgorithmProcessCompletedEvent;
import coffee.lkh.algorithm.events.AlgorithmProcessCompletedEventSubscriber;
import coffee.lkh.algorithm.events.AlgorithmProcessInitiatedEvent;
import coffee.lkh.algorithm.events.AlgorithmProcessInitiatedEventSubscriber;
import org.greenrobot.eventbus.EventBus;

import java.util.Map;

public class DetailedAlgorithmDelegate implements DetailedAlgorithm {
    private final EventBus eventBus;
    private final DetailedAlgorithm detailedAlgorithm;

    public DetailedAlgorithmDelegate(EventBus eventBus, DetailedAlgorithm detailedAlgorithm) {
        this.eventBus = eventBus;
        final AlgorithmProcessInitiatedEventSubscriber initiatedSubscriber = new AlgorithmProcessInitiatedEventSubscriber();
        final AlgorithmProcessCompletedEventSubscriber completedSubscriber = new AlgorithmProcessCompletedEventSubscriber();
        this.eventBus.register(initiatedSubscriber);
        this.eventBus.register(completedSubscriber);

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