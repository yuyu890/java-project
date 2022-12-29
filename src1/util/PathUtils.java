package util;

public class PathUtils {

    private static final String PATH = "C:\\Users\\Administrator\\IdeaProjects\\final project\\images\\";

    public static String getRealPath(String relativePath) {
        return PATH + relativePath;
    }
}
