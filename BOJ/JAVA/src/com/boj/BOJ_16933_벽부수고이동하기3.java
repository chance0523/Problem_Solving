package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16933_벽부수고이동하기3 {
	static BufferedReader br;
	static StringTokenizer str;
	static int n, m, k;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int minans;
	static Queue<Info> q;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		str = new StringTokenizer(br.readLine());
		n = Integer.parseInt(str.nextToken());
		m = Integer.parseInt(str.nextToken());
		k = Integer.parseInt(str.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m][k + 1];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		// 동작
		minans = Integer.MAX_VALUE;

		q = new LinkedList<Info>();
		q.offer(new Info(0, 0, k, 1, 0)); // 0이면 낮, 1이면 밤

		while (!q.isEmpty()) {
			Info info = q.poll();
			int r = info.r;
			int c = info.c;
			int remain = info.remain;
			int cnt = info.cnt;
			int day = info.day;

			if (r == n - 1 && c == m - 1) {
				minans = Math.min(minans, cnt);
				continue;
			}

			for (int dir = 0; dir < 4; dir++) {
				int nr = r + dx[dir];
				int nc = c + dy[dir];
				if (nr != -1 && nc != -1 && nr != n && nc != m) {
					if (day == 0) { // 낮. 벽 부수기 가능
						if (remain == 0) { // 불가
							if (map[nr][nc] == 0 && visited[nr][nc][remain] == false) {
								visited[nr][nc][remain] = true;
								q.offer(new Info(nr, nc, remain, cnt + 1, 1));
							}
						} else { // 가능
							if (map[nr][nc] == 0 && visited[nr][nc][remain] == false) {
								visited[nr][nc][remain] = true;
								q.offer(new Info(nr, nc, remain, cnt + 1, 1));
							} else if (map[nr][nc] == 1 && visited[nr][nc][remain - 1] == false) { // 벽 부술 때
								visited[nr][nc][remain - 1] = true;
								q.offer(new Info(nr, nc, remain - 1, cnt + 1, 1));
							}
						}
					} else { // 밤. 벽 부수기 불가
						if (map[nr][nc] == 0 && visited[nr][nc][remain] == false) {
							visited[nr][nc][remain] = true;
							q.offer(new Info(nr, nc, remain, cnt + 1, 0));
						} else if (map[nr][nc] == 1 && remain!=0 && visited[nr][nc][remain - 1] == false) {
							// 벽이 있고 부술 수도 있지만 밤이라서 못 부숨
							q.offer(new Info(r, c, remain, cnt + 1, 0)); // 지금 서있는 칸을 넘겨야한다.
						}
					}
				}
			}

		}

		if (minans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(minans);
	}

	static class Info {
		int r, c;
		int remain;
		int cnt;
		int day;

		public Info(int r, int c, int remain, int cnt, int day) {
			super();
			this.r = r;
			this.c = c;
			this.remain = remain;
			this.cnt = cnt;
			this.day = day;
		}

	}

}
