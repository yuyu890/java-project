package util;

import javax.swing.*;
import java.awt.*;
public class BackGroundPanel extends JPanel {
    public Image bg;
    public BackGroundPanel(Image bg){
        this.bg = bg;
        this.setOpaque(true);
    }
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        g.drawImage(bg,0,0,this.getWidth(),this.getHeight(),this);
    }
}
