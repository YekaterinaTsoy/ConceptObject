package fr.junia.logic;

import fr.junia.entities.Individual;

import java.awt.*;
import java.util.Objects;
import java.util.Vector;

public class Team
{
    private Color zoneColor;
    private Color individualColor;
    private Coordinate zoneLocation;
    private Individual leader;
    private Vector<Individual> members;

    public Team(Color individualColor)
    {
        this.individualColor = individualColor;
        this.members = new Vector<>();
        this.zoneColor = new Color(
                individualColor.getRed(),
                individualColor.getGreen(),
                individualColor.getBlue(),
                0x80);
    }

    public void setZoneLocation(Coordinate zoneLocation) { this.zoneLocation = zoneLocation; }

    public Coordinate getZoneLocation() { return zoneLocation; }

    public boolean inZone(Coordinate coordinate) {
        return coordinate.x >= zoneLocation.x &&
                coordinate.x < zoneLocation.x + 3 &&
                coordinate.y >= zoneLocation.y &&
                coordinate.y < zoneLocation.y + 3;
    }

    public Color getIndividualColor() { return individualColor; }

    public Color getZoneColor() { return zoneColor; }

    public void addMember(Individual individual)
    {
        members.add(individual);
    }

    public void setLeader(Individual individual)
    {
        this.leader = individual;
    }

    public boolean isLeader(Individual individual) { return Objects.equals(individual, leader); }
}
