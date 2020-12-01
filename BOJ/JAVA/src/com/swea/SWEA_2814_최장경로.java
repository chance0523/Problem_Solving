package com.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2814_최장경로 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int t, n, m, x, y, ans;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			ans = 1; // 최장길이
			map = new int[n][n];
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken()) - 1;
				y = Integer.parseInt(st.nextToken()) - 1;
				map[x][y] = 1; // 연결 표시
				map[y][x] = 1;
			}

			// 동작
			for (int i = 0; i < n; i++) {
				visited = new boolean[n];
				visited[i] = true; // 시작점 체크
				func(i, 1); // 이 정점에서의 최장길이 구해줌
				visited[i] = false;
			}

			// 출력
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void func(int p, int cnt) {
		ans = Math.max(ans, cnt);
		for (int i = 0; i < n; i++) {
			if (!visited[i] && map[p][i] == 1) {
				visited[i] = true;
				func(i, cnt + 1);
				visited[i] = false;
			}
		}
	}
}
