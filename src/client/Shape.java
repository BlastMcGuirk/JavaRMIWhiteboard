package client;

import java.awt.*;

public class Shape {

    public enum Type {Circle, Triangle, Rectangle}
    private Type type;
    private int width, height;
    private Color color;
    private int ID;

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
    public void setColor(Color color) {
        this.color = color;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    public String toString() {
        return type.toString() + ": " + color.toString() + ", [" + width + ", " + height + "]";
    }

}
