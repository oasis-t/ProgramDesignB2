
import java.util.*;

public class main {
    static int result = 0;//获取表达式结果
    static int timer = 30;
    static int grade=0;//单轮分数


    public static void main(String[] args) {
        baseInfo.getUsername();
//        baseInfo.createRandom();
        checkAnswer.checkAnswer();
        long startTime =  System.currentTimeMillis();
        result = baseInfo.calResult();
        long endTime =  System.currentTimeMillis();
        long usedTime = (endTime-startTime)/1000;
        System.out.println(result);

        if(usedTime == 30){
            System.out.println("时间到，游戏结束");
        }

        if(result == 24){
            //按剩余时间计分
            grade = timer - (int)usedTime;
            System.out.println("得分为：" + grade);
        }else{
            //游戏结束
            System.out.println("输入表达式不正确，游戏结束");
        }

    }

}
