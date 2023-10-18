package fr.junia.entities;

import fr.junia.logic.Coordinate;
import fr.junia.logic.Direction;
import fr.junia.logic.Grid;
import fr.junia.logic.Team;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JComponent;

public abstract class Individual extends JComponent
{
    private static final Random randomGenerator = new Random();
    private static final int energyTotal = 100;

    private Grid grid;
    private Team team;
    private Coordinate position;

    private float energyMultiplier;
    private Direction lastDirection;
    private ArrayList<String> messagesReceived;

    public Individual(Grid grid)
    {
        this.grid = grid;
        this.energyMultiplier = 1.0F;
        this.setSize(grid.dX, grid.dY);
        this.setPosition(new Coordinate(0, 0));
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Team getTeam() { return team; }

    public void setPosition(Coordinate position) {
        Point location = grid.getLocation(position.x, position.y);
        this.setLocation(location);
        this.position = position;
        this.repaint();
    }

    public Coordinate getPosition() {
        return position;
    }

    public void moveInDirection(Direction direction) {
        int displacedX = position.x + direction.displacementX;
        int displacedY = position.y + direction.displacementY;

        if (true) {
            position.x = displacedX;
            position.y = displacedY;
            lastDirection = direction;
        }
    }

    public void paintComponent(Graphics g)
    {
        Color color;
        String character;
        Dimension dimension;

        color = team.getIndividualColor();
        dimension = this.getSize();
        character = team.isLeader(this) ? "M" : "I";
        FontMetrics metrics = g.getFontMetrics();
        int stringX = (int) (dimension.getWidth() * 0.125F);
        int stringY = (int) (dimension.getHeight() - metrics.getAscent());
        g.setColor(color.brighter());

        Font font = g.getFont();
        g.setFont(font.deriveFont((float) (dimension.getWidth() * 0.875F)));
        g.drawString(character, stringX, stringY);
    }

    public boolean inZone() {
        return team.inZone(position);
    }

    public void move() {
        if (team.isLeader(this)) return;

        int randomIndex;
        Direction direction;
        Direction[] directions = Direction.values();

        randomIndex = randomGenerator.nextInt(directions.length);
        direction = directions[randomIndex];
        moveInDirection(direction);
    }

    public void update() {
        move();
    }
    // abstract void update();
}
