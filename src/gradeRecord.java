import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class gradeRecord {
    //分数写入文件中
    public static void output(int arg) {
        File file = new File("ProgramDesignB2\\src\\Grade.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fw.write("本轮游戏分数为： " + arg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
