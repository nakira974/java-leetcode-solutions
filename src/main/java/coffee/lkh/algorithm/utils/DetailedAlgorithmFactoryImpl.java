package coffee.lkh.algorithm.utils;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithm;
import coffee.lkh.algorithm.abstractions.DetailedAlgorithmDelegate;
import coffee.lkh.algorithm.abstractions.DetailedAlgorithmFactory;
import coffee.lkh.algorithm.impl.NintendoEncoder;
import org.greenrobot.eventbus.EventBus;

public class DetailedAlgorithmFactoryImpl implements DetailedAlgorithmFactory {

    private final EventBus eventBus;

    public DetailedAlgorithmFactoryImpl(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public DetailedAlgorithm createAlgorithm(String criteria) {
        if ("NintendoEncoderAlgorithm".equals(criteria)) {
            return new DetailedAlgorithmDelegate(eventBus, new NintendoEncoder());
        }
        return null;
    }    
}