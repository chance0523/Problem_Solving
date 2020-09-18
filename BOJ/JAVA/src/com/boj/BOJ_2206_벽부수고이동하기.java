package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_벽부수고이동하기 {
	static BufferedReader br;
	static StringTokenizer str;
	static int n, m;
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
		map = new int[n][m];
		visited = new boolean[n][m][2];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		// 동작
		minans = Integer.MAX_VALUE;

		q = new LinkedList<Info>();
		q.offer(new Info(0, 0, 0, 1));

		while (!q.isEmpty()) {
			Info info = q.poll();
			int r = info.r;
			int c = info.c;
			int cnt = info.cnt;
			int flag = info.flag;

			if (r == n - 1 && c == m - 1) {
				minans = Math.min(minans, cnt);
				continue;
			}

			for (int dir = 0; dir < 4; dir++) {
				int nr = r + dx[dir];
				int nc = c + dy[dir];
				if (nr != -1 && nc != -1 && nr != n && nc != m) {
					if (flag == 1) { // 벽을 부수고 난뒤
						if (map[nr][nc] == 0 && visited[nr][nc][flag] == false) {
							visited[nr][nc][flag] = true;
							q.offer(new Info(nr, nc, flag, cnt + 1));
						}
					} else { // 아직 안 부수었을 때
						if (map[nr][nc] == 0 && visited[nr][nc][flag] == false) {
							visited[nr][nc][flag] = true;
							q.offer(new Info(nr, nc, flag, cnt + 1));
						} else if (map[nr][nc] == 1 && visited[nr][nc][flag + 1] == false) {
							visited[nr][nc][flag + 1] = true;
							q.offer(new Info(nr, nc, flag + 1, cnt + 1));
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
		int flag;
		int cnt;

		public Info(int r, int c, int flag, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.flag = flag;
			this.cnt = cnt;
		}

	}

}
