package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ShapeServant extends UnicastRemoteObject implements Shape {
    private GraphicalObject graphicalObject;
    private int versionNumber;

    public ShapeServant(GraphicalObject go, int version) throws RemoteException {
        super();
        // Does it take a graphical object?
        graphicalObject = go;
        versionNumber = version;
    }

    @Override
    public int getVersion() throws RemoteException {
        return versionNumber;
    }

    @Override
    public GraphicalObject getAllState() throws RemoteException {
        return graphicalObject;
    }
}
