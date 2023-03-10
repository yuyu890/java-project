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
//            int tmp = (int) (Math.random() * (a.length - i));//?????????[0,a.length-i]
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
//                int tmp = (int) (Math.random() * (c.length - i));//?????????[0,a.length-i]
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
//        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\java??????\\IdeaProjects\\Class\\Project\\src\\tt"));
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
//            int tmp = (int) (Math.random() * (a.length - i));//?????????[0,a.length-i]
//            b[i] = a[tmp];
//            int change = a[a.length - i - 1];
//            a[a.length - i - 1] = a[tmp];
//            a[tmp] = change;
//        } //?????????????????????????????????a??????(???b??????????????????????????????
//        for (int i = 0; i < b.length; i++) {
//            chesses.get(i).getChessboardPoint().setX(b[i]);
//        }//??????????????????????????????????????????a?????????????????????
//        for (int j = 0; j <= 3; j++) {
//            int c[] = {0,1,2,3,4,5,6,7};
//            int d[] = new int[c.length];
//            for(int i=0;i<c.length;i++) {
//                int tmp = (int) (Math.random() * (c.length - i));//?????????[0,a.length-i]
//                d[i] = c[tmp];
//                int change = c[c.length - i - 1];
//                c[c.length - i - 1] = c[tmp];
//                c[tmp] = change;
//            }//?????????????????????d??????
//            for (int i = 0; i < chesses.size(); i++) {
//                int count = 0;
//                if(chesses.get(i).getChessboardPoint().getX() == j){
//                    chesses.get(i).getChessboardPoint().setY(d[count]);
//                    count ++;
//                }
//            }//?????????????????????????????????????????????????????????????????????????????????
//        }
//        //??????????????????????????????????????????xy????????????
//        //???????????????????????? squarecomponent[][]??????
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
//            int tmp = (int) (Math.random() * (c.length - i));//?????????[0,a.length-i]
//            d[i] = c[tmp];
//            int change = c[c.length - i - 1];
//            c[c.length - i - 1] = c[tmp];
//            c[tmp] = change;
//        }
//        for (int i = 0; i < d.length; i++) {
//            System.out.print(d[i] + " ");
//        }

//        EmptySlotComponent s = new EmptySlotComponent(new ChessboardPoint(0, 0), new Point(0,0),new ClickController(),1, "000");
//????????????????????????????????????????????????????????????


//        Chessboard c = Chessboard.getInstance();
//        System.out.println();
//        System.out.println();
//        //???????????????getinstance?????????????????????
//        Chessboard cc = Chessboard.getInstance();
////problem solved, ????????????????????????????????????new chessboard????????????great???

//    RandomAccessFile ra = new RandomAccessFile(new File("D:\\java??????\\IdeaProjects\\Class\\Project\\src\\tt"), "rw");
//    ra.seek(0);
//    String s = "That's so awkward";
//    ra.write(s.getBytes());
//    ra.close();
//        /**
//         * ?????? ?????????????????????????????????????????????
//         * ????????????????????????????????????
//         * 1.???????????????????????? ?????????BLACK ??? RED  ???+???????????????
//         * 2.??????????????? ???????????????????????????????????????????????????????????????????????????
//         * 3.?????????????????????
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
            chessData = Files.readAllLines(Path.of("D:\\java??????\\IdeaProjects\\Class\\Project\\ff"));
            int count = 0;
            for(String s : chessData){
                if(s.isBlank()){
                    System.out.println(count);

                }
                /**
                 * isEmpty()
                 * StringUtils.isEmpty() ??? ?????????????????????null????????? ??????????????????true???
                 * ???????????? ????????????????????????????????????????????????isEmpty??????????????????
                 *
                 * isBlank()
                 * StringUtils.isEmpty() ??? ?????????????????????null????????? ?????? ?????????????????????true???
                 * ?????????null??????????????????????????? ???????????????????????????????????????isBlank??????????????????
                 */
                count ++;
            }
            return chessData; //??????chessdata????????????
            //????????????????????????????????????????????????????????????
            //????????????????????????????????????list<string>????????????
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        //this is a methods to get different step and the situation of the chessboard
        //seperate each step with a \n and we can get the line of \n, between \n is a chessboard step

    }

    public static void write(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\java??????\\IdeaProjects\\Class\\Project\\src\\tt"));
            String s = "\n??????";
            bw.write(s);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //test if \n will work in writer  results: it works
    }
}
