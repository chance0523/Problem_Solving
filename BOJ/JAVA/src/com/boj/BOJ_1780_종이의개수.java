package com.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1780_종이의개수 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer str;
	static int n;
	static int[][] map;
	static int[] ans;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			str = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}

		// 동작
		ans = new int[3]; // -1 0 1
		func(0, 0, n);
		for (int i = 0; i < 3; i++) {
			System.out.println(ans[i]);
		}

	}

	private static void func(int r, int c, int w) {
		if (same(r, c, w)) { // 같은 수로만 되어있으면
			ans[map[r][c] + 1]++; // 해당 위치 카운트
			return;
		}

		int nw = w / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				func(r + i * nw, c + j * nw, nw);
			}
		}

	}

	private static boolean same(int r, int c, int w) {
		for (int i = r; i < r + w; i++) { // 같은 수로만 되어있는지
			for (int j = c; j < c + w; j++) {
				if (map[i][j] != map[r][c])
					return false;
			}
		}
		return true;
	}
}
