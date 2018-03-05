package server;

import java.rmi.Naming;

public class ServerLauncher {

    public static void main(String[] args) {
        try {
            ShapeList shapeListServant = new ShapeListServant();
            Naming.rebind("ShapeList", shapeListServant);
            System.out.println("ShapeList bound to registry");
        } catch (Exception e) {
            System.out.println("ShapeList Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
