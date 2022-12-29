package controller;

import chessComponent.SquareComponent;
import model.ChessColor;

import java.util.ArrayList;

public class Procedure {
    public ChessColor currentColor;
    public SquareComponent[][] chesses = new SquareComponent[4][8];
    public int redPoints;
    public int blackPoints;

    public Procedure(ChessColor currentColor, SquareComponent[][] chesses, int redPoints, int blackPoints) {
        this.currentColor = currentColor;
        this.chesses = chesses;
        this.redPoints = redPoints;
        this.blackPoints = blackPoints;
    }

}
