package chessComponent;

import controller.ClickController;
import model.ChessColor;
import model.ChessboardPoint;
import view.Chessboard;

import java.awt.*;

/**
 * 表示黑红车
 * 构造器：调用了chesscomponent的构造器，根据颜色设置文字
 */
public class ChariotChessComponent extends ChessComponent {

    public ChariotChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, String a) {
        super(chessboardPoint, location, chessColor, a);
        if (this.getChessColor() == ChessColor.RED) {
            name = "俥";
        } else {
            name = "車";
        }
    }

    private static ChariotChessComponent Chariotr1 = new ChariotChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED, "DR1");
    private static ChariotChessComponent Chariotr2 = new ChariotChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED, "DR2");
    private static ChariotChessComponent Chariotb1 = new ChariotChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK, "DB1");
    private static ChariotChessComponent Chariotb2 = new ChariotChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK, "DB2");

    public static ChariotChessComponent getChariotr1() {
        return Chariotr1;
    }

    public static ChariotChessComponent getChariotr2() {
        return Chariotr2;
    }

    public static ChariotChessComponent getChariotb1() {
        return Chariotb1;
    }

    public static ChariotChessComponent getChariotb2() {
        return Chariotb2;
    }
}
