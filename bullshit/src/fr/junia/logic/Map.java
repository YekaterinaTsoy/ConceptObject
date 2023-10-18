package fr.junia.logic;

import fr.junia.entities.Individual;

public class Map extends Grid  {
    public Map(int columns, int rows) {
        super(columns, rows);
    }

    public int tilesAvailable(int x, int y)  {
        boolean finalX = (x == 0 || x == columns - 1);
        boolean finalY = (y == 0 || y == rows - 1);
        if (finalX && finalY) return 3;
        if (finalX || finalY) return 5;
        return 8;
    }

    public Direction directionToZone() {
        return Direction.NORTH;
    }

    public void addIndividual(Individual individual) {
        this.add(individual);
    }
}
