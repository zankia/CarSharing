package fr.zankia.carsharing;

import fr.zankia.carsharing.process.Algorithm;
import fr.zankia.carsharing.model.Backup;

public class Controller {
    private static Controller instance = null;
    private Algorithm algorithm;
    private Backup backup;


    private Controller() {
        this.algorithm = null;
    };


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


    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }


    public String getAlgorithmName() {
        return this.algorithm.getName();
    }


    public void setBackup(Backup backup) {
        this.backup = backup;
    }
}
