package fr.junia.logic;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Objects;

public class Grid extends JComponent {
    protected static final long ZONE = 3;

    int rows;
    int columns;
    public int dX;
    public int dY;

    public Grid(int columns, int rows) {
        this.rows = rows;
        this.columns = columns;

        Color background;
        background = Color.blue;
        background = new Color(background.getRed(), background.getGreen(), background.getBlue(), 0x40);

        this.setLayout(null);
        this.setBackground(background);

        dX = 63;
        dY = 59;
    }

    public void paintComponent(Graphics g)
    {
        g.setColor(this.getBackground());
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        Dimension dimension = this.getSize();

        int width = (int)dimension.getWidth();
        int height = (int)dimension.getHeight();
        dX = width / this.columns;
        dY = height / this.rows;

        g.setColor(Color.black);
        for (int currentY = dY; currentY < height; currentY += dY)
            g.drawLine(0, currentY, width - 1, currentY);
        for (int currentX = dX; currentX < width; currentX += dX)
            g.drawLine(currentX, 0, currentX, height - 1);

        Graphics copy = g.create();
        Font font = copy.getFont();
        copy.setFont(font.deriveFont(dX * 0.875F));

        for (int row = 0; row < ZONE; ++row) {
            for (int column = 0; column < ZONE; ++column) {
                paintCell(copy, column, row, Color.green);
                paintCell(copy, column, rows - 1 - row, Color.orange);
                paintCell(copy, columns - 1 - column, row, Color.pink);
                paintCell(copy, columns - 1 - column, rows - 1 - row, Color.blue);
            }
        }
    }

    public Point getLocation(int column, int row)
    {
        Point location = new Point();
        location.x = dX * column + 1;
        location.y = dY * row + 1;
        return location;
    }

    public void paintCell(Graphics g, int x, int y, Color color)
    {
        int cellX = x * dX + 1;
        int cellY = y * dY + 1;
        g.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 0x80));
        g.fillRect(cellX, cellY, dX - 1, dY - 1);
    }
}
