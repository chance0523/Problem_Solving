package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_탈주범검거 {
	static BufferedReader br;
	static StringTokenizer st;
	static int t, n, m, r, c, l, cr, cc, nr, nc;
	static int[][] map;
	static boolean[][] visited;
	static int ans;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken()); // 시간

			map = new int[n][m];
			visited = new boolean[n][m];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ans = 0;
			// 한시간 뒤부터 이동
			if (l == 1) {
				System.out.println("#" + tc + " " + 1);
				continue;
			}

			// 동작
			bfs();

			System.out.println("#" + tc + " " + ans);
		}

	}

	static int[] dx = { -1, 0, 1, 0 }; // 상우하좌
	static int[] dy = { 0, 1, 0, -1 };

	static int[][] pipe = { { 1, 1, 1, 1 }, { 1, 0, 1, 0 }, { 0, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 0 },
			{ 0, 0, 1, 1 }, { 1, 0, 0, 1 } };

	private static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { r, c });
		visited[r][c] = true;

		while (true) {
			l--;
			if (l < 0)
				break;
			int len = q.size();
			for (int k = 0; k < len; k++) { // 이번 한 시간 동안 갈 수 있는 곳 담는다 
				cr = q.peek()[0];
				cc = q.peek()[1];
				q.poll();
				ans++;
				for (int dir = 0; dir < 4; dir++) {
					nr = cr + dx[dir];
					nc = cc + dy[dir];
					int p = map[cr][cc] - 1;
					if (nr >= 0 && nc >= 0 && nr < n && nc < m && pipe[p][dir] == 1) { // 파이프가 뚫려있는지
						if (map[nr][nc] != 0 && !visited[nr][nc]) { // 이동 할 수 있는지 (파이프가 있어야)
							int np = map[nr][nc] - 1; // 가려고 하는 곳에 있는 파이프

							if (pipe[np][(dir + 2) % 4] == 1) { // 이쪽 파이프도 뚫려 있는지 확인(상<->하, 좌<->우)
								q.add(new int[] { nr, nc });
								visited[nr][nc] = true;
							}
						}
					}
				}
			}
		}
	}
}
