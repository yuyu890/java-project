package view;


import chessComponent.*;
import controller.Saver;
import model.*;
import controller.ClickController;
import ui.ChessGameFrame;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * 这个类表示棋盘组建，其包含：
 * SquareComponent[][]: 4*8个方块格子组件
 * 属性：棋盘大小（8行4列）， 棋盘（用squarecomponent数组）， 行棋方棋子颜色，clickcontroller，CHESS_SIZE
 * 构造器：设置棋盘尺寸，棋子尺寸，棋子间距，把棋子都摆上棋盘上
 * 方法：获取棋子的布局数组，设置获得行棋方的颜色，将棋子放到棋盘上
 * 交换棋子，画格子，加载游戏
 */
public class Chessboard extends JComponent {


    private static final int ROW_SIZE = 4;
    private static final int COL_SIZE = 8;

    private final SquareComponent[][] squareComponents = new SquareComponent[ROW_SIZE][COL_SIZE];
    //做了一个棋盘，是8行4列的棋盘，然后每个位置是是一个方格
    //final数组的元素可以被重新赋值，但是不能改变引用变量指向的数组（等号后面不能变成其他数组）


    //todo: you can change the initial player
    private ChessColor currentColor = ChessColor.BLACK;
    //这个要修改，第一个玩家点击的棋子颜色是第一次currentcolor颜色

    //all chessComponents in this chessboard are shared only one model controller
    public final ClickController clickController = new ClickController();
    public static final int CHESS_SIZE = (700 - 4) / 8;

    ArrayList<ChessComponent> chesses = new ArrayList<>();

    public static Map<String, SquareComponent> abr_che = new HashMap<>();

    public Chessboard() {
        setLayout(null); // Use absolute layout.
        setSize(700, 350);
        SquareComponent.setSpacingLength(CHESS_SIZE / 12);
        System.out.printf("chessboard [%d * %d], chess size = %d\n", 700, 350, CHESS_SIZE);

        chesses.add(GeneralChessComponent.getGeneralb());
        chesses.add(GeneralChessComponent.getGeneralr());
        chesses.add(AdvisorChessComponent.getAdvisorb1());
        chesses.add(AdvisorChessComponent.getAdvisorb2());
        chesses.add(AdvisorChessComponent.getAdvisorr1());
        chesses.add(AdvisorChessComponent.getAdvisorr2());
        chesses.add(CannonChessComponent.getCannonb1());
        chesses.add(CannonChessComponent.getCannonb2());
        chesses.add(CannonChessComponent.getCannonr1());
        chesses.add(CannonChessComponent.getCannonr2());
        chesses.add(ChariotChessComponent.getChariotb1());
        chesses.add(ChariotChessComponent.getChariotb2());
        chesses.add(ChariotChessComponent.getChariotr1());
        chesses.add(ChariotChessComponent.getChariotr2());
        chesses.add(HorseChessComponent.getHorseb1());
        chesses.add(HorseChessComponent.getHorseb2());
        chesses.add(HorseChessComponent.getHorser1());
        chesses.add(HorseChessComponent.getHorser2());
        chesses.add(MinisterChessComponent.getMinisterb1());
        chesses.add(MinisterChessComponent.getMinisterb2());
        chesses.add(MinisterChessComponent.getMinisterr1());
        chesses.add(MinisterChessComponent.getMinisterr2());
        chesses.add(SoldierChessComponent.getSoldierb1());
        chesses.add(SoldierChessComponent.getSoldierb2());
        chesses.add(SoldierChessComponent.getSoldierb3());
        chesses.add(SoldierChessComponent.getSoldierb4());
        chesses.add(SoldierChessComponent.getSoldierb5());
        chesses.add(SoldierChessComponent.getSoldierr1());
        chesses.add(SoldierChessComponent.getSoldierr2());
        chesses.add(SoldierChessComponent.getSoldierr3());
        chesses.add(SoldierChessComponent.getSoldierr4());
        chesses.add(SoldierChessComponent.getSoldierr5());

        initAllChessOnBoard();
        for (SquareComponent s : chesses) {
            abr_che.put(s.getABBREVIATION(), s);
        }
        //abr_che.put("000", new EmptySlotComponent(new ChessboardPoint(0,0), new Point(), new ClickController(), 1, null));
        //这里写的是错的，先顶着，主要是空棋子的map，后面那个对象不知道该怎么写，不写空棋子好像又很难对应过去，我再想想吧
        //我决定这里直接不加空棋子了，如果哪里有需要我再加空棋子
    }

    /**
     * 获取棋子的布局数组
     *
     * @return
     */

    public SquareComponent[][] getChessComponents() {
        return squareComponents;
    }

    public void setChessComponents(SquareComponent[][] s) {
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[0].length; j++) {
                squareComponents[i][j] = s[i][j];
            }
        }
    }

    /**
     * 设置和获取行棋方棋子颜色
     *
     * @return
     */

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
        //获取这颗棋子的行列，如果这个位置有棋子（棋子布局数列），就移除这个棋子，把这个棋子放到数组的那个位置
        int row = squareComponent.getChessboardPoint().getX(), col = squareComponent.getChessboardPoint().getY();
        if (squareComponents[row][col] != null) {
            remove(squareComponents[row][col]);
        }
        add(squareComponents[row][col] = squareComponent);
    }

    /**
     * 交换chess1 chess2的位置
     * 如果方格上有棋子就把它换成空棋子，然后和方格1交换
     * 如果没棋子，直接与方格1交换位置和坐标
     *
     * @param chess1
     * @param chess2
     */
    public void swapChessComponents(SquareComponent chess1, SquareComponent chess2) {
        // Note that chess1 has higher priority, 'destroys' chess2 if exists.
        int x1 = chess1.getX();
        int y1 = chess1.getY();
        int x2 = chess2.getX();
        int y2 = chess2.getY();
        int count = 0;
        if (!(chess2 instanceof EmptySlotComponent)) {
            Saver.record(x1, y1, x2, y2, chess1, chess2);
            remove(chess2);
            add(chess2 = new EmptySlotComponent(chess2.getChessboardPoint(), chess2.getLocation(), null));
            count++;
            //这里要增加一个把chess2 也就是temporary的图像增加到棋盘边上的操作
        }
        //如果chess2不是空棋子，就把chess移走，在chess2的位置增加一个空棋子，然后让chess和空棋子交换位置，交换坐标
        chess1.swapLocation(chess2);
        int row1 = chess1.getChessboardPoint().getX(), col1 = chess1.getChessboardPoint().getY();
        squareComponents[row1][col1] = chess1;
        int row2 = chess2.getChessboardPoint().getX(), col2 = chess2.getChessboardPoint().getY();
        squareComponents[row2][col2] = chess2;
        if (count == 0) {
            Saver.record(x1, y1, x2, y2, chess1);
        }

        //只重新绘制chess1 chess2，其他不变
        chess1.repaint();
        chess2.repaint();
    }

    /**
     * 这是一个让棋子随机散布在棋盘上的方法
     * 要自己设置黑红个数，自己设置这是哪个棋子
     * 然后调用setvisible方法，把这个棋子放上棋盘上，最后全部放上去
     */


    //FIXME:   Initialize chessboard for testing only.
    private void initAllChessOnBoard() {
        disorder();
        for (int i = 0; i < squareComponents.length; i++) {
            for (int j = 0; j < squareComponents[i].length; j++) {
                SquareComponent squareComponent = squareComponents[i][j];
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
    private Point calculatePoint(int row, int col) {
        return new Point(col * CHESS_SIZE + 3, row * CHESS_SIZE + 3);
    }

    /**
     * 通过GameController调用该方法
     *
     * @param chessData 遍历list集合，输出了每一个string
     *                  这是干啥用的（就是提示我们在loading用的，也不需要调用
     */
    public void loadGame(List<String> chessData) {
        chessData.forEach(System.out::println);
    }

    private static Chessboard chessboard = new Chessboard();

    public static Chessboard getInstance() {
        return chessboard;
    }

    /**
     * 这是一个把棋盘棋子乱序后重新摆上棋盘的方法
     * 在 初始化棋盘 和 重新开局的时候需要调用
     */
    public void disorder() {
        int[] a = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3};
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int tmp = (int) (Math.random() * (a.length - i));//随机数[0,a.length-i]
            b[i] = a[tmp];
            int change = a[a.length - i - 1];
            a[a.length - i - 1] = a[tmp];
            a[tmp] = change;
        } //这里获得一个打乱顺序的a数组(即b数组），代表棋子的行
        for (int i = 0; i < b.length; i++) {
            //chesses.get(i).getChessboardPoint().setX(b[i]);
            chesses.get(i).getChessboardPoint().setX(b[i]);
        }//让棋子的横坐标等于打乱顺序的a数组的每个元素
        for (int j = 0; j <= 3; j++) {
            int c[] = {0, 1, 2, 3, 4, 5, 6, 7};
            int d[] = new int[c.length];
            for (int i = 0; i < c.length; i++) {
                int tmp = (int) (Math.random() * (c.length - i));//随机数[0,a.length-i]
                d[i] = c[tmp];
                int change = c[c.length - i - 1];
                c[c.length - i - 1] = c[tmp];
                c[tmp] = change;
            }//获得打乱顺序的d数组
            int count = 0;
            for (int i = 0; i < chesses.size(); i++) {
                if (chesses.get(i).getChessboardPoint().getX() == j) {
                    //如果第一次排序的x坐标等于第一次的j
                    //那么这个棋子的y坐标就设为
                    chesses.get(i).getChessboardPoint().setY(d[count]);
                    count++;
                }
            }//对打乱顺序后的每一行的每个棋子纵坐标进行排序，进行四次
        }
        for (ChessComponent c : chesses) {
            System.out.println(c.getABBREVIATION() + " " + c.getX() + " " + c.getY());
        }
        //然后在这里属于是把每个棋子的xy都打乱了
        //然后再把他们塞进 squarecomponent[][]里面
        for (ChessComponent c : chesses) {
            squareComponents[c.getChessboardPoint().getX()][c.getChessboardPoint().getY()] = c;
        }
        //好的现在我们成功把棋子都放上棋盘了（不可视地(数据上d的
    }


}
