package chessComponent.chessLibrary;

import chessComponent.ChessComponent;
import chessComponent.SquareComponent;
import controller.ClickController;
import model.ChessColor;
import model.ChessboardPoint;

import java.awt.*;

public class SoldierChessComponent extends ChessComponent {

    public SoldierChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, ClickController clickController, int size) {
        super(chessboardPoint, location, chessColor, clickController, size);
        if (this.getChessColor() == ChessColor.RED) {
            name = "兵";
        } else {
            name = "卒";
        }
        super.type = 1;
        super.points = 1;
    }

    @Override
    public boolean caneat(SquareComponent dc) {
        return( dc.type == 7 || dc.type == 1 || dc.type == 0)&& this.chessColor!= dc.chessColor;
    }
}
