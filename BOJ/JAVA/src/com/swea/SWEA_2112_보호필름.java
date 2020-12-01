package com.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2112_보호필름 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int t, d, w, k, ans;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			map = new int[d][w];
			ans = Integer.MAX_VALUE;
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 동작
			dfs(0, 0);
			System.out.println("#"+tc+" "+ans);
		}
	}

	private static void dfs(int p, int cnt) {
		if (cnt >= ans) // 가지치기
			return;
		if (p == d) {
			for (int i = 0; i < w; i++) {
				boolean flag = false;
				int same = 1;
				for (int j = 0; j < d - 1; j++) {
					if (map[j][i] == map[j + 1][i]) {
						same++;
					} else {
						same = 1;
					}

					if (same >= k) {
						flag = true;
						break;
					}
				}
				if (!flag)
					return;
			}
			ans = Math.min(ans, cnt);
			return;
		}

		int[] temp = map[p].clone();

		// 아무것도 안하기
		dfs(p + 1, cnt);

		// A
		Arrays.fill(map[p], 0);
		dfs(p + 1, cnt + 1);

		// B
		Arrays.fill(map[p], 1);
		dfs(p + 1, cnt + 1);

		map[p] = temp;

	}
}
