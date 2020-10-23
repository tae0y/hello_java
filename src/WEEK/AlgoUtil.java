package WEEK;

public class AlgoUtil {
    public static void print_array(int[] arr) {
        for(int a : arr) System.out.print(a + " ");
        System.out.println();
    }

    public static boolean array_comp(int[] r1, int[] ints) {
        if(r1.length!=ints.length) return false;
        boolean flag = true;
        for(int i=0; i<r1.length; i++){
            if(r1[i]!=ints[i]) {
                flag=false;
                break;
            }
        }
        return flag;
    }
}
