package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1868_파핑파핑지뢰찾기 {
	static BufferedReader br;
	static StringTokenizer st;
	static int t, n, ans, cr, cc, nr, nc;
	static char[][] map;
	static int[][] mine;
	static boolean[][] check;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 12시부터 시계방향
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			ans = 0;
			n = Integer.parseInt(br.readLine());
			map = new char[n][n];
			mine = new int[n][n];
			check = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();
			}

			// 동작
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == '*') { // 지뢰라면
						for (int dir = 0; dir < 8; dir++) { // 그 자리에서 8방향 탐생
							int nx = i + dx[dir];
							int ny = j + dy[dir];
							if (nx >= 0 && ny >= 0 && nx < n && ny < n) // boundary 체크
								mine[nx][ny]++;
						}
						check[i][j] = true;
					}
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (mine[i][j] == 0 && !check[i][j]) {
						ans++;
						check[i][j] = true;
						Queue<int[]> q = new LinkedList<int[]>();
						q.offer(new int[] { i, j });
						while (!q.isEmpty()) {
							cr = q.peek()[0];
							cc = q.peek()[1];
							q.poll();
							for (int dir = 0; dir < 8; dir++) {
								nr = cr + dx[dir];
								nc = cc + dy[dir];
								if (nr >= 0 && nc >= 0 && nr < n && nc < n && map[nr][nc] != '*' && !check[nr][nc]) {
									check[nr][nc] = true;
									if (mine[nr][nc] == 0)
										q.offer(new int[] { nr, nc });
								}
							}
						}
					}
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] != '*' && !check[i][j]) {
						check[i][j] = true;
						ans++;
					}
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}
