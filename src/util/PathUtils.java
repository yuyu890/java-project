package util;

public class PathUtils {

    private static final String PATH = "C:\\Users\\Administrator\\IdeaProjects\\project\\images\\";

    public static String getRealPath(String relativePath) {
        return PATH + relativePath;
    }
}
