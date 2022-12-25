package model;

import java.awt.*;

/**
 * 这个类主要用于包装Color对象，用于Chess游戏使用。
 * 一个棋子颜色的枚举类
 * 对象：黑的 红的 白的
 * 属性： 名字，颜色
 * 方法：获取名字，获取颜色
 * 这个white和no player 是干啥用的
 */
public enum ChessColor {
    BLACK("Black", Color.BLACK), RED("RED", Color.RED), NONE("No Player", Color.WHITE);

    private final String name;
    private final Color color;

    ChessColor(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }
}
