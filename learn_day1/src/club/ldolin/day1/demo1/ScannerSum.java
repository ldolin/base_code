package club.ldolin.day1.demo1;

import java.util.Scanner;

public class ScannerSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("输入第一个数字：");
        int a = sc.nextInt();
        System.out.print("输入第二个数字：");
        int b = sc.nextInt();

        int result = a + b;
        System.out.println("结果是：" + result);
    }
}
