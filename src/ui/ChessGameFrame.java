package ui;

import controller.GameController;
import controller.Saver;
import util.PathUtils;
import view.Chessboard;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 这个类表示游戏窗体，窗体上包含：
 * 1 Chessboard: 棋盘
 * 2 JLabel:  标签
 * 3 JButton： 按钮
 * 属性：宽度，高度，棋盘尺寸，gamecontroller，状态标签
 * 构造器：设置标题，宽度和高度，设置棋盘尺寸，设置size
 * 将界面的中心放在屏幕中心，背景颜色设为白色，设置关闭按钮，设置layout（不知道是什么）
 * 添加棋盘，添加标签，添加hello按钮，添加load按钮
 * 方法：添加棋盘，添加标签，添加hello按钮，添加load按钮
 */
public class ChessGameFrame extends JFrame {
    private static final int WIDTH =  1000;
    public static final int HEIGHT = 500;
    public static final int CHESSBOARD_SIZE = 700;
    private GameController gameController;
    private static JLabel statusLabel;

    public ChessGameFrame() {
        setTitle("中国象棋 —— 暗棋  by 梁慧敏and刘昱铭"); //设置标题

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

        addComponent();
        addChessboard();
        addLoadButton();
        addbkg();
    }

    private void addChessboard() {
        Chessboard chessboard = new Chessboard();
        gameController = new GameController(chessboard);
        chessboard.setLocation(HEIGHT / 12, HEIGHT / 10);
        add(chessboard);
    }

    private void addHelloButton() {
        JButton button = new JButton("别点我");
        button.addActionListener((e) -> JOptionPane.showMessageDialog(this, "看什么看，代码写完了吗？？？"));
        button.setLocation(800,100);
        button.setSize(180, 60);
        button.setFont(new Font("楷体", Font.BOLD, 20));
        add(button);
    }
    private void addLoadButton() {
        JButton button = new JButton("Load");
        button.setLocation(750, 200);
        button.setSize(50, 30);
        button.setFont(new Font("楷体", Font.BOLD, 20));
        button.setBackground(Color.LIGHT_GRAY);
        add(button);

        button.addActionListener(e -> {
            System.out.println("Click load");
            String path = JOptionPane.showInputDialog(this, "Input Path here");
            ArrayList<ArrayList<String>> everyStep = gameController.loadGameFromFile(path); //这里只是获得了每一步的数组，
                // 我们需要去加载最后一个棋盘
                // 加载棋盘直接用最后一个棋盘，然后下一步的话，是与最后一步的相反的颜色
                Chessboard.getInstance().setChessComponents(Saver.useDataRecords(everyStep.get(everyStep.size()-1)));
                //这里是把chessboard的squarecomponent的每个棋子，都换成了新的棋子
        });
    }

    public void addbkg(){
        ImageIcon bkg = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\project\\images\\background.png");
        bkg.setImage(bkg.getImage().getScaledInstance(1000, 525, Image.SCALE_DEFAULT));
        JLabel bg = new JLabel(bkg);
        bg.setBounds(0, 0, this.getWidth(), this.getHeight());
        add(bg);
    }

    public void addComponent(){
        ImageIcon hq = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\project\\images\\悔棋.png");
        hq.setImage(hq.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
        JButton hqbutton = new JButton(hq);
        hqbutton.setLocation(820, 420);
        hqbutton.setSize(45, 45);
        hqbutton.setBorder(null);
        hqbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //悔棋
            }
        });
        add(hqbutton);

        ImageIcon exit = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\project\\images\\退出.png");
        exit.setImage(exit.getImage().getScaledInstance(40, 60, Image.SCALE_DEFAULT));
        JButton exitbutton = new JButton(exit);
        exitbutton.setLocation(920, 420);
        exitbutton.setSize(40, 60);
        exitbutton.setBorder(null);
        exitbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exitbutton);

        JLabel statusLabel = new JLabel("BLACK's TURN");
        statusLabel.setLocation(835,47);
        statusLabel.setSize(200, 60);
        statusLabel.setFont(new Font("楷体", Font.BOLD, 20));
        statusLabel.setForeground(Color.WHITE);
        add(statusLabel);

        ImageIcon turn2 = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\project\\images\\b将.png");
        turn2.setImage(turn2.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
        JLabel turn2Label = new JLabel(turn2);
        turn2Label.setLocation(768, 48);
        turn2Label.setSize(45, 45);
        add(turn2Label);

        ImageIcon turn1 = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\project\\images\\棋框.png");
        turn1.setImage(turn1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        JLabel turn1Label = new JLabel(turn1);
        turn1Label.setLocation(760, 40);
        turn1Label.setSize(100, 100);
        add(turn1Label);

        ImageIcon turn = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\project\\images\\框.png");
        turn.setImage(turn.getImage().getScaledInstance(200, 70, Image.SCALE_DEFAULT));
        JLabel turnLabel = new JLabel(turn);
        turnLabel.setLocation(800, 40);
        turnLabel.setSize(200, 70);
        add(turnLabel);

        ImageIcon k = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\project\\images\\边框.png");
        k.setImage(k.getImage().getScaledInstance(730, 380, Image.SCALE_DEFAULT));
        JLabel kLabel = new JLabel(k);
        kLabel.setLocation(HEIGHT / 12 - 20, HEIGHT / 10 - 20);
        kLabel.setSize(720, 370);
        add(kLabel);




    }

    public int getWIDTH() {
        return WIDTH;
    }
    public int getHEIGHT() {
        return HEIGHT;
    }
    public GameController getGameController() {
        return gameController;
    }
    public static JLabel getStatusLabel() {
        return statusLabel;
    }
}
