package chessComponent;

import controller.ClickController;
import model.ChessColor;
import model.ChessboardPoint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * 这个类是一个抽象类，主要表示8*4棋盘上每个格子的棋子情况。
 * 有两个子类：
 * 1. EmptySlotComponent: 空棋子
 * 2. ChessComponent: 表示非空棋子
 */
public abstract class SquareComponent extends JComponent {

    public int points;

    public int type;
    private static final Color squareColor = new Color(250, 220, 190);
    protected static int spacingLength;
    protected static final Font CHESS_FONT = new Font("宋体", Font.BOLD, 36);



    /**
     * chessboardPoint: 表示8*4棋盘中，当前棋子在棋格对应的位置，如(0, 0), (1, 0)等等
     * chessColor: 表示这个棋子的颜色，有红色，黑色，无色三种
     * isReversal: 表示是否翻转
     * selected: 表示这个棋子是否被选中
     */
    public ChessboardPoint chessboardPoint;

    public final ChessColor chessColor;
    public boolean isReversal;
    public boolean selected;

    /**
     * handle click event
     */
    private final ClickController clickController;

    protected SquareComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, ClickController clickController, int size) {
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
        setLocation(location);
        setSize(size, size);
        this.chessboardPoint = chessboardPoint;
        this.chessColor = chessColor;
        this.selected = false;
        this.clickController = clickController;
        this.isReversal = false;
    }

    public boolean isReversal() {
        return isReversal;
    }

    public void setReversal(boolean reversal) {
        isReversal = reversal;
    }

    public static void setSpacingLength(int spacingLength) {
        SquareComponent.spacingLength = spacingLength;
    }

    public ChessboardPoint getChessboardPoint() {
        return chessboardPoint;
    }

    public void setChessboardPoint(ChessboardPoint chessboardPoint) {
        this.chessboardPoint = chessboardPoint;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * @param another 主要用于和另外一个棋子交换位置
     *                <br>
     *                调用时机是在移动棋子的时候，将操控的棋子和对应的空位置棋子(EmptySlotComponent)做交换
     */
    public void swapLocation(SquareComponent another) {
        ChessboardPoint chessboardPoint1 = getChessboardPoint(), chessboardPoint2 = another.getChessboardPoint();
        Point point1 = getLocation(), point2 = another.getLocation();
        setChessboardPoint(chessboardPoint2);
        setLocation(point2);
        another.setChessboardPoint(chessboardPoint1);
        another.setLocation(point1);
    }

    /**
     * @param e 响应鼠标监听事件
     *          <br>
     *          当接收到鼠标动作的时候，这个方法就会自动被调用，调用监听者的onClick方法，处理棋子的选中，移动等等行为。
     */
    @Override
    protected void processMouseEvent(MouseEvent e) {
        super.processMouseEvent(e);
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
//        return destinationChess.isReversal|| destinationChess instanceof EmptySlotComponent;
//        //todo: complete this method
        if(!this.caneat(dc)){
            return false;
        }
        //剩下的都是dc是能吃的，再判断能不能走到
        ArrayList<ChessboardPoint> canWAlkTo = canWalkTo(chessboard);

        for(ChessboardPoint p : canWAlkTo){
            if(destination.getX() == p.getX() && destination.getY() == p.getY()){
                return true;
            }
        }
        return false;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponents(g);
        System.out.printf("repaint chess [%d,%d]\n", chessboardPoint.getX(), chessboardPoint.getY());
        g.setColor(squareColor);
        g.fillRect(1, 1, this.getWidth() - 2, this.getHeight() - 2);
    }

    /**
     * 判断this棋子能不能 dc棋子
     * dc可以是空棋子，那么除了炮都可以吃
     * 如果不是炮，那么按照等级顺序（等级相同或较低），除了兵都可以吃炮
     * 但是兵只可以吃将
     */

    public boolean caneat(SquareComponent dc){
        //除了炮和兵都可以用这个caneat
        int b = dc.type;
        return (0 <= b && b <= this.type) && this.chessColor!= dc.chessColor;
        //颜色不同，在可以吃的范围内
    }

    public ArrayList<ChessboardPoint> canWalkTo(SquareComponent[][] chessboard){
        ArrayList<ChessboardPoint> canWAlkTo = new ArrayList<>();
        canWAlkTo.add(new ChessboardPoint(this.chessboardPoint.getX(), this.chessboardPoint.getY()+1));
        canWAlkTo.add(new ChessboardPoint(this.chessboardPoint.getX(), this.chessboardPoint.getY()-1));
        canWAlkTo.add(new ChessboardPoint(this.chessboardPoint.getX()+1, this.chessboardPoint.getY()));
        canWAlkTo.add(new ChessboardPoint(this.chessboardPoint.getX()-1, this.chessboardPoint.getY()));

        //直接用foreach循环，并且使用add或remove方法，会报ConcurrentModificationException()的异常
        for(int i = 0; i < canWAlkTo.size(); i++){
            if (canWAlkTo.get(i).getY()< 0 || canWAlkTo.get(i).getY()>7 || canWAlkTo.get(i).getX()<0 || canWAlkTo.get(i).getX()>3){
                canWAlkTo.remove(i);
                i--;
            }
        }
        for(int i = 0; i < canWAlkTo.size(); i++){
            if(!this.caneat(chessboard[canWAlkTo.get(i).getX()][canWAlkTo.get(i).getY()])){
                //如果canwalk的终点不是能吃的棋子，canwalkto就不把这个格子加入能走的格子
                canWAlkTo.remove(i);
                i--;
            }
        }
        //现在我们能够获得一个能走的格子的数组
        for(ChessboardPoint p: canWAlkTo){
            System.out.println("can walk to" + String.format("(%d, %d)",p.getX(), p.getY()));
        }
        return canWAlkTo;
    }
}
