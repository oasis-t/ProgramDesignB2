import java.util.Scanner;

public class index {
    static int result = 0;//获取表达式结果
    static int timer = 30;//计时器（难度系数默认为30秒）
    static int grade = 0;//单轮分数
    static boolean isExit = true;//游戏循环条件

    public static void entrance() {

//        while (isExit) {
        //isExit为false时退出游戏

        baseInfo.getUsername();//获取用户名
//        baseInfo.createRandom();
        checkAnswer.checkAnswer();//检查所生成的随机数是否有解

        if (checkAnswer.isFlag) {
            //有解，进行后续计算
            System.out.println("有解");
            long startTime = System.currentTimeMillis();
            result = baseInfo.calResult();
            long endTime = System.currentTimeMillis();
            long usedTime = (endTime - startTime) / 1000;
            System.out.println(result);
            if (usedTime >= 30) {
                System.out.println("已超时，游戏结束，不得分");
            } else {
                if (result == 24) {
                    //按剩余时间计分
                    grade = timer - (int) usedTime;
                    /*if(grade <= 0){

                    }*/
                    System.out.println("得分为：" + grade);
                    gradeRecord.output(grade);
                } else {
                    //游戏结束
                    System.out.println("输入表达式不正确，游戏结束");
                }
            }
        } else {
            //无解，读入NO
            long startTime = System.currentTimeMillis();
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextLine()) {
                String str = sc.nextLine();
                long endTime = System.currentTimeMillis();
                long usedTime = (endTime - startTime) / 1000;
//                String str = getInput();
                if (usedTime >= 30) {
                    System.out.println("已超时，游戏结束，不得分");
                } else {
                    if (str.equals("NO")) {
                        //正常得分，进入下一题
                        System.out.println("进入下一题");
                    } else {
                        System.out.println("判断错误，游戏结束");
                    }
                }
            }
        }
        /*{
            System.out.println("是否继续游戏？(Y/N)");
            String s = getInput();
            if(s == "N"|| s == "NO"){
                isExit = false;
        }*/

    }


//    }

    /*public static String getInput() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            String str = sc.nextLine();
            return str;
        }
        return "";

    }*/
}



