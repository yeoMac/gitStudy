package hashing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class VoteProgram {

    //전처리 어떻게 할 건지
    //전처리 후에 누가 투표를 많이 받았는지 어떻게 구별할 건지
    public static void main(String[] args) {
        System.out.println(VoteProgram.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"},2));



    }

    private static String solution(String[] vote, int k) {

        String answer = "";
        HashMap<String, HashSet<String>> votes = new HashMap<>();
        HashMap<String, Integer> voteCount = new HashMap<>();
        HashMap<String, Integer> present = new HashMap<>();

        for (String s : vote) {
            String a = s.split(" ")[0];
            String b = s.split(" ")[1];

            votes.putIfAbsent(a, new HashSet<String>());
            votes.get(a).add(b);
            voteCount.put(b, voteCount.getOrDefault(b, 0) + 1);
        }

        int max = Integer.MIN_VALUE;

        for (String s : votes.keySet()) {
            int cnt = 0;
            for (String x : votes.get(s)) {
                if (voteCount.get(x) > k) {
                    cnt++;
                }
            }
            present.put(s, cnt);
            max = Math.max(max, cnt);
        }
        ArrayList<String> tmp = new ArrayList<>();
        for (String s : present.keySet()) {
            if (present.get(s) == max) {
                tmp.add(s);
            }
        }
        tmp.sort((a, b) -> a.compareTo(b));
        answer = tmp.get(0);


        return answer;
    }


}
