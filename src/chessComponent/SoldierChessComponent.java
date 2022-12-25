package chessComponent;

import com.sun.nio.sctp.SctpChannel;
import controller.ClickController;
import model.ChessColor;
import model.ChessboardPoint;
import view.Chessboard;

import java.awt.*;

public class SoldierChessComponent extends ChessComponent {

    public SoldierChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, String s) {
        super(chessboardPoint, location, chessColor, s);
        if (this.getChessColor() == ChessColor.RED) {
            name = "兵";
        } else {
            name = "卒";
        }
    }

    private static SoldierChessComponent Soldierr1 = new SoldierChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED, "AR1");
    private static SoldierChessComponent Soldierr2 = new SoldierChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED, "AR2");
    private static SoldierChessComponent Soldierr3 = new SoldierChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED, "AR3");
    private static SoldierChessComponent Soldierr4 = new SoldierChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED, "AR4");
    private static SoldierChessComponent Soldierr5 = new SoldierChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED, "AR5");
    private static SoldierChessComponent Soldierb1 = new SoldierChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK, "AB1");
    private static SoldierChessComponent Soldierb2 = new SoldierChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK, "AB2");
    private static SoldierChessComponent Soldierb3 = new SoldierChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK, "AB3");
    private static SoldierChessComponent Soldierb4 = new SoldierChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK, "AB4");
    private static SoldierChessComponent Soldierb5 = new SoldierChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK, "AB5");

    public static SoldierChessComponent getSoldierr1() {
        return Soldierr1;
    }

    public static SoldierChessComponent getSoldierr2() {
        return Soldierr2;
    }

    public static SoldierChessComponent getSoldierr3() {
        return Soldierr3;
    }

    public static SoldierChessComponent getSoldierr4() {
        return Soldierr4;
    }

    public static SoldierChessComponent getSoldierr5() {
        return Soldierr5;
    }

    public static SoldierChessComponent getSoldierb1() {
        return Soldierb1;
    }

    public static SoldierChessComponent getSoldierb2() {
        return Soldierb2;
    }

    public static SoldierChessComponent getSoldierb3() {
        return Soldierb3;
    }

    public static SoldierChessComponent getSoldierb4() {
        return Soldierb4;
    }

    public static SoldierChessComponent getSoldierb5() {
        return Soldierb5;
    }
}
