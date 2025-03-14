package sorting;

import java.util.Arrays;

public class multitask {

    public static void main(String[] args) {
        int[] task = {8, 5, 2, 9, 7};
        int k = 30;
        System.out.println(solution(task, k));
    }

    private static int solution(int[] task, int k) {

        int answer = 0;
        int[] copy = new int[task.length + 1];
        int rest = 0;
        System.arraycopy(task, 0, copy, 1, task.length);
        Arrays.sort(copy);
        for (int i = 0; i < copy.length; i++) {
           
        }
        return -1;
    }


}
