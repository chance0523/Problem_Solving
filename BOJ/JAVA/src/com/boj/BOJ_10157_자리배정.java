package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10157_자리배정 {
	static BufferedReader br;
	static StringTokenizer st;
	static int c, r, k;
	static int[][] arr;
	static int[] dx = { -1, 0, 1, 0 }; // 상우하좌 순서
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());
		arr = new int[r][c];

		// 동작
		func(r - 1, 0, k); // 시작 row, col, k
	}

	private static void func(int cr, int cc, int k) {
		if (k > r * c) { // 관객을 배치할 수 없는 경우
			System.out.println(0);
			return;
		}
		int cnt = 1; // 배정될 좌석
		int dir = 0; // 위로 시작
		while (true) {
			if (cnt == k) { // 종료조건
				System.out.println((cc + 1) + " " + (r - cr));
				return;
			}
			arr[cr][cc] = cnt;
			int nr = cr + dx[dir];
			int nc = cc + dy[dir];
			if (nr < 0 || nc < 0 || nr >= r || nc >= c || arr[nr][nc] != 0) { // 방향전환이 필요할때
				dir = (dir + 1) % 4; // 방향전환
				nr = cr + dx[dir]; // 다시 움직임
				nc = cc + dy[dir];
			}

			// 이동
			cr = nr;
			cc = nc;
			cnt++; // 관객 늘려줌
		}
	}
}
