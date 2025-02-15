package hashing;

public class TotalNumsV0 {

    public static void main(String[] args) {

        System.out.println(answer("2, 2, 3, -1, -1, 3, 1, 1"));

    }

    private static int answer(String s) {

        char[] charArray = s.toCharArray();
        int[] nums = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            nums[i] = charArray[i] - '0';
        }

        int count = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                sum += nums[j];
                if (sum == '3') {
                    count++;
                    return count;
                }
            }
        }
        return count;
    }
}
