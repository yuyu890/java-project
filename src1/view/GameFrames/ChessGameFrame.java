package view.GameFrames;

import controller.GameController;
import ui.Chessboard;

import javax.swing.*;
import java.awt.*;

/**
 * 这个类表示游戏窗体，窗体上包含：
 * 1 Chessboard: 棋盘
 * 2 JLabel:  标签
 * 3 JButton： 按钮
 */
public class ChessGameFrame extends JFrame {
    public final int WIDTH;
    public final int HEIGHT;
    public final int CHESSBOARD_SIZE;
    public GameController gameController;
    private static JLabel statusLabel;



    public ChessGameFrame(int width, int height) {
        setTitle("2022 CS109 Project Demo"); //设置标题
        this.WIDTH = width;
        this.HEIGHT = height;
        this.CHESSBOARD_SIZE = HEIGHT * 4 / 5;

        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null); // Center the window.
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了
        setLayout(null);

        addChessboard();
        addLabel();

//        addHelloButton();
//        addLoadButton();
//        addRestartButton();
    }

    /**
     * 在游戏窗体中添加棋盘
     */
    public void addChessboard() {
        Chessboard chessboard = new Chessboard(CHESSBOARD_SIZE , CHESSBOARD_SIZE/2, "local");
        gameController = new GameController(chessboard);
        chessboard.setLocation(HEIGHT / 10, HEIGHT / 10);
        add(chessboard);
    }

    /**
     * 在游戏窗体中添加标签
     */
    private void addLabel() {
        statusLabel = new JLabel(String.format("%s's TURN",gameController.getChessboard().getCurrentColor()));
        statusLabel.setLocation(WIDTH /2, HEIGHT  *2/ 3);
        statusLabel.setSize(200, 60);
        statusLabel.setFont(new Font("楷体", Font.BOLD, 20));
        add(statusLabel);
    }


    public static JLabel getStatusLabel() {
        return statusLabel;
    }

    /**
     * 在游戏窗体中增加一个按钮，如果按下的话就会显示Hello, world!
     */

    private void addHelloButton() {
        JButton button = new JButton("Show Hello Here");
        button.addActionListener((e) -> JOptionPane.showMessageDialog(this, "Hello, world!"));
        button.setLocation(WIDTH * 3 / 5, HEIGHT / 10 + 120);
        button.setSize(180, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);
    }

    private void addLoadButton() {
        JButton button = new JButton("Load");
        button.setLocation(WIDTH * 3 / 5, HEIGHT / 10 + 240);
        button.setSize(180, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        button.setBackground(Color.LIGHT_GRAY);
        add(button);

        button.addActionListener(e -> {
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


    }

    //重新开始游戏按钮
    private void addRestartButton() {
        JButton button = new JButton("Restart");
        button.setLocation(WIDTH * 3 / 5, HEIGHT / 10 + 360);
        button.setSize(180, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        button.setBackground(Color.LIGHT_GRAY);
        add(button);

        button.addActionListener(e -> {
            System.out.println("Click restart");
            gameController.getChessboard().initAllChessOnBoard();
        });
    }

    public GameController getGameController() {
        return gameController;
    }

    public void trigger(){

    }

}
