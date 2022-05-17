package util;

public class MyUtils {

    public static void printIntArr(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + ", ");
        }
        String res = sb.toString();
        res = res.substring(0, res.lastIndexOf(","));
        System.out.println(res + "]");
    }

    public static void swap(int[] arr ,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
