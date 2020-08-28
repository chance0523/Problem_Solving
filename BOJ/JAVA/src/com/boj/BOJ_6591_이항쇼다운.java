package com.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_6591_이항쇼다운 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer str;
	static long n, k;
	static long ans;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (true) {
			str = new StringTokenizer(br.readLine());
			n = Long.parseLong(str.nextToken());
			k = Long.parseLong(str.nextToken());
			if (n == 0 && k == 0)
				break;
			if (k > n - k)
				k = n - k; // 조합의 특성
			ans = 1;

			// 동작

			for (long i = 1; i <= k; i++) { // 약분을 동시에
				ans *= n--; // 분자
				ans /= i; // 분모
			}

			bw.write(ans + "\n");
			bw.flush();
		}
		bw.close();
	}

}
