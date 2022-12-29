import ui.LoginJFrame;
import ui.MainFrame;
import ui.preJFrame;

import javax.swing.*;


public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            preJFrame preFrame = new preJFrame();
            preFrame.setVisible(true);
        });
    }
}
