package chessComponent;

import controller.ClickController;
import model.ChessColor;
import model.ChessboardPoint;
import view.Chessboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentNavigableMap;

/**
 * 这个类是一个抽象类，主要表示8*4棋盘上每个格子的棋子情况。
 * 有两个子类：
 * 1. EmptySlotComponent: 空棋子
 * 2. ChessComponent: 表示非空棋子
 * 构造器：enableEvents，setLocation，设置尺寸size， 棋子颜色，棋子坐标，未选中，未翻转
 * 属性：棋盘格颜色 spacingLength（间隔距离） CHESS_FONT（字体）
 * 棋子位置 棋子颜色 是否翻转 是否选中 clickController
 * 方法：是否翻转的get和set方法， 设置间隔距离， 设置和获取方块的坐标，获取棋子的颜色
 * 设置或判断方块是否被选中，与另一个方块交换位置，方块被选中时的行为，检查移动的合法性，给方块涂色（不知道是啥，迷糊
 */
public abstract class SquareComponent extends JComponent {

    private static final Color squareColor = new Color(250, 220, 190);
    protected static int spacingLength;
    protected static final Font CHESS_FONT = new Font("宋体", Font.BOLD, 36);

    /**
     * chessboardPoint: 表示8*4棋盘中，当前棋子在棋格对应的位置，如(0, 0), (1, 0)等等
     * chessColor: 表示这个棋子的颜色，有红色，黑色，无色三种
     * isReversal: 表示是否翻转
     * selected: 表示这个棋子是否被选中
     */
    private ChessboardPoint chessboardPoint;
    protected final ChessColor chessColor;
    protected boolean isReversal;
    private boolean selected;

    /**
     * handle click event
     */
    private final ClickController clickController;

    private final String ABBREVIATION;

    /**
     *
     * @param chessboardPoint 棋子的坐标
     * @param location 棋子的位置
     * @param chessColor 棋子的颜色
     */

    protected SquareComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, String abbreviation) {
        //人机交互
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
        //可视化
        setLocation(location);  //void setLocation(Pointp) 将组件移动到新的位置 new point( x, y)
        setSize(Chessboard.CHESS_SIZE, Chessboard.CHESS_SIZE);  //设置组件的宽和高
        //不可视的程序运行参数
        this.chessboardPoint = chessboardPoint; //设置棋子的坐标
        this.chessColor = chessColor; //设置棋子颜色
        this.selected = false;  //未被选中
        this.clickController = new ClickController();
        this.isReversal = false;  //未翻转
        this.ABBREVIATION = abbreviation;
    }

    /**
     * 翻转的get和set方法
     * @return
     */
    public boolean isReversal() {
        return isReversal;
    }

    public void setReversal(boolean reversal) {
        isReversal = reversal;
    }

    /**
     *设置间隔距离
     * @param spacingLength
     */

    public static void setSpacingLength(int spacingLength) {
        SquareComponent.spacingLength = spacingLength;
    }

    /**
     * 设置和获取棋子在棋盘上的坐标
     * @return
     */

    public ChessboardPoint getChessboardPoint() {
        return chessboardPoint;
    }

    public void setChessboardPoint(ChessboardPoint chessboardPoint) {
        this.chessboardPoint = chessboardPoint;
    }

    /**
     * 获取棋子的颜色信息
     * @return
     */

    public ChessColor getChessColor() {
        return chessColor;
    }

    /**
     * 棋子选中与否的设置与判断
     * @return
     */

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * 这个方法需要重写/补充
     * @param another 主要用于和另外一个棋子交换位置
     *                <br>
     *                调用时机是在移动棋子的时候，将操控的棋子和对应的空位置棋子(EmptySlotComponent)做交换
     *                如果另外一个SquareComponent是空，就是交换
     *                如果是己方，交换失败不动，报错，违规操作
     *                如果是对方，位置换过去，原来的位置放空棋子，对方的棋子被吃掉放在旁边
     */
    public void swapLocation(SquareComponent another) {
        ChessboardPoint chessboardPoint1 = getChessboardPoint(); //在操作的棋子的坐标
        ChessboardPoint chessboardPoint2 = another.getChessboardPoint(); //移动目的地坐标
        Point point1 = getLocation(), point2 = another.getLocation(); //操作的棋子的位置，和移动目的地的位置
        //将操作的棋子和移动目地的棋子交换 坐标和位置
        setChessboardPoint(chessboardPoint2);
        setLocation(point2);
        another.setChessboardPoint(chessboardPoint1);
        another.setLocation(point1);
    }

    /**
     * @param e 响应鼠标监听事件
     *          <br>
     *          当这个方块（squarecomponent）接收到鼠标动作的时候，这个方法就会自动被调用，
     *          调用监听者的onClick方法，处理棋子的选中，移动等等行为。
     */
    @Override
    protected void processMouseEvent(MouseEvent e) {
        super.processMouseEvent(e);
        //如果鼠标动作为鼠标点击，输出点击的（这个方块）的坐标
        //然后调用clickController.onClick方法，这个方法是对选取的棋子进行操作
        if (e.getID() == MouseEvent.MOUSE_PRESSED) {
            System.out.printf("Click [%d,%d]\n", chessboardPoint.getX(), chessboardPoint.getY());
            clickController.onClick(this);
        }
    }

    /**
     * @param chessboard  棋盘
     * @param destination 目标位置，如(0, 0), (0, 1)等等
     * @return this棋子对象的移动规则和当前位置(chessboardPoint)能否到达目标位置
     * <br>
     * 这个方法主要是检查移动的合法性，如果合法就返回true，反之是false。
     */
    //todo: Override this method for Cannon
    public boolean canMoveTo(SquareComponent[][] chessboard, ChessboardPoint destination) {
        SquareComponent dc = chessboard[destination.getX()][destination.getY()];
        if(!this.caneat(dc)){
            return false;
        }
        //目的地格子 = 目标坐标上的格子（未翻开/敌方/我方/空棋子）
        //首先要判断目的地格子属不属于他的移动范围内
        //如果属于再去判断这个目的地格子上的东西我能不能走
        //下面的代码需要自己补充
        /**
         * 移动范围
         * 首先除了炮， 一个棋子可以上下左右地走，所以他的范围是 y不动x加减1， x不动y加减1
         * 如果超过了这个范围就会有提示
         * 如果是炮，在炮里面重写这个方法
         */
        //能不能走
        //如果目的地棋子翻开了 或者 目的地棋子属于空棋子 返回true，也就是能够走
        //如果目的地是同一个色，违法操作
        //不是同一个色，吃棋子
        //空棋子：直接交换squarecomponent，这和上面的swaplocation有哈区别

        //这里是 这个棋子能够走的点的数组
        /**
         * 能走的就是上下左右
         * 但是目的地有三种情况
         * 没翻开的棋子， 走不了
         * 空棋子， 可以走 白色
         * 自己颜色的棋子， 走不了
         * 对方颜色的棋子， 可以走
         */
        ArrayList<ChessboardPoint> canWAlkTo = new ArrayList<>();
        SquareComponent[][] ss = Chessboard.getInstance().getChessComponents();
        //哇塞这里真的不用这么写，写的这么复杂，又长又臭的代码
        if(chessboardPoint.getY()-1 >= 0 && ss[chessboardPoint.getX()][chessboardPoint.getY()-1].chessColor != this.chessColor && ss[chessboardPoint.getX()][chessboardPoint.getY()-1].isReversal){
            //第一个是棋子翻开了，并且是对方颜色  第二个是棋子没翻开，但是空棋子
            if((ss[chessboardPoint.getX()][chessboardPoint.getY()-1].isReversal && ss[chessboardPoint.getX()][chessboardPoint.getY()-1].chessColor != this.chessColor) ||
                    !ss[chessboardPoint.getX()][chessboardPoint.getY()-1].isReversal && ss[chessboardPoint.getX()][chessboardPoint.getY()-1].chessColor == ChessColor.NONE){
                canWAlkTo.add(new ChessboardPoint(this.chessboardPoint.getX(), chessboardPoint.getY()-1));
            }

        }
        if(chessboardPoint.getY()+1 <= 7 && ss[chessboardPoint.getX()][chessboardPoint.getY()+1].chessColor != this.chessColor){
            if((ss[chessboardPoint.getX()][chessboardPoint.getY()-1].isReversal && ss[chessboardPoint.getX()][chessboardPoint.getY()-1].chessColor != this.chessColor) ||
                    !ss[chessboardPoint.getX()][chessboardPoint.getY()-1].isReversal && ss[chessboardPoint.getX()][chessboardPoint.getY()-1].chessColor == ChessColor.NONE){
                canWAlkTo.add(new ChessboardPoint(this.chessboardPoint.getX(), chessboardPoint.getY()+1));
            }

        }
        if(chessboardPoint.getX()-1 >= 0 && ss[chessboardPoint.getX()-1][chessboardPoint.getY()].chessColor != this.chessColor){
            if((ss[chessboardPoint.getX()][chessboardPoint.getY()-1].isReversal && ss[chessboardPoint.getX()][chessboardPoint.getY()-1].chessColor != this.chessColor) ||
                    !ss[chessboardPoint.getX()][chessboardPoint.getY()-1].isReversal && ss[chessboardPoint.getX()][chessboardPoint.getY()-1].chessColor == ChessColor.NONE){
                canWAlkTo.add(new ChessboardPoint(this.chessboardPoint.getX()-1, chessboardPoint.getY()));
            }

        }
        if(chessboardPoint.getX()+1 >= 3 && ss[chessboardPoint.getX()+1][chessboardPoint.getY()].chessColor != this.chessColor){
            if((ss[chessboardPoint.getX()][chessboardPoint.getY()-1].isReversal && ss[chessboardPoint.getX()][chessboardPoint.getY()-1].chessColor != this.chessColor) ||
                    !ss[chessboardPoint.getX()][chessboardPoint.getY()-1].isReversal && ss[chessboardPoint.getX()][chessboardPoint.getY()-1].chessColor == ChessColor.NONE){
                canWAlkTo.add(new ChessboardPoint(this.chessboardPoint.getX()+1, chessboardPoint.getY()));
            }
        }
        for(ChessboardPoint p : canWAlkTo){
            if(p.getX() == destination.getX() && p.getY() == destination.getY()){
                return true;
            }
        }
        return false;
        //return destinationChess.isReversal|| destinationChess instanceof EmptySlotComponent;


    }


    @Override
    /**
     * 这是一个 绘制那个点的方格的方法
     */
    protected void paintComponent(Graphics g) {
        super.paintComponents(g);
        System.out.printf("repaint chess [%d,%d]\n", chessboardPoint.getX(), chessboardPoint.getY());
        g.setColor(squareColor);
        g.fillRect(1, 1, this.getWidth() - 2, this.getHeight() - 2);
    }

    public boolean caneat(SquareComponent dc){
        String name = dc.ABBREVIATION;
        int numdc = name.charAt(0);
        int num = this.ABBREVIATION.charAt(0);
        if(this instanceof CannonChessComponent){
            if((dc.isReversal && dc.chessColor != chessColor) || (!dc.isReversal && !(dc.chessColor != ChessColor.NONE))){
                return true;
            }else{
                return false;
            }
        }else if(this instanceof SoldierChessComponent){
            if(dc instanceof GeneralChessComponent){
                return true;
            }else{
                return false;
            }
        }else{
            if(num >= numdc ){
                return true;
            }else{
                return false;
            }
        }
    }

    public String getABBREVIATION() {
        return ABBREVIATION;
    }


    /**
     * 原本这个方法是返回jcomponent在界面的坐标，被我改成getchesspoint的坐标了
     * @return
     */
    @Override
    public int getX() {
        return this.chessboardPoint.getX();
    }

    @Override
    public int getY() {
        return this.chessboardPoint.getY();
    }
}
