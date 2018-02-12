package client;

import javax.swing.*;
import java.awt.*;

public class ClientLauncher {

    public static void main(String[] args) {
        JFrame clientWindow = new Window();
        clientWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        clientWindow.setResizable(false);
        clientWindow.setVisible(true);
    }

}
