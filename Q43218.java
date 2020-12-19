
// https://level.goorm.io/exam/43218/%EC%8A%A4%ED%83%9D-stack/quiz/1
// 스택(Stack)

import java.io.*;

class Q43218 {
    final static String OVER_FLOW = "overflow";
    final static String UNDER_FLOW = "underflow";

    static class Stack {
        final int SIZE = 10;
        int[] arr = new int[SIZE];
        int idx = -1;

        boolean push(int element) {
            if (idx + 1 >= SIZE) {
                idx = SIZE - 1;
                return false;
            } else {
                arr[++idx] = element;
                return true;
            }
        }

        boolean pop() {
            idx = Math.max(idx, -1);
            return idx-- != -1;
        }

        String getElements() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= idx; i++) {
                sb.append(arr[i]).append(" ");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());
        Stack stack = new Stack();

        while (cnt-- > 0) {
            int command = Integer.parseInt(br.readLine());
            if (command == 0) {
                int element = Integer.parseInt(br.readLine());
                boolean result = stack.push(element);
                if (!result) sb.append(appendLine(sb.length())).append(OVER_FLOW);
            } else if (command == 1) {
                if (!stack.pop()) sb.append(appendLine(sb.length())).append(UNDER_FLOW);
            } else {
                break;
            }
        }

        String result = stack.getElements();
        if (result.length() > 0) sb.append(appendLine(sb.length())).append(result);

        System.out.println(sb.toString());
    }

    private static String appendLine(int len) {
        return (len > 0 ? "\n" : "");
    }
}