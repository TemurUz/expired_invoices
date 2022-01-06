package temur.uz.test;


public class Array {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4,5,64};
//        int b[]=a.clone();

//        int b[] = Arrays.copyOfRange(a,2,3);//6-usul: (Arrays.copyOfRange () dan foydalanish)
        String str = "madam";

        String reverse = new  StringBuffer(str).reverse().toString();
        if (str.equals(reverse)){
            System.out.println("Palindrom");
        }else {
            System.out.println("Palindrom emas");
        }

    }

}
