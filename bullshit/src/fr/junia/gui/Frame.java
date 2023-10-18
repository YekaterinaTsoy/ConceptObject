package fr.junia.gui;

import fr.junia.entities.Human;
import fr.junia.logic.Coordinate;
import fr.junia.logic.Grid;
import fr.junia.logic.Map;
import fr.junia.logic.Team;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame()
    {
        Map map = new Map(15, 8);
        Team team = new Team(Color.green);
        Human human = new Human(map);
        team.setZoneLocation(new Coordinate(0, 0));
        team.setLeader(human);
        human.setTeam(team);

        this.setLayout(new BorderLayout());
        this.add(map, BorderLayout.CENTER);
        map.addIndividual(human);
        this.setTitle("Application");
        this.setSize(960, 512);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        new Frame();
    }
}
