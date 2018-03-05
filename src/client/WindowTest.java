package client;

import server.GraphicalObject;
import server.ShapeList;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.Random;

public class WindowTest extends JFrame {

    public static int clientID;
    private JPanel window;
    private ShapeList shapeList;

    public WindowTest(ShapeList shapeList) {
        this.shapeList = shapeList;

        // set clientID
        Random r = new Random();
        clientID = r.nextInt(2000000000);
        setTitle("ClientID: " + clientID);

        // add frame
        window = new JPanel();
        window.setSize(400, 400);
        add(window);

        // add mouse detection
        window.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    shapeList.newShape(new GraphicalObject(e.getPoint()));
                    System.out.println("Sending shape to server");
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {

            }
            @Override
            public void mouseReleased(MouseEvent e) {

            }
            @Override
            public void mouseEntered(MouseEvent e) {

            }
            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

}
