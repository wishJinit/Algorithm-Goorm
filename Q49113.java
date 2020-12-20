
// https://level.goorm.io/exam/49113/%EC%B5%9C%EB%8C%80-%EC%9E%90%EB%A6%AC%EA%B3%B1/quiz/1
// 최대 자리 곱

import java.io.*;

class Q49113 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(br.readLine()));
    }

    static int solution(int N) {
        int max = 1;
        for (int i = N; i >= 1; i--) {
            String s = Integer.toString(i);
            int sum = 1;
            for (char c : s.toCharArray()) {
                sum *= c - '0';
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    static int solution(String N) {
        StringBuilder numberSb = new StringBuilder(N);
        int answer = calculator(N), len = N.length();

        if (len == 1) return Integer.parseInt(N);

        for (int i = len - 1; i >= 1; i--) {
            char c = numberSb.charAt(i);
            if (c != '9') {
                for (int j = i - 1; j >= 0; j--) {
                    char t = numberSb.charAt(j);
                    if (t == '0') {
                        numberSb.setCharAt(j, '9');
                    } else {
                        numberSb.setCharAt(j, (char) (t - 1));
                        break;
                    }
                }
                numberSb.setCharAt(i, '9');
            }

            answer = Math.max(answer, calculator(numberSb.toString()));
        }

        return answer;
    }

    private static int calculator(String s) {
        int sum = Math.max(convertCharToInt(s.charAt(0)), 1);
        for (int j = 1, len = s.length(); j < len; j++) {
            sum *= convertCharToInt(s.charAt(j));
        }
        return sum;
    }

    private static int convertCharToInt(char c) {
        return c - '0';
    }
}