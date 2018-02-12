package client;

import client.panels.ShapeBuilder;
import client.panels.ShapeList;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Random;

public class Window extends JFrame {

    public static int clientID;
    private JPanel drawingSurface;
    private JButton removeYours, removeAll;
    private ShapeBuilder shapeBuilder;
    private ShapeList shapeList;

    public Window() {
        // set clientID
        Random r = new Random();
        clientID = r.nextInt(2000000000);
        setTitle("ClientID: " + clientID);

        // create panels
        drawingSurface = new JPanel();
        removeYours = new JButton("Remove Yours");
        removeAll = new JButton("Remove All");

        shapeBuilder = new ShapeBuilder();
        shapeList = new ShapeList();

        // add components
        addPanels();
    }

    public long getClientID() {
        return clientID;
    }

    private void addPanels() {
        // Setup the layout
        Container cp = getContentPane();
        cp.setLayout(new GridBagLayout());
        ((GridBagLayout)cp.getLayout()).columnWidths = new int[] {50, 50, 50, 50, 50, 50, 50, 50, 50, 50};
        ((GridBagLayout)cp.getLayout()).rowHeights = new int[] {50, 50, 50, 50, 50, 50, 50, 50};

        GridBagConstraints gc = new GridBagConstraints();

        // Add the Drawing Surface
        drawingSurface.setBorder(LineBorder.createBlackLineBorder());
        gc.gridx = 0; gc.gridy = 0; gc.gridwidth = 7; gc.gridheight = 7; gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.BOTH;
        cp.add(drawingSurface, gc);

        // Add Shape List
        gc.gridx = 7; gc.gridwidth = 3; gc.gridheight = 4;
        cp.add(shapeList, gc);

        // Add Shape Builder
        gc.gridy = 4;
        cp.add(shapeBuilder, gc);

        // Add Buttons
        gc.gridx = 1; gc.gridy = 7; gc.gridwidth = 2; gc.gridheight = 1;
        cp.add(removeYours, gc);
        gc.gridx = 4;
        cp.add(removeAll, gc);

        // Fix JFrame size
        setSize(520, 429);
        //pack();
        setLocationRelativeTo(null);
    }

    /*private JPanel createLeftPanel() {
        JPanel left = new JPanel();
        left.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        // Add drawing surface
        gc.gridx = gc.gridy = 0;
        gc.gridwidth = 5;
        gc.weighty = .9;
        gc.fill = GridBagConstraints.BOTH;
        left.add(drawingSurface, gc);

        // Add buttons
        gc.gridx = 1; gc.gridy = 1;
        gc.gridwidth = 1;
        gc.weighty = .1;
        gc.fill = GridBagConstraints.BOTH;
        left.add(removeYours, gc);
        gc.gridx = 3;
        gc.fill = GridBagConstraints.BOTH;
        left.add(removeAll, gc);

        return left;
    }

    private JPanel createRightPanel() {
        JPanel right = new JPanel();

        return right;
    }*/

}
