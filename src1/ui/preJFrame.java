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


public class preJFrame extends JFrame {
    public preJFrame(){
        this.setBounds((ScreenUtils.getScreenWidth() - 400) / 2, (ScreenUtils.getScreenHigtht() - 600) / 2, 400, 600);
        this.setTitle("中国象棋 —— 暗棋  by 梁慧敏and刘昱铭");
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
        JLabel title = new JLabel("中国象棋");
        title.setLocation(80,150);
        title.setSize(200,100);
        title.setBorder(null);
        title.setFont(new Font("楷体",Font.BOLD, 45));
        add(title);

        JLabel titlee = new JLabel("——暗棋");
        titlee.setLocation(170,220);
        titlee.setSize(200,100);
        titlee.setBorder(null);
        titlee.setFont(new Font("楷体",Font.BOLD, 40));
        add(titlee);

        JLabel gy = new JLabel("制作：梁慧敏 刘昱铭");
        gy.setLocation(200,670);
        gy.setSize(300,30);
        gy.setBorder(null);
        gy.setFont(new Font("楷体",Font.BOLD, 20));
        add(gy);

        JButton loginbutton = new JButton("开始游戏");
        loginbutton.setLocation(120, 400);
        loginbutton.setSize(150, 50);
        loginbutton.setBorder(null);
        loginbutton.setFont(new Font("楷体", Font.BOLD, 25));
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
        log.setImage(log.getImage().getScaledInstance(150, 50, Image.SCALE_DEFAULT));
        JLabel logg = new JLabel(log);
        logg.setLocation(120,400);
        logg.setSize(150,50);
        add(logg);

        JButton exitbutton = new JButton("退出游戏");
        exitbutton.setLocation(120, 500);
        exitbutton.setSize(150, 50);
        exitbutton.setBorder(null);
        exitbutton.setFont(new Font("楷体", Font.BOLD, 25));
        exitbutton.setContentAreaFilled(false);
        exitbutton.setForeground(Color.WHITE);
        exitbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exitbutton);

        ImageIcon exit = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\按钮底.png");
        exit.setImage(exit.getImage().getScaledInstance(150, 50, Image.SCALE_DEFAULT));
        JLabel exitt = new JLabel(exit);
        exitt.setLocation(120,500);
        exitt.setSize(150,50);
        add(exitt);

        ImageIcon bkg = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\前背景.png");
        bkg.setImage(bkg.getImage().getScaledInstance(400, 600, Image.SCALE_DEFAULT));
        JLabel bg = new JLabel(bkg);
        bg.setBounds(0, 0, this.getWidth(), this.getHeight());
        add(bg);
    }
}

