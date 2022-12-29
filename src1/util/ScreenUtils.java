package util;

import java.awt.*;

public class ScreenUtils {
    public static int getScreenWidth(){
        return Toolkit.getDefaultToolkit().getScreenSize().width;
    }

    public static int getScreenHigtht(){
        return Toolkit.getDefaultToolkit().getScreenSize().height;
    }
}
