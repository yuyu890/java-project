package chessComponent;

import model.ChessColor;
import model.ChessboardPoint;


import java.awt.*;

public class AdvisorChessComponent extends ChessComponent{
    protected AdvisorChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, String s) {
        super(chessboardPoint, location, chessColor, s);
        if (this.getChessColor() == ChessColor.RED) {
            name = "仕";
        } else {
            name = "士";
        }
    }

    private static AdvisorChessComponent Advisorr1 = new AdvisorChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED, "FR1");
    private static AdvisorChessComponent Advisorr2 = new AdvisorChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED, "FR2");
    private static AdvisorChessComponent Advisorb1 = new AdvisorChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK, "FB1");
    private static AdvisorChessComponent Advisorb2 = new AdvisorChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK, "FB2");

    public static AdvisorChessComponent getAdvisorr1() {
        return Advisorr1;
    }

    public static AdvisorChessComponent getAdvisorr2() {
        return Advisorr2;
    }

    public static AdvisorChessComponent getAdvisorb1() {
        return Advisorb1;
    }

    public static AdvisorChessComponent getAdvisorb2() {
        return Advisorb2;
    }
}
