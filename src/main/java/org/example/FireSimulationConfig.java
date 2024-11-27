package org.example;

import java.util.List;

public class FireSimulationConfig {
    public int rows; // Nombre de lignes de la grille
    public int cols; // Nombre de colonnes de la grille
    public List<int[]> initialFire; // Liste des positions initiales des cases en feu
    public double probability; // Probabilité de propagation du feu
}