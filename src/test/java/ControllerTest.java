import fr.zankia.carsharing.Controller;
import fr.zankia.carsharing.process.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class ControllerTest {
    @Test
    public void testControllerIsUnique() {
        assertNotNull("Controller should be initialized",
        Controller.getInstance());

        assertSame("Controller should be unique",
            Controller.getInstance(), Controller.getInstance());
    }

    @Test
    public void testAlgorithmSelection() {
        Algorithm algorithm = new Deterministic();
        Controller instance = Controller.getInstance();
        instance.setAlgorithm(algorithm);
        assertEquals("setAlgorithm should set Deterministic Algorithm",
            algorithm.getName(), instance.getAlgorithmName());

        algorithm = new SimulatedAnnealing();
        instance.setAlgorithm(algorithm);
        assertEquals("setAlgorithm should set Simulated annealing Algorithm",
            algorithm.getName(), instance.getAlgorithmName());

        algorithm = new Genetic();
        instance.setAlgorithm(algorithm);
        assertEquals("setAlgorithm should set Genetic Algorithm",
            algorithm.getName(), instance.getAlgorithmName());
    }
}
