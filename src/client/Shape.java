package client;

import java.awt.*;

public class Shape {

    public enum Type {Circle, Triangle, Rectangle}
    private Type type;
    private int width, height;
    private Color color;
    private int ID;
    private Point point;

    public Shape() {
        this.type = Type.Rectangle;
        this.width = 50;
        this.height = 50;
        this.color = Color.BLACK;
        this.ID = 0;
    }

    public Shape(Type type, Color color, int width, int height, int ID) {
        this.type = type;
        this.width = width;
        this.height = height;
        this.color = color;
        this.ID = ID;
    }

    public Type getType() {
        return type;
    }
    public void setType(Type type) {
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
