package org.example;

import java.io.File;
import java.io.IOException;

public class FireSimulationApp {
    public static void main(String[] args) {
        try {
            // Charger la configuration depuis un fichier
            String absolutePath = new File("config.json").getAbsolutePath();
            System.out.println("Chemin absolu du fichier config.json: " + absolutePath);
            FireSimulationConfig config = ConfigReader.readConfig(absolutePath);

            // Initialiser la simulation avec les paramètres du fichier
            FireSimulation simulation = new FireSimulation(config.rows, config.cols, config.probability);
            simulation.initialize(config.initialFire);

            // Lancer la simulation
            int steps = simulation.run();
            System.out.println("Simulation terminée en " + steps + " étapes.");
            System.out.println("Nombre total de cases réduites en cendres : " + simulation.getBurntCount());
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier de configuration : " + e.getMessage());
        }
    }
}
