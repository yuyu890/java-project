package ui;

import util.PathUtils;
import view.OtherFrames.LoginFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * 这个类表示游戏主界面窗体，窗体上包含：
 * 1 LocalGame: 按钮
 * 2 BotGame:  按钮
 * 3 OnlineGame： 按钮
 * 4 ModGame： 按钮
 * 5 Login： 按钮
 * 6 Setting： 按钮
 * 7 Exit: 按钮
 */
public class MainFrame extends JFrame {
    private final int WIDTH;
    private final int HEIGHT;


    private final int BUTTON_INTERVAL = 80;

    private static final String TITLE = "Chess Game";

    public MainFrame(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        setTitle("中国象棋 —— 暗棋");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null); // Center the window.
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了
        setLayout(null);
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

        addLocalGameButton(); //本地游戏
        addBotGameButton();  //人机对战
        addSettingButton();   //设置页面：比如调节音量大小之类的，或者你想做什么功能，不出bug就行
        addExitButton();  //退出按钮
        addbg();
    }

    /**
     * 在游戏主界面窗体中添加本地游戏按钮
     */
    private void addLocalGameButton() {
        JButton loginbutton = new JButton("双人对战");
        loginbutton.setLocation(300, 50);
        loginbutton.setSize(150, 50);
        loginbutton.setBorder(null);
        loginbutton.setFont(new Font("楷体", Font.BOLD, 25));
        loginbutton.setContentAreaFilled(false);
        loginbutton.setForeground(Color.WHITE);
        loginbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ChessGameFrame(1000, 500).setVisible(true);
                dispose();
            }
        });
        add(loginbutton);

        ImageIcon log = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\按钮底.png");
        log.setImage(log.getImage().getScaledInstance(150, 50, Image.SCALE_DEFAULT));
        JLabel logg = new JLabel(log);
        logg.setLocation(300, 50);
        logg.setSize(150, 50);
        add(logg);
    }

    /**
     * 在游戏主界面窗体中添加机器人游戏按钮
     */
    private void addBotGameButton() {
        JButton loginbutton = new JButton("人机对战");
        loginbutton.setLocation(300, 150);
        loginbutton.setSize(150, 50);
        loginbutton.setBorder(null);
        loginbutton.setFont(new Font("楷体", Font.BOLD, 25));
        loginbutton.setContentAreaFilled(false);
        loginbutton.setForeground(Color.WHITE);
        loginbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new BotGameFrame(1000, 500).setVisible(true);
                dispose();
            }
        });
        add(loginbutton);

        ImageIcon log = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\按钮底.png");
        log.setImage(log.getImage().getScaledInstance(150, 50, Image.SCALE_DEFAULT));
        JLabel logg = new JLabel(log);
        logg.setLocation(300, 150);
        logg.setSize(150, 50);
        add(logg);
    }






    /**
     * 在游戏主界面窗体中添加设置按钮
     */
    private void addSettingButton() {
        ImageIcon exit = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\设置.png");
        exit.setImage(exit.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        JButton exitbutton = new JButton(exit);
        exitbutton.setLocation(680, 290);
        exitbutton.setSize(60, 60);
        exitbutton.setBorder(null);
        exitbutton.setContentAreaFilled(false);
        exitbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SettingFrame(300,200).setVisible(true);
            }
        });
        add(exitbutton);}

    /**
     * 在游戏主界面窗体中添加退出按钮
     */
    private void addExitButton() {
        JButton exitbutton = new JButton("退出游戏");
        exitbutton.setLocation(300, 250);
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
        exitt.setLocation(300,250);
        exitt.setSize(150,50);
        add(exitt);
    }

    public void addbg(){
        JLabel bg = new JLabel(new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\background.png"));
        bg.setBounds(0, 0, this.getWidth(), this.getHeight());
        add(bg);
    }
}
