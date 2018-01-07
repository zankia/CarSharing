package fr.zankia.carsharing;

import fr.zankia.carsharing.database.Backup;
import fr.zankia.carsharing.model.CityState;
import fr.zankia.carsharing.model.ICityState;
import fr.zankia.carsharing.process.Algorithm;

import java.util.logging.Logger;

/**
 * The main point of the application. It is unique for the whole application.
 * @since 0.1
 */
public class Controller {
    /**
     * The logger of this class
     */
    private static final Logger log = Logger.getLogger(Controller.class.getName());
    /**
     * The single instance of this class.
     */
    private static Controller instance = null;
    /**
     * The selected <code>Algorithm</code>.
     */
    private Algorithm algorithm;
    /**
     * The selected <code>Backup</code> method.
     */
    private Backup backup;
    private ICityState cityState;


    /**
     * The only constructor. It is <code>private</code> in order to guarantee its unicity.
     */
    private Controller() {
        this.algorithm = null;
        this.backup = null;
        this.cityState = new CityState();
    };



    /**
     * Returns the single instance of <code>Controller</code>.
     * @return the single instance of <code>Controller</code>
     */
    public static Controller getInstance() {
        if (instance == null) {
            synchronized(Controller.class) {
                if (instance == null) {
                    instance = new Controller();
                    log.finest("Created a new instance");
                }
            }
        }
        return instance;
    }


    /**
     * Selects the <code>Algorithm</code> to use for solving the problem.
     * @param algorithm algorithm to use
     */
    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
        log.fine(algorithm.toString() + " selected");
    }


    /**
     * Returns the name of the selected <code>Algorithm</code>.
     * @return the name of the selected <code>Algorithm</code>
     */
    public String getAlgorithmName() {
        return this.algorithm.toString();
    }


    /**
     * Selects the <code>Backup</code> method to save layouts.
     * @param backup backup method to use
     */
    public void setBackup(Backup backup) {
        this.backup = backup;
        log.fine(backup.toString() + " selected");
    }

    public ICityState getCityState() {
        return cityState;
    }

    public ICityState getSolution() {
        algorithm.solve();
        return cityState;
    }

    public void resetCity() {
        cityState.clear();
    }
}
