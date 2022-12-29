package controller;


import chessComponent.*;
import chessComponent.chessLibrary.*;
import model.ChessColor;
import model.ChessboardPoint;
import ui.Chessboard;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Saver {
    /**
     * 这是一个用来储存数据的方法
     * 包括保存一次行棋
     * 读取棋盘
     * 判断棋盘的正不正确
     */
    ArrayList<Procedure> procedures = new ArrayList<>();
    Chessboard chessboard;

    File tt = new File("C:\\Users\\Administrator\\IdeaProjects\\final project\\src\\save\\tt.txt");
    public ArrayList<ArrayList<String>> steps = new ArrayList<>();
    public Saver(Chessboard chessboard) {
        endgame();
        this.chessboard = chessboard;
    }


    public void saveProcedure(){
        /**
         * 这是一个存储游戏数据的方法
         * 需要在swapplayer里面调用
         */
        SquareComponent[][] chesses = chessboard.getChessComponents();
        Procedure p = new Procedure(chessboard.getCurrentColor(), chesses, chessboard.redPoints, chessboard.blackPoints);
        String[] records = {"", "", "", ""};
        for(int i=0; i < chesses.length; i++){
            for(int j = 0; j < chesses[i].length; j++){
                if(chesses[i][j].isReversal){
                    records[i] = records[i] + "1";
                }else{
                    records[i] = records[i] + "0";
                }
                if(chesses[i][j] instanceof EmptySlotComponent){
                    records[i] = records[i] + "h";
                }else{
                    if(chesses[i][j].chessColor == ChessColor.BLACK){
                        switch (chesses[i][j].type){
                            case 1 -> records[i] = records[i] + "a";
                            case 2 -> records[i] = records[i] + "b";
                            case 3 -> records[i] = records[i] + "c";
                            case 4 -> records[i] = records[i] + "d";
                            case 5 -> records[i] = records[i] + "e";
                            case 6 -> records[i] = records[i] + "f";
                            case 7 -> records[i] = records[i] + "g";
                        }
                    }else{
                        switch (chesses[i][j].type){
                            case 1 -> records[i] = records[i] + "A";
                            case 2 -> records[i] = records[i] + "B";
                            case 3 -> records[i] = records[i] + "C";
                            case 4 -> records[i] = records[i] + "D";
                            case 5 -> records[i] = records[i] + "E";
                            case 6 -> records[i] = records[i] + "F";
                            case 7 -> records[i] = records[i] + "G";
                        }
                    }
                }
                records[i] += " ";
            }
        }

        try {
            RandomAccessFile bw = new RandomAccessFile("C:\\Users\\Administrator\\IdeaProjects\\final project\\src\\save\\tt.txt", "rw");
            bw.seek(bw.length());
            bw.write(String.format("%s\n", chessboard.getCurrentColor()).getBytes(StandardCharsets.UTF_8));
            for(int i = 0; i < records.length; i++){
                bw.write(String.format( "%s\n",records[i]).getBytes(StandardCharsets.UTF_8));
            }
            bw.write(String.format( "%d\n",chessboard.redPoints).getBytes(StandardCharsets.UTF_8));
            bw.write(String.format("%d\n",chessboard.blackPoints).getBytes(StandardCharsets.UTF_8));
            bw.write("\n".getBytes(StandardCharsets.UTF_8));
            bw.close();
            //我们每个步骤的标志就是，在每个步骤之间会用\n分开
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readProcedure(List<String> chessData){
        /**
         * 这个方法是在chessboard的loadgame里面调用的
         */
        endgame();
        ArrayList<Integer> gaps = new ArrayList<>();
        int count = 0;
        for(String s : chessData){
            if(s.isBlank()){
                gaps.add(count);
            }
            count++;
        }
        //step的一维是每一步
        //二维是每一步的每一行
        int num = 0;
        for(int i = 0; i < chessData.size(); i++){
            if(gaps.contains(i)){
                num ++;
            }else{
                steps.get(num).add(chessData.get(i));
            }
        }
        //在这里进行了两个棋盘判断
        testCurrentcolor();
        if(!testChessboardStructure()){
            return;
        }
        ChessColor cc = ChessColor.NONE;
        SquareComponent[][] chess = new SquareComponent[4][8];
        int redPoints = 0;
        int blackPoints = 0;
        String[][] lines = new String[4][];
        for(int i = 0; i < steps.size(); i++){
            if(steps.get(i).get(1).equals(ChessColor.RED)){
                cc = ChessColor.RED;
            }else{
                cc = ChessColor.BLACK;
            }
            for(int j = 1; j < 5; j++){
                lines[j-1] = steps.get(i).get(j).split(" ");
            }
            redPoints = Integer.parseInt(steps.get(i).get(5));
            blackPoints = Integer.parseInt(steps.get(i).get(6));
        }
        //在这里使用判断方法，判断棋盘的合理性

        for(int i = 0; i < lines.length; i++){
            for(int j = 0; j < lines[i].length; j++){
                switch (lines[i][j].charAt(1)){
                    case 'h' -> chess[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j), chessboard.calculatePoint(i,j),chessboard.clickController, chessboard.CHESS_SIZE);
                    case 'a' -> chess[i][j] = new SoldierChessComponent(new ChessboardPoint(i,j), chessboard.calculatePoint(i,j),ChessColor.BLACK,chessboard.clickController, chessboard.CHESS_SIZE);
                    case 'b' -> chess[i][j] = new CannonChessComponent(new ChessboardPoint(i,j), chessboard.calculatePoint(i,j),ChessColor.BLACK,chessboard.clickController, chessboard.CHESS_SIZE);
                    case 'c' -> chess[i][j] = new HorseChessComponent(new ChessboardPoint(i,j), chessboard.calculatePoint(i,j),ChessColor.BLACK,chessboard.clickController, chessboard.CHESS_SIZE);
                    case 'd' -> chess[i][j] = new ChariotChessComponent(new ChessboardPoint(i,j), chessboard.calculatePoint(i,j),ChessColor.BLACK,chessboard.clickController, chessboard.CHESS_SIZE);
                    case 'e' -> chess[i][j] = new MinisterChessComponent(new ChessboardPoint(i,j), chessboard.calculatePoint(i,j),ChessColor.BLACK,chessboard.clickController, chessboard.CHESS_SIZE);
                    case 'f' -> chess[i][j] = new AdviserChessComponent(new ChessboardPoint(i,j), chessboard.calculatePoint(i,j),ChessColor.BLACK,chessboard.clickController, chessboard.CHESS_SIZE);
                    case 'g' -> chess[i][j] = new GeneralChessComponent(new ChessboardPoint(i,j), chessboard.calculatePoint(i,j),ChessColor.BLACK,chessboard.clickController, chessboard.CHESS_SIZE);
                    case 'A' -> chess[i][j] = new SoldierChessComponent(new ChessboardPoint(i,j), chessboard.calculatePoint(i,j),ChessColor.BLACK,chessboard.clickController, chessboard.CHESS_SIZE);
                    case 'B' -> chess[i][j] = new CannonChessComponent(new ChessboardPoint(i,j), chessboard.calculatePoint(i,j),ChessColor.RED,chessboard.clickController, chessboard.CHESS_SIZE);
                    case 'C' -> chess[i][j] = new HorseChessComponent(new ChessboardPoint(i,j), chessboard.calculatePoint(i,j),ChessColor.RED,chessboard.clickController, chessboard.CHESS_SIZE);
                    case 'D' -> chess[i][j] = new ChariotChessComponent(new ChessboardPoint(i,j), chessboard.calculatePoint(i,j),ChessColor.RED,chessboard.clickController, chessboard.CHESS_SIZE);
                    case 'E' -> chess[i][j] = new MinisterChessComponent(new ChessboardPoint(i,j), chessboard.calculatePoint(i,j),ChessColor.RED,chessboard.clickController, chessboard.CHESS_SIZE);
                    case 'F' -> chess[i][j] = new AdviserChessComponent(new ChessboardPoint(i,j), chessboard.calculatePoint(i,j),ChessColor.RED,chessboard.clickController, chessboard.CHESS_SIZE);
                    case 'G' -> chess[i][j] = new GeneralChessComponent(new ChessboardPoint(i,j), chessboard.calculatePoint(i,j),ChessColor.RED,chessboard.clickController, chessboard.CHESS_SIZE);
                    default -> {
                        return;//在这里做一个弹窗：棋子乱写的，错误代码103
                    }
                }
                switch (lines[i][j].charAt(0)){
                    case '0' -> chess[i][j].isReversal = false;
                    case '1' -> chess[i][j].isReversal = true;
                    default -> {
                        return;//在这里做一个弹窗：棋子乱写的，错误代码103
                    }
                }
            }
        }




        for(int i = 0; i < steps.size(); i ++){
            procedures.add(new Procedure(cc,chess,redPoints,blackPoints));
        }
        testStep();
    }

    public void loadGameFromProcedure(){
        /**
         * 加载procedure的最后一次棋盘
         */
        Procedure p = procedures.get(procedures.size()-1);
        chessboard.setCurrentColor(p.currentColor);
        chessboard.setCurrentColor(chessboard.getCurrentColor() == ChessColor.BLACK ? ChessColor.RED : ChessColor.BLACK);
        chessboard.redPoints = p.redPoints;
        chessboard.blackPoints = p.blackPoints;
        for(int i = 0; i < p.chesses.length; i ++){
            for(int j = 0; j < p.chesses[i].length; j ++){
                p.chesses[i][j].setVisible(true);
                chessboard.putChessOnBoard(p.chesses[i][j]);
            }
        }
    }

    public void recall(){
        /**
         * 一个悔棋的方法，在悔棋按钮被点击的时候调用
         */
        procedures.remove(procedures.size()-1);
        loadGameFromProcedure();
        saveProcedure();
    }

    public void endgame(){
        //清空棋局，清空procedures
        procedures.clear();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Administrator\\IdeaProjects\\final project\\src\\save\\tt.txt"));
            bw.write(new String(""));
            bw.flush();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveFile(String path){
        /**
         * 这是一个将tt的内容保存到其他文件的方法，也就是存档
         * 直接在点击不同按钮的效果那里，调用这个方法，然后令path等于相应的路径即可
         * 如果点击存档1，地址就是 D:\java代码\IdeaProjects\Class\Demo\src\save\t1.txt
         * 存档2 地址 D:\java代码\IdeaProjects\Class\Demo\src\save\t2.txt
         * 存档3 地址 D:\java代码\IdeaProjects\Class\Demo\src\save\t3.txt
         */
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Administrator\\IdeaProjects\\final project\\src\\save\\tt.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            String s = "";
            while((s = br.readLine()) != null){
                bw.write(s + "\n");
            }
            bw.flush();
            bw.close();
            bw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //判断棋盘是否是4*8，错误编码 102
    public boolean testChessboardStructure(){
        for(int i = 0; i < steps.size(); i++){
            ArrayList<String> history = new ArrayList<>();
            history = steps.get(i);
            if(history.size() < 7){
                //跳出弹窗：棋盘格式错误 错误代码 102
                return false;
            }
            String[][] chesses = new String[4][];
            for(int j = 1; j <= 4; j++){
                chesses[j-1] = history.get(j).split(" ");
            }//这里是用chesses 把棋盘上每个子的缩写都保存下来了
            for(int j = 0; j < chesses.length; j ++){
                if(chesses[j].length != 8){
                    //跳出弹窗：棋盘格式错误 错误代码 102
                    return false;
                }
            }
        }
        return true;
    }

    public void testCurrentcolor(){
        for(int i =0; i < steps.size(); i++){
            if(steps.get(0).equals(ChessColor.RED.getName()) && steps.get(0).equals(ChessColor.BLACK.getName())){
                //弹窗报错：缺少行棋方：错误代码104
                return;
            }
        }
    }

    public void testStep(){
        /**
         * 获取每一个棋盘
         * 得出移动的棋子（不是被吃掉的棋子）
         * 判断移动的棋子的这个移动在不在他的行动canwalkto范围之内
         * 如果不在的话，就报错棋盘行棋步骤错误
         */
        for(int i = 0; i < procedures.size()-1; i++){
            ArrayList<SquareComponent> positionChange = new ArrayList<>();
            SquareComponent[][] cc = procedures.get(i).chesses;
            SquareComponent[][] cf = procedures.get(i+1).chesses;
            for(int j = 0; j < cc.length; j++){
                for(int k = 0; j < cc[j].length; k++){
                    if(cc[j][k] != cf[j][k]){
                        positionChange.add(cc[j][k]);
                    }
                }
            }
            if(positionChange.size() >= 3){
                //跳出弹窗： 第i次行棋步骤错误
                return;
            }
            for(int j = 0; j < positionChange.size(); j++){
                ArrayList<ChessboardPoint> can = positionChange.get(j).canWalkTo(cc);
                int count = 0;
                for(int k = 0; k < positionChange.size(); k++){
                    if(can.get(k).getX() == positionChange.get(j).getChessboardPoint().getX()
                    && can.get(k).getY() == positionChange.get(j).getChessboardPoint().getY()){
                        count++;
                    }
                }
                if(count == 0){
                    //跳出弹窗： 第i次行棋步骤错误
                    return;
                }
            }
        }
    }
}
