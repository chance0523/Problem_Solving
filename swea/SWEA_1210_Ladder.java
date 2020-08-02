/* https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14ABYKADACFAYh
 * 1210. [S/W 문제해결 기본] 2일차 - Ladder1 [D4]
 */

package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_1210_Ladder {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			// 100x100크기 2차원배열
			int[][] box = new int[100][100];
			// input
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					box[i][j] = sc.nextInt();
				}
			}

			for (int c = 0; c < 100; c++) {
				boolean[][] visited = new boolean[100][100];
				int ans = c;
				int r = 0;
				int curc = c;
				if (box[r][curc] == 1) { // start
					while (true) {
						if (r == 99) { // 끝까지 도달
							if (box[r][curc] == 2) {
								System.out.println("#" + tc + " " + ans);
							}
							break;
						} else {
							if (curc == 0) {
								if (box[r][curc + 1] == 1 && !visited[r][curc + 1]) {
									curc++;
								} else {
									r++;
								}
							} else if (curc == 99) {
								if (box[r][curc - 1] == 1 && !visited[r][curc - 1]) {
									curc--;
								} else {
									r++;
								}
							} else {
								if (box[r][curc - 1] == 1 && !visited[r][curc - 1]) {
									curc--;
								} else if (box[r][curc + 1] == 1 && !visited[r][curc + 1]) {
									curc++;
								} else {
									r++;
								}
							}
							visited[r][curc] = true;
						}
					}
				}
			}
		}
		sc.close();
	}
}
