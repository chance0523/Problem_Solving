/* 1954. 달팽이 숫자 [D2]
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PobmqAPoDFAUq
 */

package com.swea;

import java.util.Scanner;

public class SWEA_1954_Snail {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 우 하 좌 상
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			
			if (n == 1) { // 1일때 예외처리
				System.out.println("#" + tc);
				System.out.println(1);
				continue;
			}
			
			int[][] box = new int[n][n];
			int curr = 0, curc = 0;
			int dir = 0;
			for (int num = 1; num <= (n * n); num++) {
				box[curr][curc] = num;
				// 끝에 닿으면 방향 전환
				if (curr == 0 && curc == (n - 1))
					dir += 1;
				if (curr == (n - 1) && curc == (n - 1))
					dir += 1;
				if (curr == (n - 1) && curc == 0)
					dir += 1;
				curr += dx[dir];
				curc += dy[dir];
				
				if (box[curr][curc] > 0) { // 무언가 들어가있으면 다시 back하고 방향전환
					// back
					curr -= dx[dir];
					curc -= dy[dir];
					// 방향전환
					if (dir == 3)
						dir = 0;
					else
						dir += 1;
					// 전환한 곳으로 가기
					curr += dx[dir];
					curc += dy[dir];
				}
			}
			// 출력
			System.out.println("#" + tc);
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					System.out.print(box[j][j2] + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
}
