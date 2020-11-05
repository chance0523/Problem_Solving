package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2115_벌꿀채취 {
	static BufferedReader br;
	static StringTokenizer st;
	static int t, n, m, c, ans;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 벌통 크기
			m = Integer.parseInt(st.nextToken()); // 벌통 개수
			c = Integer.parseInt(st.nextToken()); // 벌꿀 최대양
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 동작
			
		}
	}
}
