package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1992_쿼드트리 {
	static BufferedReader br;
	static int n;
	static int[][] map;
	static String ans;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			String st = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = st.charAt(j) - '0';
			}
		}

		// 동작
		System.out.println(dq(n, 0, 0, n, n));
	}

	private static String dq(int n, int x1, int y1, int x2, int y2) { // x1,y1 ~ x2,y2
		if (n == 1)
			return Integer.toString(map[x1][y1]);
		int d = n / 2;

		String d1 = dq(d, x1, y1, x1 + d, y1 + d); // 왼상단
		String d2 = dq(d, x1, y1 + d, x1 + d, y1 + n); // 우상단
		String d3 = dq(d, x1 + d, y1, x1 + n, y1 + d); // 왼하단
		String d4 = dq(d, x1 + d, y1 + d, x1 + n, y1 + n); // 우하단

		if (d1.length() == 1 && d1.equals(d2) && d2.equals(d3) && d3.equals(d4)) // 모두 같으면 0 또는 1
			return d1;
		return "(" + d1 + d2 + d3 + d4 + ")";

	}
}
