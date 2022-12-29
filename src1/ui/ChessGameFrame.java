package ui;

import controller.GameController;
import util.PathUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

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
    private final int WIDTH;
    public final int HEIGHT;
    public GameController gameController;
    private static JLabel statusLabel;

    public ChessGameFrame(int width, int height) {
        setTitle("中国象棋 —— 暗棋  by 梁慧敏and刘昱铭"); //设置标题
        this.WIDTH = width;
        this.HEIGHT = height;
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
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img = tk.getImage("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\logo.png");
        Cursor cu = tk.createCustomCursor(img, new Point(10, 10),"stick");
        setCursor(cu);
        addScores();
        addComponent();
        addChessboard();
        addbkg();

    }

    public void addScores(){
        JLabel scoreLabel = new JLabel("0");
        scoreLabel.setLocation(820,140);
        scoreLabel.setSize(200, 60);
        scoreLabel.setFont(new Font("楷体", Font.BOLD, 30));
        scoreLabel.setForeground(Color.black);
        scoreLabel.setBorder(null);
        add(scoreLabel);

        JLabel scoreLabe = new JLabel("0");
        scoreLabe.setLocation(820,190);
        scoreLabe.setSize(200, 60);
        scoreLabe.setFont(new Font("楷体", Font.BOLD, 30));
        scoreLabe.setForeground(Color.black);
        scoreLabe.setBorder(null);
        add(scoreLabe);

        JLabel scoreLabl = new JLabel("0");
        scoreLabl.setLocation(820,240);
        scoreLabl.setSize(200, 60);
        scoreLabl.setFont(new Font("楷体", Font.BOLD, 30));
        scoreLabl.setForeground(Color.black);
        scoreLabl.setBorder(null);
        add(scoreLabl);

        JLabel scoreLael = new JLabel("0");
        scoreLael.setLocation(820,290);
        scoreLael.setSize(200, 60);
        scoreLael.setFont(new Font("楷体", Font.BOLD, 30));
        scoreLael.setForeground(Color.black);
        scoreLael.setBorder(null);
        add(scoreLael);

        JLabel scoreLbel = new JLabel("0");
        scoreLbel.setLocation(820,340);
        scoreLbel.setSize(200, 60);
        scoreLbel.setFont(new Font("楷体", Font.BOLD, 30));
        scoreLbel.setForeground(Color.black);
        scoreLbel.setBorder(null);
        add(scoreLbel);

        JLabel scoreabel = new JLabel("0");
        scoreabel.setLocation(820,390);
        scoreabel.setSize(200, 60);
        scoreabel.setFont(new Font("楷体", Font.BOLD, 30));
        scoreabel.setForeground(Color.black);
        scoreabel.setBorder(null);
        add(scoreabel);

        JLabel scorLabel = new JLabel("0");
        scorLabel.setLocation(820,440);
        scorLabel.setSize(200, 60);
        scorLabel.setFont(new Font("楷体", Font.BOLD, 30));
        scorLabel.setForeground(Color.black);
        scorLabel.setBorder(null);
        add(scorLabel);

        JLabel scoreLab = new JLabel("0");
        scoreLab.setLocation(910,140);
        scoreLab.setSize(200, 60);
        scoreLab.setFont(new Font("楷体", Font.BOLD, 30));
        scoreLab.setForeground(Color.black);
        scoreLab.setBorder(null);
        add(scoreLab);

        JLabel scoreLa = new JLabel("0");
        scoreLa.setLocation(910,190);
        scoreLa.setSize(200, 60);
        scoreLa.setFont(new Font("楷体", Font.BOLD, 30));
        scoreLa.setForeground(Color.black);
        scoreLa.setBorder(null);
        add(scoreLa);

        JLabel scoreLb = new JLabel("0");
        scoreLb.setLocation(910,240);
        scoreLb.setSize(200, 60);
        scoreLb.setFont(new Font("楷体", Font.BOLD, 30));
        scoreLb.setForeground(Color.black);
        scoreLb.setBorder(null);
        add(scoreLb);

        JLabel scoreab = new JLabel("0");
        scoreab.setLocation(910,290);
        scoreab.setSize(200, 60);
        scoreab.setFont(new Font("楷体", Font.BOLD, 30));
        scoreab.setForeground(Color.black);
        scoreab.setBorder(null);
        add(scoreab);

        JLabel scorLab = new JLabel("0");
        scorLab.setLocation(910,340);
        scorLab.setSize(200, 60);
        scorLab.setFont(new Font("楷体", Font.BOLD, 30));
        scorLab.setForeground(Color.black);
        scorLab.setBorder(null);
        add(scorLab);

        JLabel scoeLab = new JLabel("0");
        scoeLab.setLocation(910,390);
        scoeLab.setSize(200, 60);
        scoeLab.setFont(new Font("楷体", Font.BOLD, 30));
        scoeLab.setForeground(Color.black);
        scoeLab.setBorder(null);
        add(scoeLab);

        JLabel screLab = new JLabel("0");
        screLab.setLocation(910,440);
        screLab.setSize(200, 60);
        screLab.setFont(new Font("楷体", Font.BOLD, 30));
        screLab.setForeground(Color.black);
        screLab.setBorder(null);
        add(screLab);




    }





    private void addChessboard() {
        Chessboard chessboard = new Chessboard(690 , 340, "local");
        gameController = new GameController(chessboard);
        chessboard.setLocation(HEIGHT / 12, (HEIGHT / 10) - 5);
        add(chessboard);
    }



    public void addbkg(){
        ImageIcon bkg = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\background.png");
        bkg.setImage(bkg.getImage().getScaledInstance(1000, 525, Image.SCALE_DEFAULT));
        JLabel bg = new JLabel(bkg);
        bg.setBounds(0, 0, this.getWidth(), this.getHeight());
        add(bg);
    }


    public void addComponent(){
        ImageIcon hq = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\悔棋.png");
        hq.setImage(hq.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
        JButton hqbutton = new JButton(hq);
        hqbutton.setLocation(420, 435);
        hqbutton.setSize(45, 45);
        hqbutton.setBorder(null);
        hqbutton.setContentAreaFilled(false);
        hqbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Click restart");
                gameController.getChessboard().initAllChessOnBoard();
            }
        });
        add(hqbutton);

        ImageIcon exit = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\退出.png");
        exit.setImage(exit.getImage().getScaledInstance(40, 60, Image.SCALE_DEFAULT));
        JButton exitbutton = new JButton(exit);
        exitbutton.setLocation(520, 430);
        exitbutton.setSize(40, 60);
        exitbutton.setBorder(null);
        exitbutton.setContentAreaFilled(false);
        exitbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = JOptionPane.showConfirmDialog(null,"您真的要退出吗？","退出",JOptionPane.YES_NO_OPTION);
                if(i == 0){
                    System.exit(0);
                }
            }
        });
        add(exitbutton);

        statusLabel = new JLabel("??????");
        statusLabel.setLocation(820,25);
        statusLabel.setSize(200, 60);
        statusLabel.setFont(new Font("楷体", Font.BOLD, 20));
        statusLabel.setForeground(Color.WHITE);
        statusLabel.setBorder(null);
        add(statusLabel);

        JLabel scoreLabel = new JLabel("…… ：……");
        scoreLabel.setLocation(820,95);
        scoreLabel.setSize(200, 60);
        scoreLabel.setFont(new Font("楷体", Font.BOLD, 20));
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setBorder(null);
        add(scoreLabel);

        ImageIcon turn2 = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\b将.png");
        turn2.setImage(turn2.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        JLabel turn2Label = new JLabel(turn2);
        turn2Label.setLocation(774, 104);
        turn2Label.setSize(40, 40);
        turn2Label.setBorder(null);
        add(turn2Label);

        ImageIcon turn1 = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\棋框.png");
        turn1.setImage(turn1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        JLabel turn1Label = new JLabel(turn1);
        turn1Label.setLocation(770, 100);
        turn1Label.setSize(80, 80);
        turn1Label.setBorder(null);
        add(turn1Label);

        ImageIcon turn3 = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\r将.png");
        turn3.setImage(turn3.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        JLabel turn3Label = new JLabel(turn3);
        turn3Label.setLocation(929, 104);
        turn3Label.setSize(40, 40);
        turn3Label.setBorder(null);
        add(turn3Label);

        ImageIcon turn4 = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\棋框.png");
        turn4.setImage(turn4.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        JLabel turn4Label = new JLabel(turn4);
        turn4Label.setLocation(925, 100);
        turn4Label.setSize(80, 80);
        turn4Label.setBorder(null);
        add(turn4Label);

        ImageIcon turn = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\框.png");
        turn.setImage(turn.getImage().getScaledInstance(200, 70, Image.SCALE_DEFAULT));
        JLabel turnLabel = new JLabel(turn);
        turnLabel.setLocation(775, 20);
        turnLabel.setSize(200, 70);
        turnLabel.setBorder(null);
        add(turnLabel);

        ImageIcon turn5 = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\框.png");
        turn5.setImage(turn5.getImage().getScaledInstance(200, 70, Image.SCALE_DEFAULT));
        JLabel turn5Label = new JLabel(turn5);
        turn5Label.setLocation(775, 90);
        turn5Label.setSize(200, 70);
        turn5Label.setBorder(null);
        add(turn5Label);

        ImageIcon k = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\边框.png");
        k.setImage(k.getImage().getScaledInstance(730, 380, Image.SCALE_DEFAULT));
        JLabel kLabel = new JLabel(k);
        kLabel.setLocation(HEIGHT / 12 - 20, HEIGHT / 10 - 20);
        kLabel.setSize(720, 370);
        kLabel.setBorder(null);
        add(kLabel);

        ImageIcon phb = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\排行榜.png");
        phb.setImage(phb.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
        JButton phbLabel = new JButton(phb);
        phbLabel.setLocation(320, 420);
        phbLabel.setSize(60, 60);
        phbLabel.setBorder(null);
        phbLabel.setContentAreaFilled(false);
        phbLabel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new NumberJFrame();
            }
        });
        add(phbLabel);

        ImageIcon zb = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\作弊.png");
        zb.setImage(zb.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        JButton zbLabel = new JButton(zb);
        zbLabel.setLocation(210, 430);
        zbLabel.setSize(50, 50);
        zbLabel.setBorder(null);
        zbLabel.setContentAreaFilled(false);
        zbLabel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //????????
            }
        });
        add(zbLabel);

        ImageIcon bc = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\导入.png");
        bc.setImage(bc.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        JButton bcLabel = new JButton(bc);
        bcLabel.setLocation(100, 430);
        bcLabel.setSize(50, 50);
        bcLabel.setBorder(null);
        bcLabel.setContentAreaFilled(false);
        bcLabel.addActionListener(e -> {
            System.out.println("Click load");
            String path = JOptionPane.showInputDialog(this, "Input Path here");
            int i = path.lastIndexOf('.');
            String s = path.substring(i+1);
            if(!s.equals("txt")){
                //跳出弹窗：文件格式错误
                //●描述： 比如支持存储文件是txt，导入的是json
                //●错误编码： 101
                return;
            }
            gameController.loadGameFromFile(path);
        });
        add(bcLabel);

        ImageIcon zr = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\保存.png");
        zr.setImage(zr.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        JButton zrLabel = new JButton(zr);
        zrLabel.setLocation(10, 430);
        zrLabel.setSize(50, 50);
        zrLabel.setBorder(null);
        zrLabel.setContentAreaFilled(false);
        zrLabel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //????????
            }
        });
        add(zrLabel);

        ImageIcon j = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\b将.png");
        j.setImage(j.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        JLabel jLabel = new JLabel(j);
        jLabel.setLocation(850, 150);
        jLabel.setSize(40, 40);
        jLabel.setBorder(null);
        add(jLabel);

        ImageIcon s = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\b士.png");
        s.setImage(s.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        JLabel sLabel = new JLabel(s);
        sLabel.setLocation(850, 200);
        sLabel.setSize(40, 40);
        sLabel.setBorder(null);
        add(sLabel);

        ImageIcon x = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\b象.png");
        x.setImage(x.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        JLabel xLabel = new JLabel(x);
        xLabel.setLocation(850, 250);
        xLabel.setSize(40, 40);
        xLabel.setBorder(null);
        add(xLabel);

        ImageIcon m = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\b马.png");
        m.setImage(m.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        JLabel mLabel = new JLabel(m);
        mLabel.setLocation(850, 300);
        mLabel.setSize(40, 40);
        mLabel.setBorder(null);
        add(mLabel);

        ImageIcon c = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\b车.png");
        c.setImage(c.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        JLabel cLabel = new JLabel(c);
        cLabel.setLocation(850, 350);
        cLabel.setSize(40, 40);
        cLabel.setBorder(null);
        add(cLabel);

        ImageIcon p = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\b炮.png");
        p.setImage(p.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        JLabel pLabel = new JLabel(p);
        pLabel.setLocation(850, 400);
        pLabel.setSize(40, 40);
        pLabel.setBorder(null);
        add(pLabel);

        ImageIcon b = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\b兵.png");
        b.setImage(b.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        JLabel bLabel = new JLabel(b);
        bLabel.setLocation(850, 450);
        bLabel.setSize(40, 40);
        bLabel.setBorder(null);
        add(bLabel);

    }
    public GameController getGameController() {
        return gameController;
    }
    public static JLabel getStatusLabel() {
        return statusLabel;
    }
}

//"%s's TURN",gameController.getChessboard().getCurrentColor())