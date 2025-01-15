package simpleBoard;

public class Bitonic {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 5, 7, 4, 3, 1, 2};
        System.out.println(findMaxBitonic(nums));
    }

    private static int findMaxBitonic(int[] nums) {
        int maxLength = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            int left = i - 1;
            int right = i + 1;
            int length = 1;

            // 왼쪽으로 감소하는 부분 탐색
            while (left >= 0 && nums[left] < nums[left + 1]) {
                length++;
                left--;
            }

            // 오른쪽으로 감소하는 부분 탐색
            while (right < nums.length && nums[right] < nums[right - 1]) {
                length++;
                right++;
            }

            // 최대 길이 갱신
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
}
