package controller;

import chessComponent.*;
import com.sun.java.accessibility.util.AccessibilityListenerList;
import controller.*;
import model.*;
import view.*;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.List;


public class Saver {

    public static File f = new File("D:\\java代码\\IdeaProjects\\Class\\Project\\f1");
    //这个需要修改，如果选择的是哪个存档/新开的游戏，这个file就指向哪个
    static int count = 0;
    String currentColor = null;
    //player chessboard procedure
    static ArrayList<String> pcp = new ArrayList<>();

    //利用io流写一个，把棋盘棋子的排列数据写入txt文档的方法
    public void newDataRecorder(){
        //首先在这个路径创建一个文件
        //然后录入每个棋子的缩写
        File f1 = new File("D:\\java代码\\IdeaProjects\\Class\\Project\\f1");
        File f2 = new File("D:\\java代码\\IdeaProjects\\Class\\Project\\f2");
        File f3 = new File("D:\\java代码\\IdeaProjects\\Class\\Project\\f3");
        File ff = new File("D:\\java代码\\IdeaProjects\\Class\\Project\\ff");
    }
    //一个翻棋的record方法
    public static void record(int x, int y, SquareComponent s) {
        pcp.add(String.format("\n%d %s %d %d %d %d 1", count, s.getABBREVIATION(), x, y, x, y));
    }

    //一个吃子的record方法
    public static void record(int x1, int y1, int x2, int y2, SquareComponent s1, SquareComponent s2){
        pcp.add(String.format("\n%d %s %d %d %d %d 2", count, s1.getABBREVIATION(), x1, y1, x2, y2));
        pcp.add(String.format("\n%d %s %d %d 8 8 3", count, s2.getABBREVIATION(), x2, y2));
    }

    //一个记录只行走，没有吃子的方法
    public static void record(int x1, int y1, int x2, int y2, SquareComponent s1){
        pcp.add(String.format("\n%d %s %d %d %d %d 2", count, s1.getABBREVIATION(), x1, y1, x2, y2));
    }

    //利用io流写一个从文件中读取棋盘棋子的排列数据 并 刷新棋盘 的方法
    public static SquareComponent[][] useDataRecords(List<String> history){
        //对于前四行用利用空格读出每个字符串，加到二维字符串数组里面，对应成棋子塞到squarecomponents里面
        ArrayList<ArrayList<String>> allChesses = new ArrayList<>();
        for(int i = 1; i <= 4; i++){
            ArrayList<String> rowChesses = new ArrayList<>();
            rowChesses.add(history.get(i).substring(0, 3));
            rowChesses.add(history.get(i).substring(4, 7));
            rowChesses.add(history.get(i).substring(8, 11));
            rowChesses.add(history.get(i).substring(12, 15));
            rowChesses.add(history.get(i).substring(16, 19));
            rowChesses.add(history.get(i).substring(20, 23));
            rowChesses.add(history.get(i).substring(24, 27));
            rowChesses.add(history.get(i).substring(28, 31));
            allChesses.add(rowChesses);
        }
        //在这里成功把每个棋子的缩写都提取出来了，变成了一个allchesses数组
        SquareComponent[][] chesses = new SquareComponent[4][8];
        for(int i = 0; i < allChesses.size(); i++){
            for(int j = 0; j < allChesses.get(0).size(); j ++){
                //如果是空棋子，就在这个位置添加一个空棋子
                if(allChesses.get(i).get(j).equals("000")){
                    chesses[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j),new Point(), "000");
                    //这个point我不知应该怎么写，然后那个size，应该是和chessboard还是chessgameFrame里面设置的siez是一样的，到时候统一改吧
                }else{
                    //如果不是空棋子，就通过缩写检索这个棋子的实例
                    SquareComponent s = Chessboard.abr_che.get(allChesses.get(i).get(j));
                    s.getChessboardPoint().setX(i);
                    s.getChessboardPoint().setX(j);
                    chesses[i][j] = Chessboard.abr_che.get(allChesses.get(i).get(j));
                }
                //好我们在这里又做了一个棋盘的内部结构，和Chessboard里的squarecomponents是一样的
                //返回这个chesses让squarecomponent接收就可以让棋盘的棋子刷新了
            }
        }
        return chesses;
    }

    //利用io流读取一个行棋步骤的方法
    public ArrayList<Procedure> history(List<String> history){
        int i = history.size();
        ArrayList<Procedure> procedures = new ArrayList<>();
        if(i >= 5){
            for(int j = 5; j < history.size(); j ++){
                int step = history.get(j).charAt(0);
                int c = step/10;
                String abbreviation = history.get(j).substring(2+c,5+c);
                int x1 = history.get(j).charAt(6+c);
                int y1 = history.get(j).charAt(8+c);
                int x2 = history.get(j).charAt(10+c);
                int y2 = history.get(j).charAt(12+c);
                int type = history.get(j).charAt(14+c);
                //发现这里可以用 String[] s = history.get(j).split(" ")来写，但是都写完了，那就算了
                procedures.add(new Procedure(step, abbreviation, x1, y1, x2, y2, type));
            }//在这里把每一次的的步骤都记录下来了（这只是一次）
        }
        return procedures;
    }

    //判断棋盘是否是4*8，错误编码 102
    public static String[][] testChessboardStructure(List<String> history){
        if(history.size() < 5){
            //跳出弹窗：棋盘格式错误 错误代码 102
            return null;
        }
        String[][] chesses = new String[4][];
        for(int j = 1; j <= 4; j++){
            chesses[j-1] = history.get(j).split(" ");
        }//这里是用chesses 把棋盘上每个子的缩写都保存下来了
        for(int j = 0; j < chesses.length; j ++){
            if(chesses[j].length != 8){
                //跳出弹窗：棋盘格式错误 错误代码 102
                return null;
            }
        }
        return chesses;
    }
    //棋子错误：棋子并非红黑7种棋子或空棋子之一，或者某个棋子数量不对， 错误编码103
    public static boolean checkSquarecomponent(String[][] chesses){
        ArrayList<String> s = new ArrayList<>();
        for(int i = 0; i < chesses.length ; i ++){
            for(int j = 0 ; j < chesses[i].length; j ++){
                if(!chesses[i][j].equals("000") && !Chessboard.abr_che.containsKey(chesses[i][j])){
                    //如果一个棋子不是空棋子，也不是红黑棋子，就报错
                    //做个弹框，没有名为chesses[i][j]的棋子
                    //错误编码 103
                    return true;
                }
            }
        }
        //判断是否有元素重复（000可以重复）直接暴力枚举
        for(int i = 0; i < chesses.length ; i ++){
            for(int j = 0 ; j < chesses[i].length; j ++){
                if(!chesses[i][j].equals("000")){
                    s.add(chesses[i][j]);
                    //把除了空棋子的棋子都做一个数组，正常情况下，每个都最多只有一个
                }
            }
        }
        for(int i = 0; i < s.size(); i++){
            for(int j = i+1; j < s.size(); j++){
                if(s.get(i).equals(s.get(j))){
                    return true;
                    //做个弹框，发现重复棋子
                    //错误编码 103
                }
            }
        }
        return false;
    }

    //缺少行棋方：导入数据只有棋盘，没有下一步行棋的方的提示 错误编码104
    public static boolean testCurrentColor(List<String> history){
        String cc = history.get(0);
        if(!cc.equals("BLACK") && !cc.equals("RED")){
            //跳出弹窗，缺少行棋方 错误编码 104
            return false;
        }
        return true;
    }

    //行棋步骤错误:●描述：需要附上从初始棋盘-当前棋盘的行棋步骤，如果过程中有一处有误，则需要报出错误
    //错误编码 105
    public static void testProcdure(List<String> history){
        //ArrayList<Procedure> procedures = history(history);
        //获取了全部的行棋步骤
        /**
         * 如何检查行棋步骤呢
         * 我可能会，做很多个悔棋，一直悔到第一步，然后用检查棋盘的前两个方法来检查最初的棋盘是否有问题
         * 同时还要检查
         * 如果这是一个翻开棋子的操作：检查原来这个棋子是不是 非reserve的
         * 如果这是一个行走的操作，首先在这个棋子的moveto方法
         */

    }





}
