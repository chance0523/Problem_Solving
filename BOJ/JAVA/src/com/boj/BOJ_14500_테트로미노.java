package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n, m;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 동작
		// 5가지 모양 (회전+대칭)
		// 1
		int ans = 0;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m - 3; j++) {
				cnt = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i][j + 3];
				ans = Math.max(cnt, ans);
			}
		}

		// 1-1
		for (int i = 0; i < n - 3; i++) {
			for (int j = 0; j < m; j++) {
				cnt = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 3][j];
				ans = Math.max(cnt, ans);
			}
		}

		// 2
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < m - 1; j++) {
				cnt = map[i][j] + map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1];
				ans = Math.max(cnt, ans);
			}
		}

		// 3
		for (int i = 0; i < n - 2; i++) {
			for (int j = 0; j < m - 1; j++) {
				cnt = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 2][j + 1];
				ans = Math.max(cnt, ans);
			}
		}
		// 3-1
		for (int i = 0; i < n - 2; i++) {
			for (int j = 0; j < m - 1; j++) {
				cnt = map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1] + map[i + 2][j];
				ans = Math.max(cnt, ans);
			}
		}
		// 3-2
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < m - 2; j++) {
				cnt = map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2];
				ans = Math.max(cnt, ans);
			}
		}
		// 3-3
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < m - 2; j++) {
				cnt = map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2] + map[i][j + 2];
				ans = Math.max(cnt, ans);
			}
		}
		// 3-4
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < m - 2; j++) {
				cnt = map[i][j] + map[i + 1][j] + map[i][j + 1] + map[i][j + 2];
				ans = Math.max(cnt, ans);
			}
		}
		// 3-5
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < m - 2; j++) {
				cnt = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 2];
				ans = Math.max(cnt, ans);
			}
		}
		// 3-6
		for (int i = 0; i < n - 2; i++) {
			for (int j = 0; j < m - 1; j++) {
				cnt = map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1];
				ans = Math.max(cnt, ans);
			}
		}
		// 3-7
		for (int i = 0; i < n - 2; i++) {
			for (int j = 0; j < m - 1; j++) {
				cnt = map[i][j] + map[i][j + 1] + map[i + 1][j] + map[i + 2][j];
				ans = Math.max(cnt, ans);
			}
		}

		// 4
		for (int i = 0; i < n - 2; i++) {
			for (int j = 0; j < m - 1; j++) {
				cnt = map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j + 1];
				ans = Math.max(cnt, ans);
			}
		}
		// 4-1
		for (int i = 0; i < n - 2; i++) {
			for (int j = 0; j < m - 1; j++) {
				cnt = map[i][j + 1] + map[i + 1][j + 1] + map[i + 1][j] + map[i + 2][j];
				ans = Math.max(cnt, ans);
			}
		}
		// 4-2
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < m - 2; j++) {
				cnt = map[i + 1][j] + map[i + 1][j + 1] + map[i][j + 1] + map[i][j + 2];
				ans = Math.max(cnt, ans);
			}
		}
		// 4-3
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < m - 2; j++) {
				cnt = map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 1][j + 2];
				ans = Math.max(cnt, ans);
			}
		}

		// 5
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < m - 2; j++) {
				cnt = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 1];
				ans = Math.max(cnt, ans);
			}
		}
		// 5-1
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < m - 2; j++) {
				cnt = map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2] + map[i][j + 1];
				ans = Math.max(cnt, ans);
			}
		}
		// 5-2
		for (int i = 0; i < n - 2; i++) {
			for (int j = 0; j < m - 1; j++) {
				cnt = map[i + 1][j] + map[i + 1][j + 1] + map[i][j + 1] + map[i + 2][j + 1];
				ans = Math.max(cnt, ans);
			}
		}
		// 5-3
		for (int i = 0; i < n - 2; i++) {
			for (int j = 0; j < m - 1; j++) {
				cnt = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 1][j + 1];
				ans = Math.max(cnt, ans);
			}
		}

		System.out.println(ans);
	}
}
