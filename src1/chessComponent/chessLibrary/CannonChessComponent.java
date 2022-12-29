package chessComponent.chessLibrary;
import chessComponent.ChessComponent;
import chessComponent.EmptySlotComponent;
import chessComponent.SquareComponent;
import controller.ClickController;
import model.ChessColor;
import model.ChessboardPoint;

import java.awt.*;
import java.util.ArrayList;

/**
 * 表示黑红炮
 */
public class CannonChessComponent extends ChessComponent {


    public CannonChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, ClickController clickController, int size) {
        super(chessboardPoint, location, chessColor, clickController, size);
        if (this.getChessColor() == ChessColor.RED) {
            name = "炮";
        } else {
            name = "砲";
        }
        super.type =2;
        super.points = 5;
    }

    @Override
    public boolean canMoveTo(SquareComponent[][] chessboard, ChessboardPoint destination) {
        ArrayList<ChessboardPoint> canWalkTo = canWalkTo(chessboard);
         for(ChessboardPoint p : canWalkTo){
             if(destination.getX() == p.getX() && destination.getY() == p.getY()){
                 return true;
             }
         }
         return false;
    }

    @Override
    public boolean caneat(SquareComponent dc) {
        return(dc.isReversal && dc.chessColor != chessColor) || (!dc.isReversal && (dc.chessColor != ChessColor.NONE));
            //如果dc是打开的，只要颜色不相同即可
            //或者 如果dc是没有翻面的（空棋子默认没有翻面）并且这个棋子不是空棋子，那也可以吃

    }

    public boolean canMove2(SquareComponent[][] chessboard, ChessboardPoint destination) {
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
        if((dc.isReversal && dc.chessColor != chessColor) || (!dc.isReversal && (dc.chessColor != ChessColor.NONE))){ //可以吃的棋子，然后判断
            if((dx == 0)^(dy == 0)){
                //x相同或者y相同，但xy不能同时相同
                if(Math.abs(dy) > 1){
                    if(dy > 0){
                        if(!(chessboard[this.getChessboardPoint().getX()][this.getChessboardPoint().getY()+1] instanceof EmptySlotComponent)){
                            for(int i = this.getChessboardPoint().getY()+2; i < destination.getY(); i++){
                                if(!(chessboard[destination.getX()][i] instanceof EmptySlotComponent)){
                                    return false;
                                }
                            }
                            //从跳板到终点，如果路上没有非空棋子，就可以跳
                            //如果炮路上第一个格子上有棋子（不是空棋子）就是能跳的，并且这个棋子到dc的路上只有这一个非空棋子
                            return true;
                        }
                    }else{
                        if(!(chessboard[this.getChessboardPoint().getX()][this.getChessboardPoint().getY()-1] instanceof EmptySlotComponent)){
                            for(int i = this.getChessboardPoint().getY()-2; i > destination.getY(); i--){
                                if(!(chessboard[destination.getX()][i] instanceof EmptySlotComponent)){
                                    return false;
                                }
                            }
                            return true;
                        }
                    }
                }
                if(Math.abs(dx) > 1){
                    if(dx > 0){
                        if(!(chessboard[this.getChessboardPoint().getX()+1][this.getChessboardPoint().getY()] instanceof EmptySlotComponent)){
                            for(int i = this.getChessboardPoint().getX()+2; i < destination.getX(); i++){
                                if(!(chessboard[i][destination.getY()] instanceof EmptySlotComponent)){
                                    return false;
                                }
                            }
                            return true;
                        }
                    }else{
                        if(!(chessboard[this.getChessboardPoint().getX()-1][this.getChessboardPoint().getY()] instanceof EmptySlotComponent)){
                            for(int i = this.getChessboardPoint().getY()-2; i > destination.getY(); i--){
                                if(!(chessboard[i][destination.getY()] instanceof EmptySlotComponent)){
                                    return false;
                                }
                            }
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public ArrayList<ChessboardPoint> canWalkTo(SquareComponent[][] chessboard) {
        ArrayList<ChessboardPoint> canWalkTo = new ArrayList<>();
        for(int i = 0; i < chessboard.length; i++){
            for(int j = 0; j < chessboard[i].length; j ++){
                SquareComponent dc = chessboard[i][j];
                if(canMove2(chessboard,dc.chessboardPoint)){
                    //这里是偷懒了把每个子都遍历一遍了，注意可能有空棋子，有背面棋子，有己方棋子，有对方棋子，有中间挡路的棋子
                    canWalkTo.add(chessboard[i][j].chessboardPoint);
                }
            }
        }
        for(ChessboardPoint p: canWalkTo){
            System.out.println("can walk to" + String.format("(%d, %d)",p.getX(), p.getY()));
        }
        return canWalkTo;
    }
}

