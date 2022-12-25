package controller;


import chessComponent.CannonChessComponent;
import chessComponent.SquareComponent;
import chessComponent.EmptySlotComponent;
import model.ChessColor;
import ui.ChessGameFrame;
import view.Chessboard;

import javax.swing.*;

/**
 * 这是一个clickcomponent类，用来
 * 构造器： 设置棋盘
 * 属性：棋盘（final） first的方块
 * 方法：onclick：点击一个方格，控制方格的行为
 * handlefirst：判断点击的方格的棋子是正面还是背面，如果是正面，判断与行棋方是否相同
 * handlesecond:判断first棋子能否移动到second棋子上
 * swapplayer:改变行棋方颜色
 */

public class ClickController {
    private final Chessboard chessboard = Chessboard.getInstance();
    private SquareComponent first;




    /**
     * 这是一个点击棋子，行棋时棋子的行为、
     * 包括选中棋子时的效果，取消选中，落子的对象和位置以及要进行的操作
     * 如果选取的是反面棋子，会调用handleFirst把棋子翻过来，结束回合
     * 如果选取的是正面棋子，会判断是否选取的是行棋方的棋子
     * @param squareComponent/
     */


    public void onClick(SquareComponent squareComponent) {
        //判断第一次点击
        if (first == null) {   //第一次点击时执行以下
            int i = handleFirst(squareComponent);
            if (i == 1) { //选取的棋子与行棋方同
                squareComponent.setSelected(true);  //成功被选中
                first = squareComponent;
                first.repaint();    //更改选中时棋子的样式
            }else if(i == 0){
                JOptionPane.showMessageDialog(null, "请选择己方棋子，或翻面一块未翻面的棋子");
                //下一次点击仍然是第一次点击 因为first = null
            }else{
                // i = -1 不需要进行任何操作，直接就换玩家了
            }
        } else {  //第二次点击（已经选中了棋子）
            if (first == squareComponent) { // 再次点击取消选取
                squareComponent.setSelected(false);
                SquareComponent recordFirst = first;
                first = null;
                recordFirst.repaint();
            } else if (handleSecond(squareComponent)) {//如果
                //选中的棋子与行棋方向相同，这时候不应该有操作，应该提示 操作违法
                //repaint in swap chess method.
                //这里我不是特别明白，为什么还把两个自己的棋给交换了，是不是得改啊
                chessboard.swapChessComponents(first, squareComponent);
                //交换选手
                chessboard.clickController.swapPlayer();

                first.setSelected(false);
                first = null;
            }
        }
    }


    /**
     * @param squareComponent 目标选取的棋子
     * @return 目标选取的棋子是否与棋盘记录的当前行棋方颜色相同
     * 如果棋子是背面，就让棋子翻过来，输出翻转的棋子的坐标，显示贴图，交换玩家，返回不是同一个色
     * 否则棋子已经翻过来，同一个色返回true， 不同返回false
     */

    private int handleFirst(SquareComponent squareComponent) {
        if (!squareComponent.isReversal()) {
            squareComponent.setReversal(true);
            System.out.printf("onClick to reverse a chess [%d,%d]\n", squareComponent.getChessboardPoint().getX(), squareComponent.getChessboardPoint().getY());
            squareComponent.repaint();
            //这个是如果是翻开一面新棋子就调用这个方法
            Saver.record(squareComponent.getChessboardPoint().getX(), squareComponent.getChessboardPoint().getY(), squareComponent);
            chessboard.clickController.swapPlayer();
            return -1; //如果是新翻过来一块棋子，返回-1，然后在原来的方法直接return；
        }else if(squareComponent.getChessColor() == chessboard.getCurrentColor()){
            return 1;  //第一次点击的棋子与行棋方向相同，返回1，可以进行接下来的行动
        }else{
            return 0;  //选择了对方的棋子或空棋子，返回0，提示请选择己方棋子或翻开一块空棋子
        }


    }

    /**
     * @param squareComponent first棋子目标移动到的棋子second（没有翻开或翻开了（为己方或对方））
     * @return first棋子是否能够移动到second棋子位置
     * 如果是没翻开的棋子，并且这个方格不是空棋子，就返回false, 不能移动
     * 否则 如果这个棋子的颜色不等于行棋方的颜色 并且 行棋方的棋子能够走到这个位置 返回true
     * 不然返回false
     */
    private boolean handleSecond(SquareComponent squareComponent) {

        //没翻开或空棋子，进入if
        if (!squareComponent.isReversal()) {
            if (!(squareComponent instanceof EmptySlotComponent)) {  //不是空棋子，也就是黑或红棋子，只有炮有可能走
                if(first instanceof CannonChessComponent){
                    return first.canMoveTo(chessboard.getChessComponents(), squareComponent.getChessboardPoint());
                    //这里需要在炮类重写炮的canmoveto方法
                }else {
                    return false;
                }
            }
        }
        //第二个棋子是空棋子，或第二个棋子是翻面的黑或红棋子
        return squareComponent.getChessColor() != chessboard.getCurrentColor() &&
                first.canMoveTo(chessboard.getChessComponents(), squareComponent.getChessboardPoint());
        // 如果棋子颜色不是现行方颜色，并且 第一个棋子能走到那里 就返回 true
    }

    /**
     * 这是一个交换玩家回合的方法
     * 就是红棋方变黑棋方
     */
    public void swapPlayer() {
        chessboard.setCurrentColor(chessboard.getCurrentColor() == ChessColor.BLACK ? ChessColor.RED : ChessColor.BLACK);
        ChessGameFrame.getStatusLabel().setText(String.format("%s's TURN", chessboard.getCurrentColor().getName()));
    }
}
