package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2105_디저트카페 {
	static BufferedReader br;
	static StringTokenizer st;
	static int t, n, ans;
	static int[][] map;
	static int[] dx = { 1, 1, -1, -1 }; // 우하, 좌하, 좌상, 우상
	static int[] dy = { 1, -1, -1, 1 };
	static int[] kind;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		visited = new boolean[20][20];
		kind = new int[101];
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = 0;
			// 동작
			for (int i = 0; i < n - 2; i++) { // n은 4이상
				for (int j = 0; j < n - 1; j++) {
					if(i==0 && j==0) continue;
					initVisited(); // visited 배열 초기화
					initKind(); // 종류 배열 초기화
					go1(i, j, visited, kind, i, j); // 이 방향에서 탐색. 무조건 오른쪽 아래 방향으로 시작

				}
			}
			if (ans == 0)
				ans = -1;
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void go1(int cr, int cc, boolean[][] visited, int[] kind, int sr, int sc) { // 우하
//		System.out.println(cr+" "+cc);
		// 진행 방향 그대로 가보기
		int nr = cr + dx[0];
		int nc = cc + dy[0];
		if (isIn(nr, nc) && !visited[nr][nc] && kind[map[nr][nc]] == 0) {
			// 격자 밖으로 벗어나지 않았고, 처음 방문하며, 처음 보는 종류의 디저트일때
			kind[map[nr][nc]] = 1;
			visited[nr][nc] = true;
			go1(nr, nc, visited, kind, sr, sc); // 한 칸 더 가보기
			visited[nr][nc] = false; // 백트래킹
			kind[map[nr][nc]] = 0;
		}

		// 왼쪽 아래로 꺾어서 보내보기
		nr = cr + dx[1];
		nc = cc + dy[1];
		if (isIn(nr, nc) && !visited[nr][nc] && kind[map[nr][nc]] == 0) {
			// 격자 밖으로 벗어나지 않았고, 처음 방문하며, 처음 보는 종류의 디저트일때
			kind[map[nr][nc]] = 1;
			visited[nr][nc] = true;
			go2(nr, nc, visited, kind, sr, sc); // 한 칸 더 가보기
			visited[nr][nc] = false; // 백트래킹
			kind[map[nr][nc]] = 0;
		}

	}

	private static void go2(int cr, int cc, boolean[][] visited, int[] kind, int sr, int sc) { // 좌하
		// 진행 방향 그대로 가보기
		int nr = cr + dx[1];
		int nc = cc + dy[1];
		if (isIn(nr, nc) && !visited[nr][nc] && kind[map[nr][nc]] == 0) {
			// 격자 밖으로 벗어나지 않았고, 처음 방문하며, 처음 보는 종류의 디저트일때
			kind[map[nr][nc]] = 1;
			visited[nr][nc] = true;
			go2(nr, nc, visited, kind, sr, sc); // 한 칸 더 가보기
			visited[nr][nc] = false; // 백트래킹
			kind[map[nr][nc]] = 0;
		}

		// 왼쪽 위로 꺾어서 보내보기
		nr = cr + dx[2];
		nc = cc + dy[2];
		if (isIn(nr, nc) && !visited[nr][nc] && kind[map[nr][nc]] == 0) {
			// 격자 밖으로 벗어나지 않았고, 처음 방문하며, 처음 보는 종류의 디저트일때
			kind[map[nr][nc]] = 1;
			visited[nr][nc] = true;
			go3(nr, nc, visited, kind, sr, sc); // 한 칸 더 가보기
			visited[nr][nc] = false; // 백트래킹
			kind[map[nr][nc]] = 0;
		}
	}

	private static void go3(int cr, int cc, boolean[][] visited, int[] kind, int sr, int sc) {
		// 진행 방향 그대로 가보기
		int nr = cr + dx[2];
		int nc = cc + dy[2];
		if (isIn(nr, nc) && !visited[nr][nc] && kind[map[nr][nc]] == 0) {
			// 격자 밖으로 벗어나지 않았고, 처음 방문하며, 처음 보는 종류의 디저트일때
			kind[map[nr][nc]] = 1;
			visited[nr][nc] = true;
			go3(nr, nc, visited, kind, sr, sc); // 한 칸 더 가보기
			visited[nr][nc] = false; // 백트래킹
			kind[map[nr][nc]] = 0;
		}

		// 오른쪽 위로 꺾어서 보내보기
		nr = cr + dx[3];
		nc = cc + dy[3];
		if (isIn(nr, nc) && !visited[nr][nc] && kind[map[nr][nc]] == 0) {
			// 격자 밖으로 벗어나지 않았고, 처음 방문하며, 처음 보는 종류의 디저트일때
			kind[map[nr][nc]] = 1;
			visited[nr][nc] = true;
			go4(nr, nc, visited, kind, sr, sc); // 한 칸 더 가보기
			visited[nr][nc] = false; // 백트래킹
			kind[map[nr][nc]] = 0;
		}
	}

	private static void go4(int cr, int cc, boolean[][] visited, int[] kind, int sr, int sc) {

		int cnt = 0;

		if (cr == sr && cc == sc) { // 시작지점으로 돌아왔을 때 최종계산
			for (int i = 0; i < 101; i++) {
				if (kind[i] == 1)
					cnt++;
			}
			ans = Math.max(ans, cnt);
			return;
		}

		// 진행 방향 그대로 가보기
		int nr = cr + dx[3];
		int nc = cc + dy[3];

		if (isIn(nr, nc) && !visited[nr][nc] && kind[map[nr][nc]] == 0) {
			// 격자 밖으로 벗어나지 않았고, 처음 방문하며, 처음 보는 종류의 디저트일때
			kind[map[nr][nc]] = 1;
			visited[nr][nc] = true;
			go4(nr, nc, visited, kind, sr, sc); // 한 칸 더 가보기
			visited[nr][nc] = false; // 백트래킹
			kind[map[nr][nc]] = 0;
		}
	}

	private static boolean isIn(int r, int c) { // 격자 밖으로 넘어가지 않는지 체크
		if (r >= 0 && c >= 0 && r < n && c < n)
			return true;
		return false;
	}

	private static void initVisited() {
		for (int i = 0; i < 20; i++) {
			Arrays.fill(visited[i], false);
		}
	}

	private static void initKind() {
		for (int i = 0; i < 101; i++) {
			Arrays.fill(kind, 0);
		}
	}
}
