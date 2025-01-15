package simpleBoard;

import java.util.Scanner;

public class findDogMethod {

    static int[][] board = new int[10][10];
    static int[] ppx = {0, -1, 0, 1};
    static int[] ppy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //입력받아 지도 초기화
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        Simulation simulation = new Simulation();
        int result = simulation.findDog();
        System.out.println(result);
    }


    static class Simulation {

        int px, py; //현수의 초기 좌표
        int dx, dy;

        int pd = 0; //현수의 초기 방향
        int dd = 0;

        public Simulation(){
            //초기 좌푤르 찾는 로직
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (board[i][j] == 2) {
                        px = i;
                        py = j;
                    } else if (board[i][j] == 3) {
                        dx = i;
                        dy = j;
                    }
                }
            }


        }

        public int findDog() {

            int time = 0;

            while (time <= 10000) {
                //현수와 강아지가 같은 칸에 있으면 종료
                if (px == dx && py == dy) {
                    return time;
                }

                //시간 증가
                time++;

                //현수 이동
                int npx = px + ppx[pd];
                int npy = py + ppy[pd];
                if (canMove(npx, npy)) {
                    px = npx;
                    py = npy;
                } else {
                    pd = (pd + 1) % 4; //시계 방향으로 회전
                }

                //강아지 이동
                int ndx = dx + ppx[dd];
                int ndy = dy + ppy[dd];
                if (canMove(ndx, ndy)) {
                    dx = ndx;
                    dy = ndy;
                } else {
                    dd = (dd + 1) % 4;
                }
            }
            return -1;// 10000분이 지나도 못 만나는 경우
        }

        private boolean canMove(int x, int y) {
            return x >= 0 && x < 10 && y >= 0 && y < 10 && board[x][y] != 1;
            
        }
    }
}
