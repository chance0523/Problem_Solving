package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465_스티커 {
	static BufferedReader br;
	static StringTokenizer st;
	static int t, n;
	static int[][] map;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[2][n + 1];
			dp = new int[2][n + 1];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 동작
			// 초기화
			dp[0][1] = map[0][1];
			dp[1][1] = map[1][1];

			for (int i = 2; i <= n; i++) {
				dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + map[0][i];
				dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + map[1][i];
			}

			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}

	}
}
