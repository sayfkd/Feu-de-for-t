package org.example;

import java.util.List;

public class FireSimulation {
    private int[][] grid;           // La grille de la forêt (1 = intact, 2 = en feu, 0 = cendres)
    private int rows;               // Nombre de lignes de la grille
    private int cols;               // Nombre de colonnes de la grille
    private double probability;     // Probabilité de propagation du feu
    private int burntCount = 0;     // Compteur de cases brûlées

    // Constructeur
    public FireSimulation(int rows, int cols, double probability) {
        this.rows = rows;
        this.cols = cols;
        this.probability = probability;
        this.grid = new int[rows][cols];
        initializeGrid();
    }

    // Initialise la grille avec des arbres intacts (1 partout)
    private void initializeGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = 1; // 1 = intact
            }
        }
    }

    // Initialise les cases initiales en feu (2)
    public void initialize(List<int[]> initialFire) {
        for (int[] fire : initialFire) {
            int row = fire[0];
            int col = fire[1];
            grid[row][col] = 2; // 2 = en feu
        }
    }

    // Lance la simulation étape par étape
    public int run() {
        int steps = 0;
        while (simulateStep()) {
            steps++;
            printGrid();
        }
        return steps;
    }

    // Simule une étape de la propagation du feu
    private boolean simulateStep() {
        boolean fireSpread = false;
        int[][] nextGrid = new int[rows][cols]; // Nouvelle grille pour la prochaine étape

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) { // Si la case est en feu
                    nextGrid[i][j] = 0; // La case devient cendres
                    burntCount++;
                    fireSpread |= spreadFire(nextGrid, i, j); // Propager le feu
                } else if (grid[i][j] == 1) {
                    nextGrid[i][j] = 1; // La case reste intacte
                }
            }
        }

        grid = nextGrid; // Mettre à jour la grille
        return fireSpread;
    }

    // Propagation du feu vers les cases adjacentes
    private boolean spreadFire(int[][] nextGrid, int row, int col) {
        boolean fireSpread = false;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Haut, Bas, Gauche, Droite

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                if (Math.random() < probability) {
                    nextGrid[newRow][newCol] = 2; // Mettre la case en feu
                    fireSpread = true;
                }
            }
        }

        return fireSpread;
    }

    // Récupère le nombre total de cases brûlées
    public int getBurntCount() {
        return burntCount;
    }

    public void printGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    System.out.print("🌲 "); // Arbre intact
                } else if (grid[i][j] == 2) {
                    System.out.print("🔥 "); // En feu
                } else {
                    System.out.print("🪶 "); // Cendres
                }
            }
            System.out.println(); // Passer à la ligne suivante après chaque ligne de la grille
        }
        System.out.println(); // Ajouter une ligne vide pour séparer les étapes
    }
}
