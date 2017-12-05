package fr.zankia.carsharing;

import fr.zankia.carsharing.process.Algorithm;
import fr.zankia.carsharing.model.Backup;

/**
 * The main point of the application. It is unique for the whole application.
 * @since 0.1
 */
public class Controller {
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


    /**
     * The only constructor. It is <code>private</code> in order to guarantee its unicity.
     */
    private Controller() {
        this.algorithm = null;
        this.backup = null;
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
    }


    /**
     * Returns the name of the selected <code>Algorithm</code>.
     * @return the name of the selected <code>Algorithm</code>
     */
    public String getAlgorithmName() {
        return this.algorithm.getName();
    }


    /**
     * Selects the <code>Backup</code> method to save layouts.
     * @param backup backup method to use
     */
    public void setBackup(Backup backup) {
        this.backup = backup;
    }
}
