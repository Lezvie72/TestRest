package paths;

public class Paths {

    public static String pathToJsons() {
        String baseDir = System.getProperty("user.dir");
        return baseDir + "/src/test/java/jsons/";
    }
}
