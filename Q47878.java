
// https://level.goorm.io/exam/47878/%EC%82%AC%EC%9D%80%ED%92%88-%EA%B5%90%ED%99%98%ED%95%98%EA%B8%B0/quiz/1
// 사은품 교환하기

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Q47878 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        long[][] arr = new long[T][2];

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
        }

        Arrays.stream(solution(T, arr)).forEach(o -> sb.append(o).append("\n"));
        System.out.println(sb.toString().trim());
    }

    static long[] solution(int T, long[][] arr) {
        long[] answer = new long[T];

        for (int i = 0; i < T; i++) {
            long N = arr[i][0], M = arr[i][1];
            long nCnt = N / 5, mCnt = M / 7;
            long result;
            if (nCnt > mCnt) {
                result = mCnt;
                N -= mCnt * 5;
                M %= 7;
                result += (N + M) / 12;
            } else {
                result = nCnt;
            }
            answer[i] = result;
        }

        return answer;
    }
}