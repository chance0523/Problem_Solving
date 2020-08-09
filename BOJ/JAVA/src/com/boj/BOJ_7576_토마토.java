package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {

	static int m, n;
	static int[][] map;
	// 상하좌우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int zeros;
	static int rs, cs;
	static Queue<Integer> q;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		str = new StringTokenizer(br.readLine());
		m = Integer.parseInt(str.nextToken());
		n = Integer.parseInt(str.nextToken());
		map = new int[n][m];
		q = new LinkedList<Integer>();
		ans = 0;
		zeros = 0;
		// 입력
		for (int i = 0; i < n; i++) {
			str = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
				if (map[i][j] == 0)
					zeros++; // 익어야하는 토마토 갯수
				if (map[i][j] == 1) {
					q.offer(i);
					q.offer(j);
				}
			}
		}

		// 동작
		// 저장될 때부터 모든 토마토가 익어있는 상태 : 0
		if (zeros == 0) {
			System.out.println(0);
			return;
		}

		// 그 외 경우
		while (!q.isEmpty()) {
			rs = q.poll();
			cs = q.poll();
			bfs(rs, cs);
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] > ans)
					ans = map[i][j];
			}
		}
		if (zeros > 0) {
			System.out.println(-1);
			return;
		} else {
			System.out.println(ans - 1); // 처음 가는 곳이 이틀째이므로 최종적으로 -1을 해준다.
			return;
		}
	}

	static void bfs(int rs, int cs) { // 탐색
		for (int dir = 0; dir < 4; dir++) {
			if (rs + dx[dir] != -1 && rs + dx[dir] != n && cs + dy[dir] != -1 && cs + dy[dir] != m) {
				if (map[rs + dx[dir]][cs + dy[dir]] == 0) {
					map[rs + dx[dir]][cs + dy[dir]] = map[rs][cs] + 1; // 익게한다. (다음날임을 표시)
					zeros--; // 덜 익은 것 갯수 감소
					q.offer(rs + dx[dir]); // 큐에
					q.offer(cs + dy[dir]); // 넣어준다.
				}
			}

		}
	}
}
