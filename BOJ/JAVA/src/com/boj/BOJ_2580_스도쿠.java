package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2580_스도쿠 {
	static BufferedReader br;
	static StringTokenizer str;
	static int n;
	static int[][] map;
	static boolean[][] row;
	static boolean[][] col;
	static boolean[][] square;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		row = new boolean[9][10];
		col = new boolean[9][10];
		square = new boolean[9][10];
		for (int i = 0; i < 9; i++) {
			str = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
				if (map[i][j] != 0) { // 1~9 체크
					row[i][map[i][j]] = true;
					col[j][map[i][j]] = true;
					square[(i / 3) * 3 + (j / 3)][map[i][j]] = true;
				}
			}
		}

		// 동작
		func(0);

	}

	private static void func(int cnt) {
		// 백트래킹
		int r = cnt / 9;
		int c = cnt % 9;
		if (cnt == 81) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0); // 이걸 해주지 않으면 여러 개 출력 (all 0인 케이스)
//			return;
		}
		if (map[r][c] == 0) {
			for (int i = 1; i <= 9; i++) { // 1부터 9까지 시도해볼것이다
				if (row[r][i] == false && col[c][i] == false && square[(r / 3) * 3 + (c / 3)][i] == false) { // 체크
					row[r][i] = true;
					col[c][i] = true;
					square[(r / 3) * 3 + c / 3][i] = true;
					map[r][c] = i; // 값 채워줌
					// 백트래킹
					func(cnt + 1); // 다음 좌표
					map[r][c] = 0;
					row[r][i] = false;
					col[c][i] = false;
					square[(r / 3) * 3 + c / 3][i] = false;
				}
			}
		} else
			func(cnt + 1);
	}
}
