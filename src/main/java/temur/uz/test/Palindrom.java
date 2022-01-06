package temur.uz.test;

public class Palindrom {
    public static void main(String[] args) {
        int a = 122211, temp = 0, res = 0;
        int b = a;
        while (a>0){
            temp = a%10;
            res = res*10+temp;
            a=a/10;
        }
        if (res==b){
            System.out.println("palindrom");
        }else {
            System.out.println("palindrom emas");
        }
    }
}
