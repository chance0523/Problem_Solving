package com.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14499_주사위굴리기 {
	static BufferedReader br;
	static StringTokenizer st;
	static BufferedWriter bw;
	static int n, m, x, y, k, order, nx, ny;
	static int[][] map;
	static int[] dice;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		dice = new int[7];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 동작
		// 처음에 모든 면이 0
		// 윗면을 출력

		// 방향. 윗면-아랫면-북-동-남-서 순서로 저장
		int[] dir = new int[] { 1, 6, 2, 3, 5, 4 };
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			order = Integer.parseInt(st.nextToken());
			// 동 서 북 남 순서
			switch (order) {
			case 1: // 동
				if (y + 1 < m) { // 범위
					y++;
					dir = new int[] { dir[5], dir[3], dir[2], dir[0], dir[4], dir[1] };
				}
				else continue;
				break;
			case 2:
				if (y - 1 >= 0) { // 서
					y--;
					dir = new int[] { dir[3], dir[5], dir[2], dir[1], dir[4], dir[0] };
				}
				else continue;
				break;
			case 3:
				if (x - 1 >= 0) { // 북
					x--;
					dir = new int[] { dir[4], dir[2], dir[0], dir[3], dir[1], dir[5] };
				}
				else continue;
				break;
			case 4:
				if (x + 1 < n) { // 남
					x++;
					dir = new int[] { dir[2], dir[4], dir[1], dir[3], dir[0], dir[5] };
				}
				else continue;
				break;
			default:
				break;
			}

			// 이동한 뒤의 동작
			if (map[x][y] == 0) {
				map[x][y] = dice[dir[1]]; // 바닥면
			} else {
				dice[dir[1]] = map[x][y];
				map[x][y]=0;
			}
			
			bw.write(dice[dir[0]]+"\n");
		}
		bw.flush();
		bw.close();
	}

}