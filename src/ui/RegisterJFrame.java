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
import java.util.Scanner;

public class RegisterJFrame extends JFrame {
    public String ZH;
    public String MM;
    public String reMM;

    public RegisterJFrame() {
        this.setBounds((ScreenUtils.getScreenWidth() - 747) / 2, (ScreenUtils.getScreenHigtht() - 350) / 2, 747, 350);
        this.setTitle("中国象棋 —— 暗棋：欢迎注册");
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
        addComponent();
        setVisible(true);
    }


    public void addComponent() {
        JTextField nameField = new JTextField();
        nameField.setLocation(285, 60);
        nameField.setSize(210, 30);
        nameField.setFont(new Font("楷体", Font.BOLD, 18));
        nameField.setOpaque(false);
        nameField.setBorder(null);
        ZH = nameField.getText();
        add(nameField);

        JTextField passwordField = new JTextField();
        passwordField.setLocation(285, 115);
        passwordField.setSize(210, 30);
        passwordField.setFont(new Font("楷体", Font.BOLD, 18));
        passwordField.setOpaque(false);
        passwordField.setBorder(null);
        MM = nameField.getText();
        add(passwordField);

        JTextField repasswordField = new JTextField();
        repasswordField.setLocation(285, 170);
        repasswordField.setSize(210, 30);
        repasswordField.setFont(new Font("楷体", Font.BOLD, 18));
        repasswordField.setOpaque(false);
        repasswordField.setBorder(null);
        reMM = nameField.getText();
        add(repasswordField);

        ImageIcon zh = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\project\\images\\账号.png");
        zh.setImage(zh.getImage().getScaledInstance(300, 50, Image.SCALE_DEFAULT));
        JLabel nameLabel = new JLabel(zh);
        nameLabel.setLocation(220, 50);
        nameLabel.setSize(300, 50);
        add(nameLabel);

        ImageIcon mi = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\project\\images\\密码.png");
        mi.setImage(mi.getImage().getScaledInstance(300, 50, Image.SCALE_DEFAULT));
        JLabel passwordLabel = new JLabel(mi);
        passwordLabel.setLocation(220, 105);
        passwordLabel.setSize(300, 50);
        add(passwordLabel);

        ImageIcon remi = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\project\\images\\密码.png");
        remi.setImage(remi.getImage().getScaledInstance(300, 50, Image.SCALE_DEFAULT));
        JLabel repasswordLabel = new JLabel(remi);
        repasswordLabel.setLocation(220, 160);
        repasswordLabel.setSize(300, 50);
        add(repasswordLabel);

        ImageIcon log = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\project\\images\\接受.png");
        log.setImage(log.getImage().getScaledInstance(90, 35, Image.SCALE_DEFAULT));
        JButton loginbutton = new JButton(log);
        loginbutton.setLocation(250, 240);
        loginbutton.setSize(90, 35);
        loginbutton.setBorder(null);
        loginbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(loginbutton);

        ImageIcon reg = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\project\\images\\取消.gif");
        reg.setImage(reg.getImage().getScaledInstance(90, 35, Image.SCALE_DEFAULT));
        JButton registbutton = new JButton(reg);
        registbutton.setLocation(420, 240);
        registbutton.setSize(90, 35);
        registbutton.setBorder(null);
        registbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
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
                dispose();
            }
        });
        add(exitbutton);

        /*
        ImageIcon sound = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\project\\images\\声音开.png");
        sound.setImage(sound.getImage().getScaledInstance(30, 50, Image.SCALE_DEFAULT));
        JButton soundbutton = new JButton(sound);
        soundbutton.setLocation(10, 310);
        soundbutton.setSize(30, 30);
        soundbutton.setBorder(null);
        soundbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }});
        add(soundbutton);

         */


        JLabel bg = new JLabel(new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\project\\images\\background.png"));
        bg.setBounds(0, 0, this.getWidth(), this.getHeight());
        add(bg);
    }
}


