package coffee.lkh.algorithm.tests;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithm;
import coffee.lkh.algorithm.abstractions.DetailedAlgorithmDelegate;
import coffee.lkh.algorithm.abstractions.DetailedAlgorithmFactory;
import coffee.lkh.algorithm.abstractions.DetailedAlgorithmRepository;
import coffee.lkh.algorithm.utils.DetailedAlgorithmFactoryImpl;
import coffee.lkh.algorithm.utils.DetailedAlgorithmRepositoryImpl;
import org.greenrobot.eventbus.EventBus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlgoFactoryRepositoryTest {

    DetailedAlgorithmFactory factory;
    DetailedAlgorithmRepository repository;
    DetailedAlgorithmDelegate delegate;

    @BeforeEach
    void setUp() {
        EventBus eventBus = new EventBus();
        factory = new DetailedAlgorithmFactoryImpl(eventBus); // assume we have a factory implementation
        repository = new DetailedAlgorithmRepositoryImpl();  // assume we have a repository implementation

        // Instantiate a DetailedAlgorithmDelegate for each algorithm here:
        String criteria = "NintendoEncoderAlgorithm";  // replace according to actual factory design
        DetailedAlgorithm algorithm = factory.createAlgorithm(criteria);
        delegate = new DetailedAlgorithmDelegate(eventBus, algorithm);
    }

    @Test
    public void testFactory() {
        String criteria = "NintendoEncoderAlgorithm";  // replace according to actual factory design

        DetailedAlgorithm algorithmFromFactory = factory.createAlgorithm(criteria);
        
        assertNotNull(algorithmFromFactory, "The algorithm should not be null");
        assertTrue(algorithmFromFactory instanceof DetailedAlgorithm,
                "The created algorithm should be an instance of DetailedAlgorithm");
    }

    @Test
    public void testRepository() {
        String id = "NintendoEncoderAlgorithm";  // replace according to actual repository design

        DetailedAlgorithm algorithmToSaveInRepo = factory.createAlgorithm(id);
        repository.addAlgorithm(algorithmToSaveInRepo);

        DetailedAlgorithm algorithmFromRepo = repository.getAlgorithm(id);

        assertSame(algorithmToSaveInRepo, algorithmFromRepo, 
                "The algorithm returned from the repository should be the same as the one saved");
    }
    // Add more tests for other functionalities as needed.
}