package ui;


import chessComponent.chessLibrary.*;
import chessComponent.EmptySlotComponent;
import chessComponent.SquareComponent;
import model.*;
import controller.ClickController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 这个类表示棋盘组建，其包含：
 * SquareComponent[][]: 4*8个方块格子组件
 */
public class Chessboard extends JComponent {


    private static final int ROW_SIZE = 4;
    private static final int COL_SIZE = 8;

    public final SquareComponent[][] squareComponents = new SquareComponent[ROW_SIZE][COL_SIZE];
    //todo: you can change the initial player
    private ChessColor currentColor = ChessColor.NONE;

    //all chessComponents in this chessboard are shared only one model controller
    public final ClickController clickController = new ClickController(this);
    public final int CHESS_SIZE;

    public ArrayList<SquareComponent> blackDead = new ArrayList<>();
    public ArrayList<SquareComponent> redDead = new ArrayList<>();

    public int blackPoints = 0;
    public int redPoints = 0;
    //需要在gameframe里面添加两个显示red和black得分的

    public ChessColor playerAColor = null;

    public String mode = null;

    public ChessColor robotColor = null;


    public Chessboard(int width, int height, String mode) {
        setLayout(null); // Use absolute layout.
        setSize(width + 2, height);
        CHESS_SIZE = (width - 6) / 8;
        SquareComponent.setSpacingLength(CHESS_SIZE / 12);
        System.out.printf("chessboard [%d * %d], chess size = %d\n", width, height, CHESS_SIZE);
        this.mode = mode;
        this.robotColor = robotColor;
        initAllChessOnBoard();
    }

    public SquareComponent[][] getChessComponents() {
        return squareComponents;
    }

    public ChessColor getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(ChessColor currentColor) {
        this.currentColor = currentColor;
    }

    /**
     * 将SquareComponent 放置在 ChessBoard上。里面包含移除原有的component及放置新的component
     *
     * @param squareComponent
     */
    public void putChessOnBoard(SquareComponent squareComponent) {
        int row = squareComponent.getChessboardPoint().getX(), col = squareComponent.getChessboardPoint().getY();
        if (squareComponents[row][col] != null) {
            remove(squareComponents[row][col]);
        }
        add(squareComponents[row][col] = squareComponent);
        //把棋子添加到squarecomponents数组里面，然后add到面板上面
        repaint();
    }

    /**
     * 交换chess1 chess2的位置
     *
     * @param chess1
     * @param chess2
     */
    public void swapChessComponents(SquareComponent chess1, SquareComponent chess2) {
        // Note that chess1 has higher priority, 'destroys' chess2 if exists.
        if (!(chess2 instanceof EmptySlotComponent)) {
            switch (chess2.chessColor) {
                case BLACK -> blackDead.add(chess2);
                case RED -> redDead.add(chess2);
            }
            remove(chess2);
            add(chess2 = new EmptySlotComponent(chess2.getChessboardPoint(), chess2.getLocation(), clickController, CHESS_SIZE));
        }
        chess1.swapLocation(chess2);
        int row1 = chess1.getChessboardPoint().getX(), col1 = chess1.getChessboardPoint().getY();
        squareComponents[row1][col1] = chess1;
        int row2 = chess2.getChessboardPoint().getX(), col2 = chess2.getChessboardPoint().getY();
        squareComponents[row2][col2] = chess2;

        //只重新绘制chess1 chess2，其他不变
        chess1.repaint();
        chess2.repaint();
    }


    //FIXME:   Initialize chessboard for testing only.
    public void initAllChessOnBoard() {
        /**将双方（红，黑）
         * 5个Soldier(0,1)，
         * 2个Horse(2,3)，
         * 2个Chariot(4,5)，
         * 2个Minister(6,7)，
         * 2个Adviser(8,9)，
         * 1个General(10,11)和
         * 2个cannon(12,13)
         * 随机放置在棋盘上*/
        List<Integer> chessComponents = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            chessComponents.add(0);
            chessComponents.add(1);
        }
        for (int i = 0; i < 2; i++) {
            chessComponents.add(2);
            chessComponents.add(3);
            chessComponents.add(4);
            chessComponents.add(5);
            chessComponents.add(6);
            chessComponents.add(7);
            chessComponents.add(8);
            chessComponents.add(9);
            chessComponents.add(12);
            chessComponents.add(13);
        }
        chessComponents.add(10);
        chessComponents.add(11);
        //接着从”盲抽袋“（chessComponents）里一个个抽出棋子，放置在棋盘上
        Random random = new Random();
        for (int i = 0; i < squareComponents.length; i++) {
            for (int j = 0; j < squareComponents[i].length; j++) {
                SquareComponent squareComponent;
                int index = random.nextInt(chessComponents.size());
                switch (chessComponents.get(index)) {
                    case 0 -> squareComponent = new SoldierChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);
                    case 1-> squareComponent = new SoldierChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);
                    case 2 -> squareComponent = new HorseChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);
                    case 3-> squareComponent = new HorseChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);
                    case 4-> squareComponent = new ChariotChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);
                    case 5-> squareComponent = new ChariotChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);
                    case 6-> squareComponent = new MinisterChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);
                    case 7-> squareComponent = new MinisterChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);
                    case 8-> squareComponent = new AdviserChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);
                    case 9-> squareComponent = new AdviserChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);
                    case 10-> squareComponent = new GeneralChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);
                    case 11-> squareComponent = new GeneralChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);
                    case 12-> squareComponent = new CannonChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);
                    case 13-> squareComponent = new CannonChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);
                    default-> squareComponent = new EmptySlotComponent(new ChessboardPoint(i, j), calculatePoint(i, j), clickController, CHESS_SIZE);

                }
                chessComponents.remove(index);
                squareComponent.setVisible(true);
                putChessOnBoard(squareComponent);
            }
        }

    }

    /**
     * 绘制棋盘格子
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    /**
     * 将棋盘上行列坐标映射成Swing组件的Point
     *
     * @param row 棋盘上的行
     * @param col 棋盘上的列
     * @return
     */
    public Point calculatePoint(int row, int col) {
        return new Point(col * CHESS_SIZE + 3, row * CHESS_SIZE + 3);
    }

    /**
     * 通过GameController调用该方法
     *
     * @param chessData
     */
    public void loadGame(List<String> chessData) {
        chessData.forEach(System.out::println);
        clickController.saver.readProcedure(chessData);
        clickController.saver.loadGameFromProcedure();
    }

    //一个用来刷新场上双方得分的方法
    public void points() {
        //红方得分
        redPoints = blackPoints = 0;
        for (SquareComponent s : blackDead) {
            redPoints += s.points;
        }
        for (SquareComponent s : redDead) {
            blackPoints += s.points;
        }
    }

    public void endGame() {
        if (redPoints >= 60 || blackPoints >= 60) {
            //跳出弹窗：xx赢了，游戏结束， 弹窗需要附加两个按钮，一个是不玩了(回到主界面，一个是再玩一局（重新new一个chessgemeframe
            //这里赢了可以给用户的赢的局数增加，你看着做

        }
    }

    int countcheating = 0;

    public void cheating() {
        countcheating++;
        /**
         * 在cheating按钮被点击的时候调用
         * 如果这个方法被调用一次，那么count会增加，最开始是0
         * 如果count是偶数，那么调用这个方法的时候，就关闭cheating
         * 如果count是奇数，就开启cheating，在点击cheating按钮的时候，要调用这个方法
         */
        if (countcheating % 2 == 1) {
            //开启作弊
            for (int i = 0; i < squareComponents.length; i++) {
                for (int j = 0; j < squareComponents.length; j++) {
                    squareComponents[i][j].isReversal = true;
                    putChessOnBoard(squareComponents[i][j]);
                }
            }
        } else {
            //关闭作弊,直接偷懒加载上一次的棋盘算了
            clickController.saver.loadGameFromProcedure();
        }
    }

    public void botChessTime() {

        //机器人下棋，在currentcolor不是玩家颜色的时候调用
        /**
         * 这个是stupid的
         * 如果场上翻开的棋子数量小于5，就翻开棋子
         * 如果场上的翻开棋子数量大于5，就移动棋子，如果没有棋子可以移动，就翻开棋子
         */

        int count = 0;
        for (int i = 0; i < squareComponents.length; i++) {
            for (int j = 0; j < squareComponents[i].length; j++) {
                if (squareComponents[i][j].isReversal) {
                    count++;
                }
            }
        }
        if (count > 5) {

            for (int i = 0; i < squareComponents.length; i++) {
                ArrayList<SquareComponent> can = new ArrayList<>();
                for (int j = 0; j < squareComponents[i].length; j++) {
                    if (squareComponents[i][j].isReversal && squareComponents[i][j].chessColor == robotColor) {
                        ArrayList<ChessboardPoint> p = squareComponents[i][j].canWalkTo(squareComponents);
                        if (p.size() != 0) {
                            can.add(squareComponents[i][j]);
                        }
                    }
                }
                if(can.size() >= 2){
                    Random r = new Random();
                    SquareComponent s = can.get(r.nextInt(can.size()));
                    ArrayList<ChessboardPoint> p = s.canWalkTo(squareComponents);
                    swapChessComponents(s, squareComponents[p.get(0).getX()][p.get(0).getY()]);
                    clickController.swapPlayer();
                    return;
                }
            }

            ArrayList<ChessboardPoint> pp = new ArrayList<>();
            for (int i = 0; i < squareComponents.length; i++) {
                for (int j = 0; j < squareComponents[i].length; j++) {
                    if (!squareComponents[i][j].isReversal && !(squareComponents[i][j] instanceof EmptySlotComponent)) {
                        //没有翻开并且不是空棋子
                        pp.add(new ChessboardPoint(i, j));
                    }
                }
            }
            Random r = new Random();
            ChessboardPoint p = pp.get(r.nextInt(pp.size()));
            squareComponents[p.getX()][p.getY()].setReversal(true);
            System.out.printf("robot reserved a chess (%d, %d)\n", p.getX(), p.getY());
            squareComponents[p.getX()][p.getY()].repaint();
            clickController.swapPlayer();


        } else {
            //翻开一面棋子
            ArrayList<ChessboardPoint> pp = new ArrayList<>();
            for (int i = 0; i < squareComponents.length; i++) {
                for (int j = 0; j < squareComponents[i].length; j++) {
                    if (!squareComponents[i][j].isReversal && !(squareComponents[i][j] instanceof EmptySlotComponent)) {
                        //没有翻开并且不是空棋子
                        pp.add(new ChessboardPoint(i, j));
                    }
                }
            }
            Random r = new Random();
            ChessboardPoint p = pp.get(r.nextInt(pp.size()));
            squareComponents[p.getX()][p.getY()].setReversal(true);
            System.out.printf("robot reserved a chess (%d, %d)\n", p.getX(), p.getY());
            squareComponents[p.getX()][p.getY()].repaint();
            clickController.swapPlayer();
        }
    }

    public void trigger() {
        if (robotColor != null) {
            if (getCurrentColor() == robotColor) {
                botChessTime();
            }
        }
    }

}
