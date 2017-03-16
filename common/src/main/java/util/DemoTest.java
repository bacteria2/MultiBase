package util;

/**
 * Created by IonCannon on 2016/11/19.
 */
public class DemoTest {
    public String getSomeThing(){
         return "getSomething worked";
    }


    public static void main(String[] args) {
        int a=10;
        int b=10;
        method(a,b);
        System.out.println("a="+a);
        System.out.println("b="+b);
    }

    private static void method(int a, int b) {
        System.out.println(100);
        System.out.println(100);
        System.exit(0);
    }
}
