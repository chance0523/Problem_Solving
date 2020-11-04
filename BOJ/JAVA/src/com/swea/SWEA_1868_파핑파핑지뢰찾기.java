package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1868_파핑파핑지뢰찾기 {
	static BufferedReader br;
	static StringTokenizer st;
	static int t, n, ans;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			ans = 0;
			n = Integer.parseInt(br.readLine());
			map = new char[n][n];
			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();
			}
		}
		
		// 동작
	}
}
