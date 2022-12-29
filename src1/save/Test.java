package save;

import java.io.*;
import java.nio.Buffer;

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        //t.clear();
        //t.countLine();
        //t.saveFile();
        String s = "D:\\java代码\\IdeaProjects\\Class\\Demo\\src\\save\\tt.txt";
        String ss = s.substring(s.length()-3);
        System.out.println(ss);
    }

    public void clear(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\java代码\\IdeaProjects\\Class\\Demo\\src\\save\\tt.txt"));
            bw.write(new String(""));
            bw.flush();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void clearFinalStep(){

    }

    public void countLine(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\java代码\\IdeaProjects\\Class\\Demo\\src\\save\\tt.txt"));
            int count = 0;
            String s  = "";
            while((s = br.readLine()) != null){
                count ++;
            }
            System.out.println(count);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveFile(){
        /**如果点击存档1，地址就是 D:\java代码\IdeaProjects\Class\Demo\src\save\t1.txt
         * 存档2 地址 D:\java代码\IdeaProjects\Class\Demo\src\save\t2.txt
         * 存档3 地址 D:\java代码\IdeaProjects\Class\Demo\src\save\t3.txt
         */
        String path = "D:\\java代码\\IdeaProjects\\Class\\Demo\\src\\save\\t1.txt";
        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\java代码\\IdeaProjects\\Class\\Demo\\src\\save\\tt.txt"));
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

}
