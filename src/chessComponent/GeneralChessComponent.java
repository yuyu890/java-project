package chessComponent;

import controller.ClickController;
import model.ChessColor;
import model.ChessboardPoint;
import view.Chessboard;

import java.awt.*;

public class GeneralChessComponent extends ChessComponent{
    protected GeneralChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, String s) {
        super(chessboardPoint, location, chessColor, s);
        if (this.getChessColor() == ChessColor.RED) {
            name = "帅";
        } else {
            name = "将";
        }
    }

    private static GeneralChessComponent generalr = new GeneralChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED, "GR1");
    private static GeneralChessComponent generalb = new GeneralChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK, "GB1");

    public static GeneralChessComponent getGeneralr() {
        return generalr;
    }

    public static GeneralChessComponent getGeneralb() {
        return generalb;
    }
}
