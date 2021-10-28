
import java.util.*;

public class main {
    static int result = 0;

    public static void main(String[] args) {

        baseInfo.getUsername();
        baseInfo.createRandom();

        result = baseInfo.calResult();
        System.out.println(result);

        if(result == 24){
            //按剩余时间计分
            System.out.println("得分为：");
        }else{
            //游戏结束
        }

    }

}
