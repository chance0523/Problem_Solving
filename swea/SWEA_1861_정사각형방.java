/* 1861. 정사각형 방 D4
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LtJYKDzsDFAXc
 */

package com.swea;

import java.util.Scanner;

public class SWEA_1861_정사각형방 {
	static int n;
	static int ans, minans;
	static int cnt, maxcnt;
	static int r;
	static int c;
	static boolean flag;
	// 상하좌우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			maxcnt = 0;
			minans=1000001;
			// 입력으로 방 채우기
			n = sc.nextInt();

			int[][] rooms = new int[n + 2][n + 2]; // 경계 설정 안 하기 위해 2 더 크게 설정
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					rooms[i][j] = sc.nextInt();
				}
			}
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					r = i;
					c = j;
					cnt = 1;
					ans = rooms[i][j];
					while (true) {
						flag=false;
						for (int d = 0; d < 4; d++) {
							if ((rooms[r][c] + 1) == rooms[r + dx[d]][c + dy[d]]) {
								// 움직일 수 있을 때
								r += dx[d];
								c += dy[d];
								cnt++;
								flag=true;
								break;
							}
						}
						if(flag)
							continue;
						// 움직일 수 있는 곳이 없을 때 여기로 나온다
						if (cnt > maxcnt) {
							maxcnt = cnt;
							minans=ans;
						}
						else if(cnt==maxcnt) 
							if(minans>ans)
								minans=ans;
						
						break;
					}

				}
			}
			System.out.println("#"+tc+" "+minans+" "+maxcnt);

		}
		sc.close();
	}
}
