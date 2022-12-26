package view;

import view.GameFrames.ChessGameFrame;
import view.OtherFrames.LoginFrame;
import view.OtherFrames.SettingFrame;

import javax.swing.*;
import java.awt.*;

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

    private final int BUTTON_WIDTH = 200;

    private final int BUTTON_HEIGHT = 60;

    private final int BUTTON_INTERVAL = 80;

    private static final String TITLE = "Chess Game";

    public MainFrame(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null); // Center the window.
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了
        setLayout(null);

        addLocalGameButton();
        addBotGameButton();
        addOnlineGameButton();
        addModGameButton();
        addLoginButton();
        addSettingButton();
        addExitButton();
    }

    /**
     * 在游戏主界面窗体中添加本地游戏按钮
     */
    private void addLocalGameButton() {
        JButton localGameButton = new JButton("Local Game");
        localGameButton.setLocation(WIDTH / 2 - 100, HEIGHT / 2 - 3 * BUTTON_INTERVAL);
        localGameButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        localGameButton.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(localGameButton);
        //去往本地游戏界面
        localGameButton.addActionListener(e -> {
            dispose();
            new ChessGameFrame(WIDTH, HEIGHT).setVisible(true);
        });
    }

    /**
     * 在游戏主界面窗体中添加机器人游戏按钮
     */
    private void addBotGameButton() {
        JButton botGameButton = new JButton("Bot Game");
        botGameButton.setLocation(WIDTH / 2 - 100, HEIGHT / 2 - 2 * BUTTON_INTERVAL);
        botGameButton.setSize(200, 60);
        botGameButton.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(botGameButton);
        //去往机器人游戏界面
        botGameButton.addActionListener(e -> {
            dispose();
            new ChessGameFrame(WIDTH, HEIGHT).setVisible(true);
        });
    }

    /**
     * 在游戏主界面窗体中添加联机游戏按钮
     */
    private void addOnlineGameButton() {
        JButton onlineGameButton = new JButton("Online Game");
        onlineGameButton.setLocation(WIDTH / 2 - 100, HEIGHT / 2 - BUTTON_INTERVAL);
        onlineGameButton.setSize(200, 60);
        onlineGameButton.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(onlineGameButton);
        //去往联机游戏界面
        onlineGameButton.addActionListener(e -> {
            dispose();
            new ChessGameFrame(WIDTH, HEIGHT).setVisible(true);
        });
    }

    /**
     * 在游戏主界面窗体中添加修改游戏按钮
     */
    private void addModGameButton() {
        JButton modGameButton = new JButton("Mod Game");
        modGameButton.setLocation(WIDTH / 2 - 100, HEIGHT / 2);
        modGameButton.setSize(200, 60);
        modGameButton.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(modGameButton);
        //去往修改游戏界面
        modGameButton.addActionListener(e -> {
            dispose();
            new ChessGameFrame(WIDTH, HEIGHT).setVisible(true);
        });
    }

    /**
     * 在游戏主界面窗体中添加登录按钮
     */
    private void addLoginButton() {
        JButton loginButton = new JButton("Login");
        loginButton.setLocation(WIDTH / 2 - 100, HEIGHT / 2 + BUTTON_INTERVAL);
        loginButton.setSize(200, 60);
        loginButton.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(loginButton);
        //打开登录界面，保留主界面
        loginButton.addActionListener(e -> {
            new LoginFrame(WIDTH, HEIGHT).setVisible(true);
        });
    }

    /**
     * 在游戏主界面窗体中添加设置按钮
     */
    private void addSettingButton() {
        JButton settingButton = new JButton("Setting");
        settingButton.setLocation(WIDTH / 2 - 100, HEIGHT / 2 + 2 * BUTTON_INTERVAL);
        settingButton.setSize(200, 60);
        settingButton.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(settingButton);
        //打开设置界面，保留主界面
        settingButton.addActionListener(e -> {
            new SettingFrame(WIDTH, HEIGHT).setVisible(true);
        });
    }

    /**
     * 在游戏主界面窗体中添加退出按钮
     */
    private void addExitButton() {
        JButton exitButton = new JButton("Exit");
        exitButton.setLocation(WIDTH / 2 - 100, HEIGHT / 2 + 3 * BUTTON_INTERVAL);
        exitButton.setSize(200, 60);
        exitButton.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(exitButton);
        //退出游戏
        exitButton.addActionListener(e -> {
            System.exit(0);
        });
    }
}
