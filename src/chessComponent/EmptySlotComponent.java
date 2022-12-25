package chessComponent;

import controller.ClickController;
import model.ChessColor;
import model.ChessboardPoint;

import java.awt.*;

/**
 * 这个类表示棋盘上的空棋子的格子
 * 构造器：棋子的颜色是没有
 * 方法：重写了canmoveto方法，也就是空棋子哪里都不能moveto
 */
public class EmptySlotComponent extends SquareComponent {
    public final String ABBREVIATION = "000";
    {
        isReversal = false;

    }

    public EmptySlotComponent(ChessboardPoint chessboardPoint, Point location, String s) {
        super(chessboardPoint, location, ChessColor.NONE, "000");
    }

    @Override
    public boolean canMoveTo(SquareComponent[][] chessboard, ChessboardPoint destination) {
        return false;
    }

}
