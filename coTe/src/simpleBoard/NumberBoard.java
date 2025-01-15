package simpleBoard;

//board c*r
// role : 가장 왼 쪽 && 가장 밑부분에서 시작
//        시계 방향으로 체워나감
//주어지는 것 : 매개변수 c && r, time k
//구현 해야하는 것 : k가 주어질 때 k 번 째 사람의 좌표를 구하시오.

import java.util.Scanner;

//== 구현
//board 생성 k*c -> 규칙은 (북 동 남 서)로 좌료가 이동하게
// -> k 번 반복 후 반환(for문을 사용해서 k번 반복하게 하고 나중에 지역변수의 값을 매게 변수에 전달 후 반환하게 하면 될듯)
public class NumberBoard {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int r = sc.nextInt();
        int k = sc.nextInt();

        int[][] board = new int[c][r];

        //answer.findByT(board, c, r, k);


    }

    //막히는 거 answer클래스의 aws메서드는 배열을 반환하게
    static class answer {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = { 0, -1, 0, 1};

        int d = 4;

        int nx=0;
        int ny= 0;

        int[][] point = new int[nx][ny];
        public void findByT(int[][] board, int c, int r, int k) {

            for (int j = 0; j < k; j++) {
                nx = nx +dx[d];
                ny = ny +dy[d];

                //board 끝에 다다랐거나 아니면 이미 다른 사람이 있을 경우 d값 변경.

            }


        }
    }


}

