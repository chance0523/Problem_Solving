package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
	static BufferedReader br;
	static StringTokenizer str;
	static int R, C;
	static int[][] map;
	static int ans;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		str = new StringTokenizer(br.readLine());
		R = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			String st = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = st.charAt(j) - 'A';
			}
		}

		// 동작
		boolean[] visited = new boolean[26];
		visited[map[0][0]]=true;
		dfs(0, 0, 1, visited);
		System.out.println(ans);
	}

	private static void dfs(int r, int c, int cnt, boolean[] visited) {
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dx[dir];
			int nc = c + dy[dir];
			if (nr >= 0 && nc >= 0 && nr < R && nc < C) {
				if (visited[map[nr][nc]] == false) { // 처음 방문한 알파벳
					visited[map[nr][nc]] = true; // 방문처리
					dfs(nr, nc, cnt + 1, visited);
					visited[map[nr][nc]] = false; // 다시 뒤로 가서 확인
				}
			}
		}
		ans=Math.max(ans, cnt);
	}
}
