package chessComponent.chessLibrary;
import chessComponent.ChessComponent;
import controller.ClickController;
import model.ChessColor;
import model.ChessboardPoint;

import java.awt.*;

/**
 * 表示黑红马
 */
public class AdviserChessComponent extends ChessComponent {

    public AdviserChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, ClickController clickController, int size) {
        super(chessboardPoint, location, chessColor, clickController, size);
        if (this.getChessColor() == ChessColor.RED) {
            name = "仕";
        } else {
            name = "士";
        }
        super.type = 6;
        super.points = 10;
    }

}
