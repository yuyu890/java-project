package chessComponent;

import controller.ClickController;
import model.ChessColor;
import model.ChessboardPoint;

import java.awt.*;

/**
 * 表示棋盘上非空棋子的格子，是所有非空棋子的父类，继承了方格squarecomponent类
 * 构造器：设置棋子的坐标，位置，颜色，clickcontroller，size（就是squarecomponent的构造器
 * 属性：棋子的名字
 * 方法：父类的方法 重写：给方块涂色，变成了画个空棋子，可以改成贴图
 */
public class ChessComponent extends SquareComponent{
    protected String name;// 棋子名字：例如 兵，卒，士等

    protected ChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, String abbreviation) {
        super(chessboardPoint, location, chessColor, abbreviation);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //绘制棋子填充色
        g.setColor(Color.ORANGE);
        g.fillOval(spacingLength, spacingLength, this.getWidth() - 2 * spacingLength, this.getHeight() - 2 * spacingLength);
        //绘制棋子边框
        g.setColor(Color.DARK_GRAY);
        g.drawOval(spacingLength, spacingLength, getWidth() - 2 * spacingLength, getHeight() - 2 * spacingLength);

        if (isReversal) {
            //绘制棋子文字
            g.setColor(this.getChessColor().getColor());
            g.setFont(CHESS_FONT);
            g.drawString(this.name, this.getWidth() / 4, this.getHeight() * 2 / 3);

            //绘制棋子被选中时状态
            if (isSelected()) {
                g.setColor(Color.RED);
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(4f));
                g2.drawOval(spacingLength, spacingLength, getWidth() - 2 * spacingLength, getHeight() - 2 * spacingLength);
            }
        }
    }
}
