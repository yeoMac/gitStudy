package simpleBoard;
//학생들 책상에 세 개의 바구니가 있음. 바구니에는 a, b, c 과일이 담겨져 있고, 학생들인 가장 적게 담긴 바구니를 가져가야 함.
//만약, 바구니에 담긴 과일의 숫자가 같다면 선택할 수 있음

//모든 학생은 딱 한 번 바구니의 과일 한 개를 다른 학생과 교환할 수 있음.
//교환 규칙: 1) 1번 학생부터 번호 순으로 교환을 할 건지 결정
//          2) 양쪽에 이득이 되면 교환을 함.(원래 가져가는 바구니의 과일의 수가 증가한다면 교환 성사)
//          3) 교환 가능한 학생이 여러명인 경우 가장 번호가 작은 학생과 교환한다.
//          4) 서로에게 이득이 생기지 않으면 겨환하지 않음

// 주어지는 것 : 매게변수 이차원 배열. 모든 학생이 가져가는 과일의 총 개수를 반환하는 프로그램을 만들면 됨

import java.util.Scanner;

public class BringFruit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("학생 수를 입력하세요: ");
        int n = sc.nextInt();
        int[][] fruitBag = new int[n][3];

        System.out.println("학생별 바구니 정보를 입력하세요. (사과, 배, 귤)");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                fruitBag[i][j] = sc.nextInt();
            }
        }

        int total = totalFruit.exchangeF(fruitBag);
        System.out.println("총 과일 개수: " + total);
    }


    static class totalFruit {

        // 자신이 가져가는 바구니의 과일을 교환하지 않는다.
        // 상대방이 가져가는 과일의 바구니와 내가 가져가는 과일의 바구니가 겹치면 안 됨.
        // 배열을 순회하면서 교환가능한 첫 번 째 사람을 선택.

        // 우선 배열을 돌면서 처음에 들고 가는 과일의 총함을 계산하고 변수에 저장
        // 교환할 때 마다 total +!을 해서 total을 구한다.
        public static int exchangeF(int[][] fruitBag) {

            int n = fruitBag.length;
            int[] initialChoice = new int[n];
            int total = 0;

            //step 1: 각 학생의 초기 선택
            for (int i = 0; i < n; i++) {
                int minIndex = 0;
                for (int j = 0; j < 3; j++) {
                    if (fruitBag[i][j] < fruitBag[i][minIndex]){
                        minIndex = j;
                }
            }
                initialChoice[i] = minIndex;
                total += fruitBag[i][minIndex];

            }

            //교환 처리
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int myFruit = fruitBag[i][initialChoice[i]];
                    int theirFruit = fruitBag[j][initialChoice[j]];

                    for (int myChoice = 0; myChoice < 3; myChoice++) {
                        for (int theirChoice = 0; theirChoice < 3; theirChoice++) {
                            if (myChoice == theirChoice) continue;
                            int newMyFruit = fruitBag[i][myChoice];
                            int newTheirFruit = fruitBag[j][theirChoice];

                            if (newMyFruit > myFruit && newTheirFruit > theirFruit){
                                initialChoice[i] = myChoice;
                                initialChoice[j] =theirChoice;
                                total += (newTheirFruit - myFruit) + (newTheirFruit - theirFruit);
                                myFruit = newMyFruit;
                                theirFruit = newTheirFruit;
                            }
                        }
                    }
                }
            }
            return total;
        }
    }

}

