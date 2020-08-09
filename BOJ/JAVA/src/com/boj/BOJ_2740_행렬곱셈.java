package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2740_행렬곱셈 {
	static int n, m, k;
	static BufferedReader br;
	static StringTokenizer str;

	public static void main(String[] args) throws Exception {

		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		str = new StringTokenizer(br.readLine());

		// a 행렬
		n = Integer.parseInt(str.nextToken());
		m = Integer.parseInt(str.nextToken());
		int[][] a = new int[n][m];
		for (int i = 0; i < n; i++) {
			str = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(str.nextToken());
			}
		}

		// b 행렬
		str = new StringTokenizer(br.readLine());
		m = Integer.parseInt(str.nextToken());
		k = Integer.parseInt(str.nextToken());
		int[][] b = new int[m][k];
		for (int i = 0; i < m; i++) {
			str = new StringTokenizer(br.readLine());
			for (int j = 0; j < k; j++) {
				b[i][j] = Integer.parseInt(str.nextToken());
			}
		}

		// 동작
		int[][] result = new int[n][k];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {
				for (int j2 = 0; j2 < m; j2++) {
					result[i][j] += a[i][j2] * b[j2][j];
				}
			}
		}
		
		// 출력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
}
