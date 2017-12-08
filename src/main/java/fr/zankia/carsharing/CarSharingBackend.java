package fr.zankia.carsharing;

import java.util.logging.Logger;

import fr.zankia.carsharing.process.Deterministic;

public class CarSharingBackend {
    private static final Logger log = Logger.getLogger(CarSharingBackend.class.getName());

    public static void main(String[] args) {
        log.info("Application started");
        Controller controller = Controller.getInstance();
        controller.setAlgorithm(new Deterministic());
        log.info("Application closed");
    }

}
