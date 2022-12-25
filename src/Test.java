import chessComponent.*;
import controller.ClickController;
import controller.Saver;
import model.ChessColor;
import model.ChessboardPoint;
import view.Chessboard;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SimpleTimeZone;

public class Test {
    public static void main(String[] args) throws Exception{

//        ArrayList<ChessComponent> chesses = new ArrayList<>();
//        chesses.add(new GeneralChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1));
//        chesses.add(new GeneralChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK,new ClickController(cb),1));
//        chesses.add(new AdvisorChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1));
//        chesses.add(new AdvisorChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1));
//        chesses.add(new AdvisorChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK,new ClickController(cb),1));
//        chesses.add(new AdvisorChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK,new ClickController(cb),1));
//        chesses.add(new MinisterChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1));
//        chesses.add(new MinisterChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1));
//        chesses.add(new MinisterChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK,new ClickController(cb),1));
//        chesses.add(new MinisterChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK,new ClickController(cb),1));
//        chesses.add(new ChariotChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1));
//        chesses.add(new ChariotChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1));
//        chesses.add(new ChariotChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK,new ClickController(cb),1));
//        chesses.add(new ChariotChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK,new ClickController(cb),1));
//        chesses.add(new HorseChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1));
//        chesses.add(new HorseChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1));
//        chesses.add(new HorseChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK,new ClickController(cb),1));
//        chesses.add(new HorseChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK,new ClickController(cb),1));
//        chesses.add(new CannonChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1));
//        chesses.add(new CannonChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1));
//        chesses.add(new CannonChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK,new ClickController(cb),1));
//        chesses.add(new CannonChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK,new ClickController(cb),1));
//        chesses.add(new SoldierChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1));
//        chesses.add(new SoldierChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1));
//        chesses.add(new SoldierChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1));
//        chesses.add(new SoldierChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1));
//        chesses.add(new SoldierChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1));
//        chesses.add(new SoldierChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK,new ClickController(cb),1));
//        chesses.add(new SoldierChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK,new ClickController(cb),1));
//        chesses.add(new SoldierChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK,new ClickController(cb),1));
//        chesses.add(new SoldierChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK,new ClickController(cb),1));
//        chesses.add(new SoldierChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.BLACK,new ClickController(cb),1));
//
//        int[] a = {0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3};
//        int[] b = new int[a.length];
//        for(int i=0;i<a.length;i++) {
//            int tmp = (int) (Math.random() * (a.length - i));//随机数[0,a.length-i]
//            b[i] = a[tmp];
//            int change = a[a.length - i - 1];
//            a[a.length - i - 1] = a[tmp];
//            a[tmp] = change;
//        }
//        for (int i = 0; i < b.length; i++) {
//            chesses.get(i).getChessboardPoint().setX(b[i]);
//        }
//        for (int j = 0; j < 3; j++) {
//            int c[] = {0,1,2,3,4,5,6,7};
//            int d[] = new int[c.length];
//            for(int i=0;i<c.length;i++) {
//                int tmp = (int) (Math.random() * (c.length - i));//随机数[0,a.length-i]
//                d[i] = c[tmp];
//                int change = c[c.length - i - 1];
//                c[c.length - i - 1] = c[tmp];
//                c[tmp] = change;
//            }
//            for (int i = 0; i < chesses.size(); i++) {
//                int count = 0;
//                if(chesses.get(i).getChessboardPoint().getX() == j){
//                    chesses.get(i).getChessboardPoint().setY(d[count]);
//                    count ++;
//                }
//            }
//
//        }
//        for (int i = 0; i < chesses.size(); i++) {
//            System.out.println(chesses.get(i).getChessboardPoint().getX() + " " + chesses.get(i).getChessboardPoint().getY());
//        }

//        InputStreamReader isr = new InputStreamReader(System.in);
//        BufferedReader br = new BufferedReader(isr);
//        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\java代码\\IdeaProjects\\Class\\Project\\src\\tt"));
//        String s = "";
//        while((s = br.readLine()) != null){
//            System.out.println(s);
//            bw.write(s);
//        }
//        bw.flush();
//
//        bw.close();
//        br.close();
//        isr.close();

//        ArrayList<ChessComponent> chesses = new ArrayList<>();
//        chesses.add(GeneralChessComponent.getGeneralb());
//        chesses.add(GeneralChessComponent.getGeneralr());
//        chesses.add(AdvisorChessComponent.getAdvisorb1());
//        chesses.add(AdvisorChessComponent.getAdvisorb2());
//        chesses.add(AdvisorChessComponent.getAdvisorr1());
//        chesses.add(AdvisorChessComponent.getAdvisorr2());
//        chesses.add(CannonChessComponent.getCannonb1());
//        chesses.add(CannonChessComponent.getCannonb2());
//        chesses.add(CannonChessComponent.getCannonr1());
//        chesses.add(CannonChessComponent.getCannonr2());
//        chesses.add(ChariotChessComponent.getChariotb1());
//        chesses.add(ChariotChessComponent.getChariotb2());
//        chesses.add(ChariotChessComponent.getChariotr1());
//        chesses.add(ChariotChessComponent.getChariotr2());
//        chesses.add(HorseChessComponent.getHorseb1());
//        chesses.add(HorseChessComponent.getHorseb2());
//        chesses.add(HorseChessComponent.getHorser1());
//        chesses.add(HorseChessComponent.getHorser2());
//        chesses.add(MinisterChessComponent.getMinisterb1());
//        chesses.add(MinisterChessComponent.getMinisterb2());
//        chesses.add(MinisterChessComponent.getMinisterr1());
//        chesses.add(MinisterChessComponent.getMinisterr2());
//        chesses.add(SoldierChessComponent.getSoldierb1());
//        chesses.add(SoldierChessComponent.getSoldierb2());
//        chesses.add(SoldierChessComponent.getSoldierb3());
//        chesses.add(SoldierChessComponent.getSoldierb4());
//        chesses.add(SoldierChessComponent.getSoldierb5());
//        chesses.add(SoldierChessComponent.getSoldierr1());
//        chesses.add(SoldierChessComponent.getSoldierr2());
//        chesses.add(SoldierChessComponent.getSoldierr3());
//        chesses.add(SoldierChessComponent.getSoldierr4());
//        chesses.add(SoldierChessComponent.getSoldierr5());
//
//        SquareComponent[][] squareComponents = new SquareComponent[4][8];
//
//        int[] a = {0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3};
//        int[] b = new int[a.length];
//        for(int i=0;i<a.length;i++) {
//            int tmp = (int) (Math.random() * (a.length - i));//随机数[0,a.length-i]
//            b[i] = a[tmp];
//            int change = a[a.length - i - 1];
//            a[a.length - i - 1] = a[tmp];
//            a[tmp] = change;
//        } //这里获得一个打乱顺序的a数组(即b数组），代表棋子的行
//        for (int i = 0; i < b.length; i++) {
//            chesses.get(i).getChessboardPoint().setX(b[i]);
//        }//让棋子的横坐标等于打乱顺序的a数组的每个元素
//        for (int j = 0; j <= 3; j++) {
//            int c[] = {0,1,2,3,4,5,6,7};
//            int d[] = new int[c.length];
//            for(int i=0;i<c.length;i++) {
//                int tmp = (int) (Math.random() * (c.length - i));//随机数[0,a.length-i]
//                d[i] = c[tmp];
//                int change = c[c.length - i - 1];
//                c[c.length - i - 1] = c[tmp];
//                c[tmp] = change;
//            }//获得打乱顺序的d数组
//            for (int i = 0; i < chesses.size(); i++) {
//                int count = 0;
//                if(chesses.get(i).getChessboardPoint().getX() == j){
//                    chesses.get(i).getChessboardPoint().setY(d[count]);
//                    count ++;
//                }
//            }//对打乱顺序后的每一行的每个棋子纵坐标进行排序，进行四次
//        }
//        //然后在这里属于是把每个棋子的xy都打乱了
//        //然后再把他们塞进 squarecomponent[][]里面
//        for(ChessComponent c : chesses){
//            squareComponents[c.getX()][c.getY()] = c;
//        }
//
//        for(int i = 0; i < 4; i++){
//            for(int j = 0; j < 4; j++){
//                System.out.printf("%s (%d, %d) \n", squareComponents[i][j].getABBREVIATION(), squareComponents[i][j].getChessboardPoint().getX(),
//                        squareComponents[i][j].getChessboardPoint().getY());
//            }
//        }

//        int c[] = {0,1,2,3,4,5,6,7};
//        int d[] = new int[c.length];
//        for(int i=0;i<c.length;i++) {
//            int tmp = (int) (Math.random() * (c.length - i));//随机数[0,a.length-i]
//            d[i] = c[tmp];
//            int change = c[c.length - i - 1];
//            c[c.length - i - 1] = c[tmp];
//            c[tmp] = change;
//        }
//        for (int i = 0; i < d.length; i++) {
//            System.out.print(d[i] + " ");
//        }

//        EmptySlotComponent s = new EmptySlotComponent(new ChessboardPoint(0, 0), new Point(0,0),new ClickController(),1, "000");
//寄了，我创建一个棋子对象之后棋棋盘重排了


//        Chessboard c = Chessboard.getInstance();
//        System.out.println();
//        System.out.println();
//        //寄了，每次getinstance都会重新排一次
//        Chessboard cc = Chessboard.getInstance();
////problem solved, 并不是会重排，只有第一次new chessboard会重排，great！

//    RandomAccessFile ra = new RandomAccessFile(new File("D:\\java代码\\IdeaProjects\\Class\\Project\\src\\tt"), "rw");
//    ra.seek(0);
//    String s = "That's so awkward";
//    ra.write(s.getBytes());
//    ra.close();
//        /**
//         * 不好 这玩意好像是覆盖式的，这可咋办
//         * 我想想，我们要改的地方有
//         * 1.行棋方，在第一行 可以用BLACK 和 RED  （+两个空格）
//         * 2.棋盘的改变 通过行棋步骤，找到改变的棋子位置，然后在那个位置改
//         * 3.行棋步骤的添加
//         */

//        List<String> history = new ArrayList<>();
//        history.add("BAlck");
//        history.add("BG1 HY3 HG7 HY0 FG8 GT7 HY8 GG9");
//        history.add("BG2 HY3 HG7 HY0 FG8 GT7 HY8 GG9");
//        ArrayList<ArrayList<String>> chesses = new ArrayList<>();
//        chesses.add(new ArrayList<>());
//        for(int j = 1; j < history.size(); j ++){
//            Collections.addAll(chesses.get(j-1), history.get(j).split(" "));
//        }
//        String[][] chesses = new String[4][];
//        for(int j = 1; j < history.size(); j++){
//            chesses[j-1] = history.get(j).split(" ");
//        }
//        for(int j = 0; j < chesses.length; j ++){
//            for(int i = 0; i < chesses[j].length; i++){
//                System.out.print(chesses[j][i] + " ");
//            }System.out.println();
//        }

        //loadGameFromFile();
        write();







    }

    public static List<String> loadGameFromFile() {
        List<String> chessData = null;
        try {
            chessData = Files.readAllLines(Path.of("D:\\java代码\\IdeaProjects\\Class\\Project\\ff"));
            int count = 0;
            for(String s : chessData){
                if(s.isBlank()){
                    System.out.println(count);

                }
                /**
                 * isEmpty()
                 * StringUtils.isEmpty() — 判断的是内容为null、“” 时，返回值是true，
                 * 如果是“ ”，空串中存在一个空格的话，那么isEmpty认为不是空的
                 *
                 * isBlank()
                 * StringUtils.isEmpty() — 判断的是内容为null、“” 、“ ”时，返回值是true，
                 * 不管是null、“”（空串）、“ ”（由空白符组成的空串），isBlank都认为是空的
                 */
                count ++;
            }
            return chessData; //返回chessdata这个集合
            //没关系至少我们已经获得了文件里面的信息了
            //将文件一行一行读取，变成list<string>集合返回
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        //this is a methods to get different step and the situation of the chessboard
        //seperate each step with a \n and we can get the line of \n, between \n is a chessboard step

    }

    public static void write(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\java代码\\IdeaProjects\\Class\\Project\\src\\tt"));
            String s = "\n你好";
            bw.write(s);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //test if \n will work in writer  results: it works
    }
}
