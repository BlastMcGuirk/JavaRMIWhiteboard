package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

public class ShapeListServant extends UnicastRemoteObject implements ShapeList {
    private static final long serialVersionUID = 1L;
    private Vector<Shape> shapeList;
    private int versionNumber;

    public ShapeListServant() throws RemoteException {
        super();
        shapeList = new Vector<>();
        versionNumber = 0;
    }

    @Override
    public Shape newShape(GraphicalObject g) throws RemoteException {
        System.out.println("Adding shape to list!");

        // increment version number
        versionNumber++;
        // Add shape to list
        Shape shape = new ShapeServant(g, versionNumber);
        shapeList.add(shape);
        // Return the shape being created

        System.out.println("Shape successfully added to list");
        return shape;
    }

    @Override
    public Vector allShapes() throws RemoteException {
        // Return all shapes in list
        return shapeList;
    }

    @Override
    public int getVersion() throws RemoteException {
        // Return the current version number
        return versionNumber;
    }
}
