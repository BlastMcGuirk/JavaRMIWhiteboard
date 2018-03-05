package server;
// GraphicalObject is a class containing the state of a graphical object

import java.awt.*;
import java.io.Serializable;

public class GraphicalObject implements Serializable{

    public enum ShapeType {Circle, Triangle, Rectangle}
    private ShapeType type;
    private int width, height;
    private Color color;
    private int ID;
    private Point point;

    public GraphicalObject() {
        this.type = ShapeType.Rectangle;
        this.width = 50;
        this.height = 50;
        this.color = Color.BLACK;
        this.ID = 0;
    }

    public GraphicalObject(Point p) {
        this.type = ShapeType.Rectangle;
        this.width = 50;
        this.height = 50;
        this.color = Color.BLACK;
        this.ID = 0;
        this.point = p;
    }

    public GraphicalObject(ShapeType type, Color color, int width, int height, int ID) {
        this.type = type;
        this.width = width;
        this.height = height;
        this.color = color;
        this.ID = ID;
    }

    public ShapeType getType() {
        return type;
    }
    public void setType(ShapeType type) {
        this.type = type;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public Color getColor() {
        return color;
    }
    public String getColorName() {
        Color c = getColor();
        if (c == Color.BLACK) return "Black";
        if (c == Color.RED) return "Red";
        if (c == Color.GREEN) return "Green";
        if (c == Color.BLUE) return "Blue";
        return "Unknown Color";
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public Point getPoint() { return point; }
    public void setPoint(Point point) { this.point = point; }
    public int[] getXCoords() {
        switch (getType()) {
            case Triangle:
                return new int[] {point.x + (getWidth() / 2), point.x, point.x + getWidth()};
            case Rectangle:
                return new int[] {point.x, point.x + getWidth(), point.x + getWidth(), point.x};
            default:
                return null;
        }
    }
    public int[] getYCoords() {
        switch (getType()) {
            case Triangle:
                return new int[] {point.y, point.y + getHeight(), point.y + getHeight()};
            case Rectangle:
                return new int[] {point.y, point.y, point.y + getHeight(), point.y + getHeight()};
            default:
                return null;
        }
    }
    public int numPoints() {
        switch (getType()) {
            case Triangle:
                return 3;
            case Rectangle:
                return 4;
            default:
                return 0;
        }
    }

    public String toString() {
        return type.toString() + ": " + getColorName() + ", [" + width + ", " + height + "]";
    }

}
