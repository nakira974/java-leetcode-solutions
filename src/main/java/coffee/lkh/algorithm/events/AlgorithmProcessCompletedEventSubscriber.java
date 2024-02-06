package coffee.lkh.algorithm.events;

import org.greenrobot.eventbus.Subscribe;

public class AlgorithmProcessCompletedEventSubscriber {
    @Subscribe
    public void onAlgorithmProcessCompleted(AlgorithmProcessCompletedEvent event) {
        System.out.printf("Algorithm %s completed%n", event.getSource().getClass().getSimpleName());
    }
}
