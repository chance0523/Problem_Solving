package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569_토마토 {
	static int m, n, h;
	static BufferedReader br;
	static StringTokenizer str;
	static int[][][] map;
	static boolean[][][] visited;

	// 위 아래 왼쪽 오른쪽 앞 뒤
	static int[] dx = { 0, 0, 0, 0, 1, -1 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { -1, 1, 0, 0, 0, 0 };

	static Queue<Integer> q;
	static int zeros;

	public static void main(String[] args) throws Exception {

		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		str = new StringTokenizer(br.readLine());
		m = Integer.parseInt(str.nextToken());
		n = Integer.parseInt(str.nextToken());
		h = Integer.parseInt(str.nextToken());
		map = new int[n][m][h];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				str = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					map[j][k][i] = Integer.parseInt(str.nextToken());
				}
			}
		}

		// 동작

		q = new LinkedList<Integer>();

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (map[j][k][i] == 0) {
						zeros++; // 안 익은 것의 갯수
						continue;
					}

					if (map[j][k][i] == 1) {
						q.offer(j); // 큐에
						q.offer(k); // 다
						q.offer(i); // 넣어준다.
					}
				}
			}
		}

		if (zeros == (n * m * h)) { // 모두 0일때
			System.out.println(0);
			return;
		}

		while (!q.isEmpty()) {
			int r = q.poll(); // 차례로 뽑아서 bfs
			int c = q.poll();
			int t = q.poll();
			bfs(r, c, t);
		}

		if (zeros > 0) {
			System.out.println(-1);
			return;
		}

		int ans = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (ans < map[j][k][i])
						ans = map[j][k][i];
				}
			}
		}

		System.out.println(ans - 1);

	}

	static void bfs(int r, int c, int t) {
		for (int dir = 0; dir < 6; dir++) {
			// 위 아래 왼쪽 오른쪽 앞 뒤
			int nr = r + dx[dir];
			int nc = c + dy[dir];
			int nt = t + dz[dir];
			// 범위확인 + 토마토가 들어있는지 확인+ 이미 방문한 곳인지 확인
			if (nr != -1 && nr != n && nc != -1 && nc != m && nt != -1 && nt != h && map[nr][nc][nt] == 0) {
				zeros--; // 안 익은 것의 갯수 줄이기
				map[nr][nc][nt] = map[r][c][t] + 1;
				q.offer(nr);
				q.offer(nc);
				q.offer(nt);
			}

		}
	}
}
