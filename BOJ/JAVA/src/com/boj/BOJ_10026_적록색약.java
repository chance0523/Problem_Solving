package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10026_적록색약 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static char[][] map;
	static int[][] see;
	static boolean[][] visited;
	static int ans;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}

		// 동작
		// 1. 일반인이 본 구역 수
		see = new int[n][n];
		visited = new boolean[n][n];
		ans = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (see[i][j] == 0 && !visited[i][j]) {
					dfs(i, j);
					ans++;
				}
			}
		}
		System.out.print(ans - 1 + " "); // 바로 출력

		// 2. 적록색약이 본 구역 수
		// 다른 것은 일반인과 동일하고 초록을 빨강으로 다 바꿔준다.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'G')
					map[i][j] = 'R';
			}
		}
		see = new int[n][n];
		visited = new boolean[n][n];
		ans = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (see[i][j] == 0 && !visited[i][j]) {
					dfs(i, j);
					ans++;
				}
			}
		}
		System.out.println(ans - 1);
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void dfs(int r, int c) {
		visited[r][c] = true;
		see[r][c] = ans;
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dx[dir];
			int nc = c + dy[dir];
			if (nr >= 0 && nc >= 0 && nr < n && nc < n && !visited[nr][nc]) { // 범위체크
				if (map[nr][nc] == map[r][c]) { // 같은 색이라면
					dfs(nr, nc); // 그곳으로 가서 dfs
				}
			}
		}
	}
}
