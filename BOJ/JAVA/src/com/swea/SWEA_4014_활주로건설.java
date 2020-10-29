package com.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_4014_활주로건설 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int t, n, x, ans;
	static int[][] map;
	static int[][] map2;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {

			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			map2 = new int[n][n];
			x = Integer.parseInt(st.nextToken()); // 경사로의 길이
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					map2[j][i] = map[i][j]; // 세로 체크
				}
			}

			ans = 0;
			// 동작
			solve(map); // 가로 맵
			solve(map2); // 세로 맵

			bw.write("#"+tc+" "+ans + "\n");
		}
		bw.flush();
		bw.close();
	}

	private static void solve(int[][] map) {
		for (int i = 0; i < n; i++) {
			boolean flag = true;
			int l = 1;
			for (int j = 0; j < n - 1; j++) {
				if (map[i][j] == map[i][j + 1])
					l++;
				// 높은 곳으로
				else if (map[i][j] == map[i][j + 1] - 1) {
					if (l >= x)
						l = 1;
					else {
						flag = false;
						break;
					}
					// 높은 곳으로
				} else if (map[i][j] == map[i][j + 1] + 1) {
					if (j + 1 + x > n) {
						flag = false;
						break;
					}
					for (int k = j + 1; k < j + 1 + x; k++) {
						if (map[i][k] != map[i][j + 1]) {
							flag = false;
							break;
						}
					}
					if (!flag)
						break;
					j += (x - 1);
					l = 0;
				} else {
					flag = false;
					break;
				}
			}
			if (!flag)
				continue;
			ans++;
		}
	}
}
