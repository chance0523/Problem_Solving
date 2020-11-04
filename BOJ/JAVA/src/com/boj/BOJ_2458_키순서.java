package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2458_키순서 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n, m, a, b;
	static int[][] d;
	static int INF = 1000000;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// for 플로이드-와샬
				if (i == j)
					continue;
				d[i][j] = INF;
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			// a가 b보다 키가 작다.
			a = Integer.parseInt(st.nextToken()) - 1;
			b = Integer.parseInt(st.nextToken()) - 1;
			d[a][b] = 1;
		}

		// 플로이드-와샬
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (d[i][k] + d[k][j] < d[i][j])
						d[i][j] = d[i][k] + d[k][j];
				}
			}
		}

		int ans = 0;

		for (int i = 0; i < n; i++) {
			boolean flag = true;
			for (int j = 0; j < n; j++) {
				if (d[i][j] == INF && d[j][i] == INF) {
					// 서로 갈 수 없으면 키를 비교 할 수 없음
					flag = false;
					break;
				}
			}
			if (!flag)
				continue;
			else
				ans++;
		}
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(d[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println(ans);
	}
}
