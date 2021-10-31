import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class checkAnswer {
    static boolean isFlag = false;

    /**
     * 计算24点中可以到的操作
     */
    private static String[] operators = {
            "+", "-", "*", "/"
    };

    public static void checkAnswer() {


//        double[] array = new double[4];
        baseInfo.createRandom();
        double[] array = baseInfo.arr;
        /*int index=0;
        Scanner scanner=new Scanner(System.in);
        while (index<4)
        {
            System.out.println(String.format("请输入第%s个1-10的整数",index+1));
            String tempNumStr=scanner.nextLine();
            if(!StringUtils.isNumeric(tempNumStr))
            {
                System.out.println("你输入的不是一个整数");
                continue;
            }
            double tmpNum=Double.valueOf(tempNumStr);
            if (tmpNum<0 || tmpNum>10)
            {
                System.out.println("你输入的数字不是1-10的数字");
                continue;
            }

            array[index++]=tmpNum;

        }*/

        System.out.println(String.format("你输入的4个1-10的整数为%s,%s,%s,%s",array[0],array[1],array[2],array[3]));
        System.out.println("结果如下：");

        List<double[]> resultAllList = new ArrayList<>();
        List<double[]> list = new ArrayList<>();
        list.add(array);
        list.add(new double[]{array[1], array[2], array[3], array[0]});
        list.add(new double[]{array[2], array[3], array[0], array[1]});
        list.add(new double[]{array[3], array[0], array[1], array[2]});
        for (int i = 0; i < list.size(); i++) {
            getAllArray(resultAllList, Arrays.copyOf(list.get(i), list.get(i).length));
        }

        int sum = 0;
        Iterator<double[]> iterator = resultAllList.iterator();
        while (iterator.hasNext()) {
            double[] tempArray = iterator.next();
            sum += caculate24Point(tempArray);
            sum += caculate24Point2(tempArray);
        }

        System.out.println("总共方案数量：" + sum);
        /*if(sum!= 0){
            isFlag = true;
        }
        return isFlag;*/
    }


    /**
     * 获取array的所有可能组合
     *
     * @param list
     * @param array
     */
    public static void getAllArray(List<double[]> list, double[] array) {
        if (!exists(list, array)) {
            list.add(array);
        }

        for (int i = 1; i < 4; i++) {
            double[] arrayCopy = Arrays.copyOf(array, array.length);
            List<double[]> newList = getArrayList(arrayCopy, i);
            Iterator<double[]> iterator = newList.iterator();
            while (iterator.hasNext()) {
                double[] temp = iterator.next();
                if (!exists(list, temp)) {
                    list.add(temp);
                }
            }
        }
    }

    /**
     * 获取array下标遇到i的位置左右组合
     *
     * @param array
     * @param i
     * @return
     */
    public static List<double[]> getArrayList(double[] array, int i) {
        List<double[]> list = new ArrayList<>();

        for (int j = i; j > 0; j--) {
            double temp = array[j];
            array[j] = array[j - 1];
            array[j - 1] = temp;
            list.add(array);
            array = Arrays.copyOf(array, array.length);
        }

        return list;
    }

    /**
     * array是否存啊在list中
     *
     * @param list
     * @param array
     * @return
     */
    public static boolean exists(List<double[]> list, double[] array) {
        Iterator<double[]> iterator = list.iterator();
        while (iterator.hasNext()) {
            double[] tmpArray = iterator.next();
            if (tmpArray[0] == array[0] && tmpArray[1] == array[1] && tmpArray[2] == array[2] && tmpArray[3] == array[3]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 计算array能算24点的所有组合，从左到右的顺序
     *
     * @param
     * @throws Exception
     */
    public static int caculate24Point(double[] array)  {
        int count = 0;
        /*if (array.length != 4) {
            throw new Exception("不是四个数");
        }*/


        for (String op : operators) {
            String expressionStr = "";

            double result = getTwoNumCaculate(array[0], array[1], op);
            if (!isValidResult(result))
            {
                continue;
            }
            expressionStr = String.format("(%s %s %s)", array[0], op, array[1]);

            for (String op2 : operators) {
                double result1 = getTwoNumCaculate(result, array[2], op2);
                if (!isValidResult(result1))
                {
                    continue;
                }
                String expressionStr2 = String.format("(%s %s %s)", expressionStr, op2, array[2]);
                for (String op3 : operators) {

                    double result2 = getTwoNumCaculate(result1, array[3], op3);
                    String expressionStr3 = String.format("%s %s %s", expressionStr2, op3, array[3]);

                    if (result2 == 24.0d) {
                        count++;
                        System.out.println(String.format("方案：%s=%s", expressionStr3, result2));
                    }
                }
            }
        }
        return count;
    }

    /**
     * 计算array能算24点的所有组合 ,两两组合
     *
     * @param array
     * @return
     * @throws Exception
     */
    public static int caculate24Point2(double[] array)  {
        int count = 0;
        /*if (array.length != 4) {
            throw new Exception("不是四个数");
        }*/
        for (String op : operators) {
            double result1 = getTwoNumCaculate(array[0], array[1], op);
            if (!isValidResult(result1))
            {
                continue;
            }
            String expressionStr1 = String.format("(%s %s %s)", array[0], op, array[1]);
            for (String op2 : operators) {
                double result2 = getTwoNumCaculate(array[2], array[3], op2);
                if (!isValidResult(result2))
                {
                    continue;
                }
                String expressionStr2 = String.format("(%s %s %s)", array[2], op2, array[3]);
                for (String op3 : operators) {
                    double result3 = getTwoNumCaculate(result1, result2, op3);
                    String expressionStr3 = String.format("%s %s %s", expressionStr1, op3, expressionStr2);
                    if (result3 == 24.0d) {
                        count++;
                        System.out.println(String.format("方案： %s = %s", expressionStr3, result3));
                    }
                }
            }

        }
        return count;
    }


    /**
     * 是否为合法的计算结果
     * @param result
     * @return
     */
    public  static  boolean isValidResult(double result){
        if (result<1)
        {
            return  false;
        }
        return  result == Math.floor(result);
    }

    private static double getTwoNumCaculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
//                throw new Exception("运算符不符合规范");
                System.out.println("运算符不符合规范");
                return 0;
        }
    }
}