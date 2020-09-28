package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2823_유턴싫어 {
	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		char[][] map = new char[r][c];
		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// 동작
		int sr = 0, sc = 0;
		// 시간이 넉넉하니 다 돌면서 마지막 빈칸을 찾는다.
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == '.') {
					sr = i;
					sc = j;
				}
			}
		}
		int curD;
	}
}
