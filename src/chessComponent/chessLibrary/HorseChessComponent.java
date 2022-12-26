
package chessComponent.chessLibrary;

import chessComponent.ChessComponent;
import controller.ClickController;
import model.ChessColor;
import model.ChessboardPoint;

import java.awt.*;

/**
 * 表示黑红马
 */
public class HorseChessComponent extends ChessComponent {


    public HorseChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, ClickController clickController, int size) {
        super(chessboardPoint, location, chessColor, clickController, size);
        if (this.getChessColor() == ChessColor.RED) {
            name = "马";
        } else {
            name = "傌";
        }
        super.type =3;
        super.points = 5;
    }

}