/* 1861. 정사각형 방 D4
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LtJYKDzsDFAXc
 */

package com.swea;

import java.util.Scanner;

public class SWEA_1861_정사각형방_재귀 {
	static int n;
	static int ans, minans;
	static int cnt, maxcnt;
	static int r;
	static int c;
	static boolean flag;
	// 상하좌우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] rooms;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			maxcnt = 0;
			minans = 1000001;
			// 입력으로 방 채우기
			n = sc.nextInt();

			rooms = new int[n + 2][n + 2]; // 경계 설정 안 하기 위해 2 더 크게 설정
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					rooms[i][j] = sc.nextInt();
				}
			}

			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {

					//////////////
					// 재귀로 구현 //
					//////////////
					cnt = 1; // cnt는 1로 계속 초기화 시켜줘야함
					
					dfs(i, j);
					// dfs를 (i,j)에서 다 돌면 (=더 돌곳이 없을 때) cnt를 가지고 나온다.
					
					if (cnt > maxcnt) { // 최대일 경우
						maxcnt = cnt;
						minans = rooms[i][j];
					}

					if (cnt == maxcnt) // 동점 발생
						if (minans > rooms[i][j]) // 현재 숫자가 더 작을 경우 change
							minans = rooms[i][j]; // cnt는 maxcnt랑 같으므로 minans만 바꿔주면 된다.
				}
			}
			System.out.println("#" + tc + " " + minans + " " + maxcnt);

		}
		sc.close();
	}

	static void dfs(int r, int c) {
		for (int i = 0; i < 4; i++) { // 상하좌우 탐색
			if (rooms[r][c] + 1 == rooms[r + dx[i]][c + dy[i]]) { // 갈 곳을 찾았을 경우
				r += dx[i]; // 그곳으로
				c += dy[i]; // 이동
				cnt++; // cnt 늘려주고
				dfs(r, c); // 그곳에서 다시 dfs
				break; // 어차피 한 곳만 1보다 크기 때문에 break (다른 방향은 탐색할 필요 없음)
			}
		}
	}
}
