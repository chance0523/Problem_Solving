package com.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2468_안전영역 {
	static int n, m, height;
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer str;
	static int[][] map;
	static int cnt, maxcnt;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {

		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		str = new StringTokenizer(br.readLine());
		n = Integer.parseInt(str.nextToken());
		map = new int[n][n];
		maxcnt = 0;
		for (int i = 0; i < n; i++) {
			str = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}

		// 동작
		for (int i = 0; i < 105; i++) { // 비 높이 범위 대충 넓게
			visited = new boolean[n][n]; // 계속
			cnt = 0; // 초기화를 시켜줘야함
			rain(i); // 비의 양
		}
		
		// 출력
		System.out.println(maxcnt);
	}

	private static void rain(int height) {
		// 잠기게하기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] <= height)
					map[i][j] = -1;
			}
		}

		// land 확인
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != -1 && visited[i][j] == false) { // 잠기지 않았고 방문한 곳이 아닐 때
					visited[i][j] = true; // 방문처리 (이곳이 새로운 땅)
					dfs(i, j); // 거기서 dfs 돌면서 다 방문처리를 해준다.
					cnt++; // 이 땅이 새롭게 개척된 땅이므로 카운트를 늘려준다.
				}
			}
		}

		// 현재 최댓값과 비교
		if (maxcnt < cnt) {
			maxcnt = cnt;
		}
	}

	// 상하좌우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void dfs(int r, int c) {
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dx[dir];
			int nc = c + dy[dir];
			if (nr != -1 && nr != n && nc != -1 && nc != n) {
				if (map[nr][nc] != -1 && visited[nr][nc] == false) { // 갈 수 있는 곳이면
					visited[nr][nc] = true; // 방문처리하고
					dfs(nr, nc); // dfs
				}
			}
		}
	}
}
