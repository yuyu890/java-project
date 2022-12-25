package ui;

import util.PathUtils;
import util.ScreenUtils;
import music.music;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class LoginJFrame extends JFrame {
    public LoginJFrame() {
        this.setBounds((ScreenUtils.getScreenWidth() - 747) / 2, (ScreenUtils.getScreenHigtht() - 350) / 2, 747, 350);
        this.setTitle("中国象棋 —— 暗棋：请登录");
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
        addComponent();
    }


    public void addComponent() {
        JTextField nameField = new JTextField();
        nameField.setLocation(285, 80);
        nameField.setSize(210, 30);
        nameField.setFont(new Font("楷体", Font.BOLD, 18));
        nameField.setOpaque(false);
        nameField.setBorder(null);
        add(nameField);

        JTextField passwordField = new JTextField();
        passwordField.setLocation(285, 155);
        passwordField.setSize(210, 30);
        passwordField.setFont(new Font("楷体", Font.BOLD, 18));
        passwordField.setOpaque(false);
        passwordField.setBorder(null);
        add(passwordField);

        ImageIcon zh = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\project\\images\\账号.png");
        zh.setImage(zh.getImage().getScaledInstance(300, 50, Image.SCALE_DEFAULT));
        JLabel nameLabel = new JLabel(zh);
        nameLabel.setLocation(220, 70);
        nameLabel.setSize(300, 50);
        add(nameLabel);

        ImageIcon mi = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\project\\images\\密码.png");
        mi.setImage(mi.getImage().getScaledInstance(300, 50, Image.SCALE_DEFAULT));
        JLabel passwordLabel = new JLabel(mi);
        passwordLabel.setLocation(220, 145);
        passwordLabel.setSize(300, 50);
        add(passwordLabel);

        ImageIcon log = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\project\\images\\登录.png");
        log.setImage(log.getImage().getScaledInstance(90, 35, Image.SCALE_DEFAULT));
        JButton loginbutton = new JButton(log);
        loginbutton.setLocation(250, 240);
        loginbutton.setSize(90, 35);
        loginbutton.setBorder(null);
        loginbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChessGameFrame mainFrame = new ChessGameFrame();
                mainFrame.setVisible(true);
                dispose();
            }
        });
        add(loginbutton);

        ImageIcon reg = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\project\\images\\注册.png");
        reg.setImage(reg.getImage().getScaledInstance(90, 35, Image.SCALE_DEFAULT));
        JButton registbutton = new JButton(reg);
        registbutton.setLocation(420, 240);
        registbutton.setSize(90, 35);
        registbutton.setBorder(null);
        registbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RegisterJFrame();
            }
        });
        add(registbutton);

        ImageIcon exit = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\project\\images\\退出.png");
        exit.setImage(exit.getImage().getScaledInstance(30, 50, Image.SCALE_DEFAULT));
        JButton exitbutton = new JButton(exit);
        exitbutton.setLocation(700, 290);
        exitbutton.setSize(30, 50);
        exitbutton.setBorder(null);
        exitbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exitbutton);

        ImageIcon sound = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\project\\images\\声音开.png");
        sound.setImage(sound.getImage().getScaledInstance(30, 50, Image.SCALE_DEFAULT));
        JButton soundbutton = new JButton(sound);
        soundbutton.setLocation(10, 310);
        soundbutton.setSize(30, 30);
        soundbutton.setBorder(null);
        soundbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                try {
                    music.playmusic();
                } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        add(soundbutton);

        JLabel bg = new JLabel(new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\project\\images\\background.png"));
        bg.setBounds(0, 0, this.getWidth(), this.getHeight());
        add(bg);
    }
}


