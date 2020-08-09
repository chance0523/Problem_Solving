package com.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13458_시험감독 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer str;
	static int n, b, c;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		str = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}
		str = new StringTokenizer(br.readLine());
		b = Integer.parseInt(str.nextToken()); // 총감독관
		c = Integer.parseInt(str.nextToken()); // 부감독관
		long ans = n; // 총 감독관은 한 명 씩 다 있어야한다.

		for (int i = 0; i < n; i++) {
			arr[i] -= b;
		}

		// 이제 각 시험장마다 부감독관 배치
		for (int i = 0; i < n; i++) { // 각 시험장
			if (arr[i] <= 0)
				continue;
			if (arr[i] % c == 0)
				ans += arr[i] / c;
			else
				ans += arr[i] / c + 1;
		}
		System.out.println(ans);
	}
}
