package client;

import client.panels.DrawingSurface;
import client.panels.ShapeBuilder;
import client.panels.ShapeList;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Window extends JFrame {

    public static int clientID;
    private DrawingSurface drawingSurface;
    private JButton removeYours, removeAll;
    private ShapeBuilder shapeBuilder;
    private ShapeList shapeList;

    public Window() {
        // set clientID
        Random r = new Random();
        clientID = r.nextInt(2000000000);
        setTitle("ClientID: " + clientID);

        // create panels
        removeYours = new JButton("Remove Yours");
        removeYours.addActionListener(e -> {
            //////////////////////////////////////////
            //              TEMPORARY ! ! !         //
            shapeList.removeYourShapes();           //
            drawingSurface.repaint();

            //////////////////////////////////////////

            // Submit a request to the server to remove all your shapes
            // TODO: Implement the Server
        });
        removeAll = new JButton("Remove All");
        removeAll.addActionListener(e -> {
            //////////////////////////////////////////
            //              TEMPORARY ! ! !         //
            shapeList.removeAllShapes();            //
            drawingSurface.repaint();
            //////////////////////////////////////////

            // Submit a request to the server to remove all shapes
            // TODO: Implement the Server
        });

        shapeBuilder = new ShapeBuilder();
        shapeList = new ShapeList();

        drawingSurface = new DrawingSurface(shapeList);
        drawingSurface.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ///////////////////////////////////////////////
                //              Temporary ! ! !              //
                Shape s = shapeBuilder.getShape();           //
                s.setPoint(e.getPoint());                    //
                shapeList.addShape(s);                       //
                repaint();                                   //
                ///////////////////////////////////////////////

                // Submit a request to the server to add a shape
                // TODO: Implement the Server
            }
            public void mousePressed(MouseEvent e) {

            }
            public void mouseReleased(MouseEvent e) {

            }
            public void mouseEntered(MouseEvent e) {

            }
            public void mouseExited(MouseEvent e) {

            }
        });

        // add components
        addPanels();
    }

    private void addPanels() {
        // Setup the layout
        Container cp = getContentPane();
        cp.setLayout(new GridBagLayout());
        ((GridBagLayout)cp.getLayout()).columnWidths = new int[] {50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50};
        ((GridBagLayout)cp.getLayout()).rowHeights = new int[] {50, 50, 50, 50, 50, 50, 50, 50, 50};

        GridBagConstraints gc = new GridBagConstraints();

        // Add the Drawing Surface
        gc.gridx = 0; gc.gridy = 0; gc.gridwidth = 7; gc.gridheight = 7; gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.BOTH;
        cp.add(drawingSurface, gc);

        // Add Shape List
        gc.gridx = 7; gc.gridwidth = 4; gc.gridheight = 5;
        cp.add(shapeList, gc);

        // Add Shape Builder
        gc.gridy = 5; gc.gridheight = 3;
        cp.add(shapeBuilder, gc);

        // Add Buttons
        gc.gridx = 1; gc.gridy = 7; gc.gridwidth = 2; gc.gridheight = 1;
        cp.add(removeYours, gc);
        gc.gridx = 4;
        cp.add(removeAll, gc);

        // Fix JFrame size
        setSize(570, 400);
        //pack();
        setLocationRelativeTo(null);
    }

}
