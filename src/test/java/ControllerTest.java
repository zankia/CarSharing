import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

import fr.zankia.carsharing.Controller;
import fr.zankia.carsharing.process.Algorithm;
import fr.zankia.carsharing.process.Deterministic;
import fr.zankia.carsharing.process.Genetic;
import fr.zankia.carsharing.process.SimulatedAnnealing;

public class ControllerTest {
    @Test
    public void testControllerIsUnique() {
        assertNotNull(Controller.getInstance(),
                "Controller should be initialized");

        assertSame(Controller.getInstance(), Controller.getInstance(),
                "Controller should be unique");
    }

    @Test
    public void testAlgorithmSelection() {
        Algorithm algorithm = new Deterministic();
        Controller instance = Controller.getInstance();
        instance.setAlgorithm(algorithm);
        assertEquals(algorithm.toString(), instance.getAlgorithmName(),
                "setAlgorithm should set Deterministic Algorithm");

        algorithm = new SimulatedAnnealing();
        instance.setAlgorithm(algorithm);
        assertEquals(algorithm.toString(), instance.getAlgorithmName(),
                "setAlgorithm should set Simulated annealing Algorithm");

        algorithm = new Genetic();
        instance.setAlgorithm(algorithm);
        assertEquals(algorithm.toString(), instance.getAlgorithmName(),
                "setAlgorithm should set Genetic Algorithm");
    }
}
