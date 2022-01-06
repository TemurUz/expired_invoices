package temur.uz.codeforcesProblems;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int arr[] = {1,2,3,4,5};

        int[] ints = rotateLeft(d, arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }

    public static int [] rotateLeft(int d, int arr []){
        int temp = arr[0];
        for (int i = 1; i < d; i++) {
            arr[0]=arr[arr.length-1];
            arr[arr.length-1]=temp;
        }
        return arr;
    }
}
