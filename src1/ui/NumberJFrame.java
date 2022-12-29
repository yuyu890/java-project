package ui;

import util.PathUtils;
import util.ScreenUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class NumberJFrame extends JFrame {
    public NumberJFrame(){
        this.setBounds((ScreenUtils.getScreenWidth() - 600) / 2, (ScreenUtils.getScreenHigtht() - 400) / 2, 600, 400);
        this.setTitle("中国象棋 —— 暗棋：排行榜");
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        try {
            this.setIconImage(ImageIO.read(new File(PathUtils.getRealPath("logo.png"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.setUndecorated(true);
        setVisible(true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img = tk.getImage("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\logo.png");
        Cursor cu = tk.createCustomCursor(img, new Point(10, 10),"stick");
        setCursor(cu);
        addComponent();
    }

    private void addComponent() {

        ImageIcon exit = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\退出.png");
        exit.setImage(exit.getImage().getScaledInstance(30, 50, Image.SCALE_DEFAULT));
        JButton exitbutton = new JButton(exit);
        exitbutton.setLocation(500, 300);
        exitbutton.setSize(30, 50);
        exitbutton.setBorder(null);
        exitbutton.setContentAreaFilled(false);
        exitbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(exitbutton);

        ImageIcon num1 = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\等级1.png");
        num1.setImage(num1.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        JLabel num1Label = new JLabel(num1);
        num1Label.setLocation(100, 50);
        num1Label.setSize(60, 60);
        num1Label.setBorder(null);
        add(num1Label);
        ImageIcon num2 = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\等级2.png");
        num2.setImage(num2.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        JLabel num2Label = new JLabel(num2);
        num2Label.setLocation(100, 150);
        num2Label.setSize(60, 60);
        num2Label.setBorder(null);
        add(num2Label);
        ImageIcon num3 = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\等级3.png");
        num3.setImage(num3.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        JLabel num3Label = new JLabel(num3);
        num3Label.setLocation(100, 250);
        num3Label.setSize(60, 60);
        num3Label.setBorder(null);
        add(num3Label);

        JLabel num1name = new JLabel("ABC         100%");
        num1name.setLocation(200,50);
        num1name.setSize(1000, 60);
        num1name.setFont(new Font("楷体", Font.BOLD, 20));
        add(num1name);
        JLabel num2name = new JLabel("嗨害嗨       83.3%");
        num2name.setLocation(195,150);
        num2name.setSize(1000, 60);
        num2name.setFont(new Font("楷体", Font.BOLD, 20));
        add(num2name);










        ImageIcon bkg = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\排行榜底板.png");
        bkg.setImage(bkg.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT));
        JLabel bg = new JLabel(bkg);
        bg.setBounds(0, 0, this.getWidth(), this.getHeight());
        add(bg);
    }


}
