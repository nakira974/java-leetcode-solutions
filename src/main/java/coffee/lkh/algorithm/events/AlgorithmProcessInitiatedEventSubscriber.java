package coffee.lkh.algorithm.events;

import org.greenrobot.eventbus.Subscribe;

public class AlgorithmProcessInitiatedEventSubscriber {
    @Subscribe
    public void onAlgorithmProcessInitiated(AlgorithmProcessInitiatedEvent event) {
        System.out.printf("Algorithm %s launched%n", event.getSource().getClass().getSimpleName());
    }
}