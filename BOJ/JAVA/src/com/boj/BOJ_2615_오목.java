package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2615_오목 {
	static BufferedReader br;
	static StringTokenizer str;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[19][19];
		for (int i = 0; i < 19; i++) {
			str = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}

		// 동작
		// 검정 : 1, 흰 : 2
		boolean flag = false;
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (flag)
					return;
				if (map[i][j] == 1) {
					flag = func2(i, j, 1);
				} else if (map[i][j] == 2) {
					flag = func2(i,j,2);
				}
			}
		}
		System.out.println(0);
	}

	static int[] dx = { -1, 1, 0, 0, -1, 1, -1, 1 };
	static int[] dy = { 0, 0, -1, 1, -1, -1, 1, 1 };

	private static boolean func2(int r, int c, int color) {
		// 위로
		boolean flag = false;
		int nr = 0;
		int nc = 0;
		for (int dir = 0; dir < 8; dir++) {
			for (int i = 1; i < 5; i++) {
				nr = r + dx[dir] * i;
				nc = c + dy[dir] * i;
				if (nr >= 0 && nr < 19 && nc >= 0 && nc < 19 && map[nr][nc] == color)
					flag = true;
				else {
					flag = false;
					break;
				}
			}
			if (r + dx[dir] * 5 >= 0 && r + dx[dir] * 5 < 19 && c + dy[dir] * 5 >= 0 && c + dy[dir] * 5 < 19
					&& map[r + dx[dir] * 5][c + dy[dir] * 5] == color)
				flag = false;
			if (r - dx[dir] >= 0 && r - dx[dir] < 19 && c - dy[dir] >= 0 && c - dy[dir] < 19
					&& map[r - dx[dir]][c - dy[dir]] == color)
				flag = false;
			if(flag) {
				switch (dir) {
				case 0: // 위
					print(color,nr,nc);
					break;
				case 1: // 아래
					print(color,r,nc);
					break;
				case 2: // 왼쪽
					print(color,nr,nc);
					break;
				case 3: // 오른쪽
					print(color,nr,c);
					break;
				case 4: // 왼위
					print(color,nr,nc);
					break;
				case 5: // 왼아
					print(color,nr,nc);
					break;
				case 6: // 우위
					print(color,r,c);
					break;
				case 7: // 우아
					print(color,r,c);
					break;
				default:
					break;
				}
				return true;
			}
		}
		return false;
	}
	
	private static void print(int color, int r, int c) {
		System.out.println(color);
		System.out.println((r + 1) + " " + (c + 1));
	}
}
