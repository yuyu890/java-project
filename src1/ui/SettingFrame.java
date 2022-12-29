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

public class SettingFrame extends JFrame {
    public SettingFrame(int width, int height) {
        this.setBounds((ScreenUtils.getScreenWidth() - width) / 2, (ScreenUtils.getScreenHigtht() - height) / 2, width, height);
        this.setTitle("中国象棋 —— 暗棋:设置");
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
        exit.setImage(exit.getImage().getScaledInstance(30, 40, Image.SCALE_DEFAULT));
        JButton exitbutton = new JButton(exit);
        exitbutton.setLocation(240, 130);
        exitbutton.setSize(30, 40);
        exitbutton.setBorder(null);
        exitbutton.setContentAreaFilled(false);
        exitbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(exitbutton);

        JButton loginbutton = new JButton("切换账号");
        loginbutton.setLocation(100, 120);
        loginbutton.setSize(100, 30);
        loginbutton.setBorder(null);
        loginbutton.setFont(new Font("楷体", Font.BOLD, 18));
        loginbutton.setContentAreaFilled(false);
        loginbutton.setForeground(Color.WHITE);
        loginbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    LoginJFrame loginFrame = new LoginJFrame();
                    loginFrame.setVisible(true);
                    dispose();
            }
        });
        add(loginbutton);

        ImageIcon log = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\按钮底.png");
        log.setImage(log.getImage().getScaledInstance(100, 30, Image.SCALE_DEFAULT));
        JLabel logg = new JLabel(log);
        logg.setLocation(100,120);
        logg.setSize(100,30);
        add(logg);

        JButton loginbutto = new JButton("更换主题");
        loginbutto.setLocation(100, 60);
        loginbutto.setSize(100, 30);
        loginbutto.setBorder(null);
        loginbutto.setFont(new Font("楷体", Font.BOLD, 18));
        loginbutto.setContentAreaFilled(false);
        loginbutto.setForeground(Color.WHITE);
        loginbutto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });
        add(loginbutto);

        ImageIcon lo = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\按钮底.png");
        lo.setImage(lo.getImage().getScaledInstance(100, 30, Image.SCALE_DEFAULT));
        JLabel loog = new JLabel(lo);
        loog.setLocation(100,60);
        loog.setSize(100,30);
        add(loog);







        ImageIcon bkg = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\设置底板.png");
        bkg.setImage(bkg.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT));
        JLabel bg = new JLabel(bkg);
        bg.setBounds(0, 0, this.getWidth(), this.getHeight());
        add(bg);
    }

}
