package chessComponent;

import controller.ClickController;
import model.ChessColor;
import model.ChessboardPoint;
import view.Chessboard;
import java.lang.Math;

import java.awt.*;
import java.util.ArrayList;

public class CannonChessComponent extends ChessComponent{
    protected CannonChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, String s ) {
        super(chessboardPoint, location, chessColor, s);
        if (this.getChessColor() == ChessColor.RED) {
            name = "炮";
        } else {
            name = "砲";
        }
    }

    @Override
    public boolean canMoveTo(SquareComponent[][] chessboard, ChessboardPoint destination) {
        //重写炮的移动规则
        /**
         * 目的地棋子要求
         * 翻面：不同色
         * 没翻面：不是空棋子
         * 横向：相差的坐标是dx， dx的绝对值要大于1才能执行下一步， 如果dx>0,判断x+1有没有棋子， 如果《0，判断x-1有没有棋子（颜色不为null）
         */
        SquareComponent dc = chessboard[destination.getX()][destination.getY()];
        int dx = destination.getX() - this.getChessboardPoint().getX();
        int dy = destination.getY() - this.getChessboardPoint().getY();
        if(this.caneat(dc)){
            if((dx == 0)^(dy == 0)){
                //x相同或者y相同，但xy不能同时相同
                if(Math.abs(dy) > 1){
                    if(dy > 0){
                        if(chessboard[this.getChessboardPoint().getX()][this.getChessboardPoint().getY()+1].chessColor  != ChessColor.NONE){
                            return true;
                        }
                    }else{
                        if(chessboard[this.getChessboardPoint().getX()][this.getChessboardPoint().getY()-1].chessColor  != ChessColor.NONE){
                            return true;
                        }
                    }
                }
                if(Math.abs(dx) > 1){
                    if(dx > 0){
                        if(chessboard[this.getChessboardPoint().getX()+1][this.getChessboardPoint().getY()].chessColor  != ChessColor.NONE){
                            return true;
                        }
                    }else{
                        if(chessboard[this.getChessboardPoint().getX()-1][this.getChessboardPoint().getY()].chessColor  != ChessColor.NONE){
                            return true;
                        }
                    }
                }
            }
        }
        return false;

    }


    private static CannonChessComponent Cannonr1 = new CannonChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED, "BR1");
    private static CannonChessComponent Cannonr2 = new CannonChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED, "BR2");
    private static CannonChessComponent Cannonb1 = new CannonChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK, "BB1");
    private static CannonChessComponent Cannonb2 = new CannonChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK, "BB2");

    public static CannonChessComponent getCannonr1() {
        return Cannonr1;
    }

    public static CannonChessComponent getCannonr2() {
        return Cannonr2;
    }

    public static CannonChessComponent getCannonb1() {
        return Cannonb1;
    }

    public static CannonChessComponent getCannonb2() {
        return Cannonb2;
    }


}
