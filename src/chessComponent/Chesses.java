package chessComponent;

import controller.ClickController;
import model.ChessColor;
import model.ChessboardPoint;
import view.Chessboard;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Chesses {
//
//    Chessboard cb = new Chessboard(20,10);
//
//
//    ChessComponent Ministerr1 = new MinisterChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1);
//    ChessComponent Ministerr2 = new MinisterChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1);
//    ChessComponent Ministerb1 = new MinisterChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1);
//    ChessComponent Ministerb2 = new MinisterChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1);
//
//    ChessComponent Cannonr1 = new CannonChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1);
//    ChessComponent Cannonr2 = new CannonChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1);
//    ChessComponent Cannonb1 = new CannonChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1);
//    ChessComponent Cannonb2 = new CannonChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1);
//    ChessComponent Soldierr1 = new SoldierChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1);
//    ChessComponent Soldierr2 = new SoldierChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1);
//    ChessComponent Soldierr3 = new SoldierChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1);
//    ChessComponent Soldierr4 = new SoldierChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1);
//    ChessComponent Soldierr5 = new SoldierChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1);
//    ChessComponent Soldierb1 = new SoldierChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1);
//    ChessComponent Soldierb2 = new SoldierChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1);
//    ChessComponent Soldierb3 = new SoldierChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1);
//    ChessComponent Soldierb4 = new SoldierChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1);
//    ChessComponent Soldierb5 = new SoldierChessComponent(new ChessboardPoint(0, 0), new Point(0,0), ChessColor.RED,new ClickController(cb),1);
//
//    ArrayList<ChessComponent> chesses = new ArrayList<>();
//    {
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

    ArrayList<ChessComponent> chesses = new ArrayList<>();
    {
        chesses.add(GeneralChessComponent.getGeneralb());
        chesses.add(GeneralChessComponent.getGeneralr());
        chesses.add(AdvisorChessComponent.getAdvisorb1());
        chesses.add(AdvisorChessComponent.getAdvisorb2());
        chesses.add(AdvisorChessComponent.getAdvisorr1());
        chesses.add(AdvisorChessComponent.getAdvisorr2());
        chesses.add(CannonChessComponent.getCannonb1());
        chesses.add(CannonChessComponent.getCannonb2());
        chesses.add(CannonChessComponent.getCannonr1());
        chesses.add(CannonChessComponent.getCannonr2());
        chesses.add(ChariotChessComponent.getChariotb1());
        chesses.add(ChariotChessComponent.getChariotb2());
        chesses.add(ChariotChessComponent.getChariotr1());
        chesses.add(ChariotChessComponent.getChariotr2());
        chesses.add(HorseChessComponent.getHorseb1());
        chesses.add(HorseChessComponent.getHorseb2());
        chesses.add(HorseChessComponent.getHorser1());
        chesses.add(HorseChessComponent.getHorser2());
        chesses.add(MinisterChessComponent.getMinisterb1());
        chesses.add(MinisterChessComponent.getMinisterb2());
        chesses.add(MinisterChessComponent.getMinisterr1());
        chesses.add(MinisterChessComponent.getMinisterr2());
        chesses.add(SoldierChessComponent.getSoldierb1());
        chesses.add(SoldierChessComponent.getSoldierb2());
        chesses.add(SoldierChessComponent.getSoldierb3());
        chesses.add(SoldierChessComponent.getSoldierb4());
        chesses.add(SoldierChessComponent.getSoldierb5());
        chesses.add(SoldierChessComponent.getSoldierr1());
        chesses.add(SoldierChessComponent.getSoldierr2());
        chesses.add(SoldierChessComponent.getSoldierr3());
        chesses.add(SoldierChessComponent.getSoldierr4());
        chesses.add(SoldierChessComponent.getSoldierr5());


        int[] a = {0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3};
        int[] b = new int[a.length];
        for(int i=0;i<a.length;i++) {
            int tmp = (int) (Math.random() * (a.length - i));//?????????[0,a.length-i]
            b[i] = a[tmp];
            int change = a[a.length - i - 1];
            a[a.length - i - 1] = a[tmp];
            a[tmp] = change;
        } //?????????????????????????????????a???????????????????????????
        for (int i = 0; i < b.length; i++) {
            chesses.get(i).getChessboardPoint().setX(b[i]);
        }
        for (int j = 0; j < 3; j++) {
            int c[] = {0,1,2,3,4,5,6,7};
            int d[] = new int[c.length];
            for(int i=0;i<c.length;i++) {
                int tmp = (int) (Math.random() * (c.length - i));//?????????[0,a.length-i]
                d[i] = c[tmp];
                int change = c[c.length - i - 1];
                c[c.length - i - 1] = c[tmp];
                c[tmp] = change;
            }
            for (int i = 0; i < chesses.size(); i++) {
                int count = 0;
                if(chesses.get(i).getChessboardPoint().getX() == j){
                    chesses.get(i).getChessboardPoint().setY(d[count]);
                    count ++;
                }
            }
        }
        //??????????????????????????????????????????xy????????????
        //???????????????????????? squarecomponent[][]??????
        for(ChessComponent c : chesses){
            SquareComponent[][] squareComponents = Chessboard.getInstance().getChessComponents();
            squareComponents[c.getX()][c.getX()] = c;
        }
        //??????????????????????????????????????????????????????????????????(?????????

    }
//
//    public static void main(String[] args) {
//        System.out.println();
//    }

}