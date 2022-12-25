package chessComponent;

import controller.ClickController;
import model.ChessColor;
import model.ChessboardPoint;
import view.Chessboard;

import java.awt.*;
import java.util.Map;

public class MinisterChessComponent extends ChessComponent{
    protected MinisterChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, String s) {
        super(chessboardPoint, location, chessColor, s);
        if (this.getChessColor() == ChessColor.RED) {
            name = "相";
        } else {
            name = "象";
        }
    }


    private static MinisterChessComponent Ministerr1 = new MinisterChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED, "ER1");
    private static MinisterChessComponent Ministerr2 = new MinisterChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED, "ER2");
    private static MinisterChessComponent Ministerb1 = new MinisterChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK, "EB1");
    private static MinisterChessComponent Ministerb2 = new MinisterChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK, "EB2");

    public static MinisterChessComponent getMinisterr1() {
        return Ministerr1;
    }

    public static MinisterChessComponent getMinisterr2() {
        return Ministerr2;
    }

    public static MinisterChessComponent getMinisterb1() {
        return Ministerb1;
    }

    public static MinisterChessComponent getMinisterb2() {
        return Ministerb2;
    }
}
