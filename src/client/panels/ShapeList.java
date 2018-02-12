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
        // Found on StackOverflow @ https://stackoverflow.com/questions/122105/what-is-the-best-way-to-filter-a-java-collection
        List<Shape> yours = shapeList.stream().filter(s -> s.getID() == Window.clientID).collect(Collectors.toList());
        yourShapes.setListData((Shape[]) yours.toArray());
    }

    public void addShape(Shape s) {
        shapeList.add(s);
        update();
    }

}
