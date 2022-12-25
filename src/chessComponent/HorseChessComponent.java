package chessComponent;

import controller.ClickController;
import model.ChessColor;
import model.ChessboardPoint;
import view.Chessboard;

import java.awt.*;

public class HorseChessComponent extends ChessComponent{
    protected HorseChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor,  String s) {
        super(chessboardPoint, location, chessColor, s);
        if (this.getChessColor() == ChessColor.RED) {
            name = "傌";
        } else {
            name = "马";
        }
    }

    private static HorseChessComponent Horser1 = new HorseChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED, "CR1");
    private static HorseChessComponent Horser2 = new HorseChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED, "CR2");
    private static HorseChessComponent Horseb1 = new HorseChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK, "CB1");
    private static HorseChessComponent Horseb2 = new HorseChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK, "CB2");

    public static HorseChessComponent getHorser1() {
        return Horser1;
    }

    public static HorseChessComponent getHorser2() {
        return Horser2;
    }

    public static HorseChessComponent getHorseb1() {
        return Horseb1;
    }

    public static HorseChessComponent getHorseb2() {
        return Horseb2;
    }
}
