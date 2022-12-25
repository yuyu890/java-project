package model;

/**
 * 这个类表示棋盘上的位置，如(0, 0), (0, 3)等等
 * 其中，左上角是(0, 0)，左下角是(7, 0)，右上角是(0, 3)，右下角是(7, 3)
 * 构造器：设置xy坐标
 * 属性：x（行）y（列）坐标
 * 方法：tostring输出棋盘上的哪个坐标被点击了
 */
public class ChessboardPoint {
    private int x, y;

    /**
     *
     * @param x: row
     * @param y: col
     */
    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "("+x + ","+y+") " + "on the chessboard is clicked!";
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
