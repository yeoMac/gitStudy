package datastructure;

import java.util.Stack;

public class DecompressedString {

    public static void main(String[] args) {
        String s = "3(a2(b))ef";
        String result = DecompressedS(s);
        System.out.println(result);
    }

    private static String DecompressedS(String s) {
        Stack<String> stack = new Stack<>();
        String answer = "";

        for (char c : s.toCharArray()) {
            if (c==')') {
                String a = "";
                while (!stack.isEmpty() && stack.peek().charAt(0)=='(') {
                    String pop = stack.pop();
                    a = a + pop;

                }
            }
            stack.push(String.valueOf(c));
        }
        return null;
    }

}
