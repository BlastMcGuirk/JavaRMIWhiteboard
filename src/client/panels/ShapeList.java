package client.panels;

import client.Shape;
import client.Window;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShapeList extends JScrollPane {

    private ArrayList<Shape> shapeList;
    private JList<Shape> yourShapes;

    public ShapeList() {
        shapeList = new ArrayList<>();
        yourShapes = new JList<>();
        setBorder(new TitledBorder("Your Shapes"));
        setViewportView(yourShapes);
    }

    public void update() {
        // Change if shapes are changed on server
        DefaultListModel<Shape> dlm = new DefaultListModel<>();
        for (Shape s : shapeList) {
            if (s.getID() == Window.clientID) {
                dlm.addElement(s);
            }
        }
        yourShapes.setModel(dlm);
    }

    public void addShape(Shape s) {
        shapeList.add(s);
        update();
    }

    public void removeYourShapes() {
        shapeList.removeIf(s -> s.getID() == Window.clientID);
        update();
    }

    public void removeAllShapes() {
        shapeList.clear();
        update();
    }

    public ArrayList<Shape> getAllShapes() {
        return shapeList;
    }

}
