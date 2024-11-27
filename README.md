Simulation de la propagation du feu de forêt

Description :
Ce projet simule la propagation du feu dans une forêt, représentée par une grille. Le feu se propage à une probabilité définie à chaque étape et peut réduire certaines cases en cendres.

Prérequis :
1. Java 17 ou supérieur
2. Maven (outil de gestion de projet et de dépendances)

Installation et Exécution :
1. Décompressez le fichier ZIP contenant le projet dans un répertoire de votre choix.
2. Ouvrez un terminal dans le répertoire du projet.
3. Exécutez la commande suivante pour installer les dépendances et compiler le projet :
    ```bash
   mvn clean install
4. Une fois la compilation terminée, exécutez la simulation avec la commande suivante :
    ```bash
   mvn exec:java -Dexec.mainClass="org.example.FireSimulationApp"
   
Cela va démarrer la simulation en utilisant le fichier de configuration `config.json`, afficher le nombre d'étapes écoulées et le nombre de cases réduites en cendres.

Fichier de configuration :
Le fichier `config.json` contient les paramètres de la simulation, tels que la taille de la grille, la probabilité de propagation du feu, et les positions initiales du feu.

Exemple de fichier `config.json` :
{
"rows": 10,
"cols": 10,
"probability": 0.3,
"initialFire": [
[4, 4],
[5, 5],
[6, 6]
]
}

Personnalisation :
Pour ajuster la simulation, modifiez simplement le fichier `config.json` en fonction des valeurs souhaitées pour la grille, la probabilité et les cases initiales en feu.

