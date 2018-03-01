package client.panels;

import client.Shape;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class DrawingSurface extends JPanel {

    private ShapeList shapeList;

    public DrawingSurface(ShapeList sl) {
        setBorder(LineBorder.createBlackLineBorder());
        shapeList = sl;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        ArrayList<Shape> shapes = shapeList.getAllShapes();
        if (!shapes.isEmpty()){
            for (Shape s : shapeList.getAllShapes()) {
                g.setColor(s.getColor());
                switch (s.getType()) {
                    case Circle:
                        g.fillOval(s.getPoint().x, s.getPoint().y, s.getWidth(), s.getHeight());
                        break;
                    default:
                        g.fillPolygon(s.getXCoords(), s.getYCoords(), s.numPoints());
                }
            }
        }
    }

}
