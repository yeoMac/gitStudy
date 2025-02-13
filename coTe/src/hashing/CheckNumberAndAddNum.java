package hashing;

public class CheckNumberAndAddNum {

    public static void main(String[] args) {


        System.out.println(answer("aaabc"));
        System.out.println(answer("aabb"));
        System.out.println(answer("abcde"));
        System.out.println(answer("abcdeabc"));
    }

    public static Integer answer(String s) {

        //a b c d e 를 저장함.
        //그리고 파라미터 값을 받으면 각 값들의 갯수를 count함.
        //그리고 count한 값중에 가장 높은 값을 찾는다.
        //그 값만큼 될려면 필요한 갯수를 찾는다.

        //우선 a b c d e가 저장된 맵을 만든다. <String[], Integer> String은 key의 역할을 한다. 여기에 a b c d e를 저장. Integer에는 count 값
        //파라미티값을 for문을 통해서 s.length 를 만큼 순회하면서 맵의 키 값으로 넣고 count
        //for문이 끝났을 때 저장된 맵을 순회하면서 Integer count값이 가장 작은 key를 찾는다.
        //이후에 for문을 돌면서 맵에서 count값이 가장 키 값을 찾음
        //다시 for문을 돌면서 count 값이 큰 값만큼 돼기 위해 필요한 만큼 count값이 어느정도인지 확인 후 반환
        return null;
    }
}
