package controller;

import view.Chessboard;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * 这个类主要完成由窗体上组件触发的动作。
 * 例如点击button等
 * ChessGameFrame中组件调用本类的对象，在本类中的方法里完成逻辑运算，将运算的结果传递至chessboard中绘制
 * 属性：棋盘
 * 构造器：设置棋盘为传过来的棋盘
 * 方法：loadGameFromFile：从文件中加载游戏的方法
 */
public class GameController {
    private Chessboard chessboard;

    public GameController(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    /**
     * 这是一个从文件中加载游戏的方法
     * chessData 是string的list集合，按行来读取文件
     * 为啥要遍历输出每一个String，
     * @param path
     * @return
     */

    public ArrayList<ArrayList<String>> loadGameFromFile(String path) {
        try {
            //这是判断第一个错误：文件类型错误
            int i = path.lastIndexOf('.');
            String type = null;
            if (i > 0) {
                type = path.substring(i+1);
                //读取文件的最后几个字符（文件类型）
                //但是这个方法弊端是不可以写D:\java代码\IdeaProjects\Class\Project\src\tt，就是tt后面一定要写txt
            }
            if(!type.equals("txt")){
                /**
                 * 这里需要做一个弹框：
                 * 错误代码101
                 * 请输入txt文件（文件需要.txt后缀）
                 */
                return null;
            }
            List<String> chessData = Files.readAllLines(Path.of(path));
            //将文件一行一行读取，变成list<string>集合返回
            chessboard.loadGame(chessData);  //遍历chessboard集合，输出每一个string
            //我决定直接在这里判断棋盘是否有错误
            ArrayList<ArrayList<String>> everyStep = new ArrayList<>();
            ArrayList<Integer> gap = new ArrayList<>();
            int count = 0;
            for(String s : chessData){
                if(s.isBlank()){
                    gap.add(count);
                }
                count ++;
            }
            int count2 = 0;
            for(int j = 0; j < chessData.size(); j++){
                if(j == gap.get(count2)){
                    count2 ++;
                }else{
                    everyStep.get(count2).add(chessData.get(j));
                }
            }
            //这样我们就把棋盘的每一步都保存下来了，这样我们获得的就是saver里判断的history
            String[][] chesses;
            for(ArrayList<String> history : everyStep){
                //统一一下，return true 就是有错
                if((chesses = Saver.testChessboardStructure(history)).equals(null)){
                    return null;
                }else if(Saver.checkSquarecomponent(chesses)){
                    return null;
                } else if (Saver.testCurrentColor(history)) {
                    return null;
                } else if (Saver.testCurrentColor(history)) {
                    return null;
                }else{

                }
            }
            return everyStep; //返回everystep这个集合
            //在调用这个方法接收这个集合的时候，要判断一下接受的是不是null
            //没关系至少我们已经获得了文件里面的信息了
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
