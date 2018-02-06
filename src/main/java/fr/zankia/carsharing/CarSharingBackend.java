package fr.zankia.carsharing;

import fr.zankia.carsharing.process.Deterministic;

import java.util.logging.Logger;

public class CarSharingBackend {
    private static final Logger log = Logger.getLogger(CarSharingBackend.class.getName());

    public static void main(String[] args) {
        log.fine("Application started");
        Controller.getInstance().display();
        log.fine("Application closed");
    }

}
