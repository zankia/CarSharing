package fr.zankia.carsharing;

import fr.zankia.carsharing.process.Deterministic;

public class App {

    public static void main(String[] args) {
        Controller controller = Controller.getInstance();
        controller.setAlgorithm(new Deterministic());
        System.out.println("Application started, " + controller.getAlgorithmName() + " algorithm selected.");
        System.out.println("Finished");
    }

}
