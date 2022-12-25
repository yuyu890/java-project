import ui.LoginJFrame;

import javax.swing.*;


public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginJFrame loginJFrame = new LoginJFrame();
        });
    }
}
