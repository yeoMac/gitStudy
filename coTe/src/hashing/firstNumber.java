package hashing;

public class firstNumber {

    public static void main(String[] args) {

        String s = "statitsics";
        String[] input = new String[s.length()];

        for (int i = 0; i < s.length(); i++) {
            input[i] = String.valueOf(s.charAt(i));
            System.out.println(input[i]);
        }


    }
}
