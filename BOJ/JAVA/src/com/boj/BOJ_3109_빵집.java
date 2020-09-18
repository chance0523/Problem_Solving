package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109_빵집 {
	static BufferedReader br;
	static StringTokenizer str;
	static int r, c;
	static char[][] map;
	static int ans;
	// 우상, 직진, 우하
	static int[] d = { -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		str = new StringTokenizer(br.readLine());
		r = Integer.parseInt(str.nextToken());
		c = Integer.parseInt(str.nextToken());
		map = new char[r][c];
		for (int i = 0; i < r; i++) {
			String st = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = st.charAt(j);
			}
		}

		// 동작
		for (int i = 0; i < r; i++) { // 맨 왼쪽 열 다 돌기
			func(i, 0);
		}
		System.out.println(ans);
	}

	private static boolean func(int x, int y) {
		if (y == c - 1) {
			ans++;
			return true;
		}
		for (int dir = 0; dir < 3; dir++) {
			int nx = x + d[dir];
			int ny = y + 1; // 열은 무조건 증가
			if (nx >= 0 && nx < r && ny < c) {
				if (map[nx][ny] != 'x') {
					boolean flag = func(nx, ny);
					// 그 길은 막아줌
					map[nx][ny] = 'x';
					if (flag)
						return true;
				}
			}
		}
		return false;
	}
}
