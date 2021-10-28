import java.util.Scanner;

public class baseInfo {
    static int grade=0;//单轮分数
    static int[] arr =new int[4];//四个随机数
    static String username = null;//用户名
    static String expression = null;//用户输入的表达式
    static boolean isFlag = true;//表达式是否合法
    static int result=0;//用于判断表达式结果是否为24

    public static void getUsername(){
        //读取用户名
        System.out.println("请输入玩家名称：");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            String str1 = sc.nextLine();
            username = str1;
            System.out.println(username);
        }
    }

    public static void createRandom(){
        //生成随机数
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)Math.floor(Math.random()*10)+1;
        }
        for(int i=0;i< arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static int calResult(){
        result = PostFix.getResult();
        return  result;
    }
}
