package fr.junia.logic;

public enum Direction
{
    NORTH(0, -1),
    SOUTH(0, 1),
    EAST(1, 0),
    WEST(-1, 0),
    NORTHEAST(1, -1),
    SOUTHEAST(1, 1),
    SOUTHWEST(-1, 1),
    NORTHWEST(-1, -1);

    public final int displacementX;
    public final int displacementY;
    private Direction(int displacementX, int displacementY) {
        this.displacementX = displacementX;
        this.displacementY = displacementY;
    }
}
