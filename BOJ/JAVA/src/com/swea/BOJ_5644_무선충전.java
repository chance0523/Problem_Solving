package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5644_무선충전 {
	static BufferedReader br;
	static StringTokenizer st;
	static int t, m, a, x, y, c, p, ax, ay, bx, by;
	static int[] moveA;
	static int[] moveB;
	static BC[] bc;
	static int ans;

	private static class BC {
		int x;
		int y;
		int c;
		int p;

		public BC(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}

	public static void main(String[] args) throws Exception {

		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());

			moveA = new int[m + 1];
			moveB = new int[m + 1];

			ax = 0;
			ay = 0;
			bx = 9;
			by = 9;

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < m + 1; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < m + 1; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}

			bc = new BC[a];

			for (int i = 0; i < a; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken()) - 1;
				y = Integer.parseInt(st.nextToken()) - 1;
				c = Integer.parseInt(st.nextToken());
				p = Integer.parseInt(st.nextToken());

				bc[i] = new BC(y, x, c, p);
			}

			// 동작
			ans = 0;
			func();

			System.out.println("#" + tc + " " + ans);
		}
	}

	static int nax, nay, nbx, nby; // next
	static int[] dx = { 0, -1, 0, 1, 0 }; // 그대로, 상우하좌
	static int[] dy = { 0, 0, 1, 0, -1 };

	static boolean[][] result;

	private static void func() {
		for (int t =0; t < m + 1; t++) { // 1초씩 계산
			ax = ax + dx[moveA[t]];
			ay = ay + dy[moveA[t]];
			bx = bx + dx[moveB[t]];
			by = by + dy[moveB[t]];
			// 사용자가 지도 밖으로 이동하는 경우는 없어서 check할 필요 없다.

			result = new boolean[2][a];

			for (int i = 0; i < a; i++) {
				// BC의 범위에 포함되어있는지 확인
				if (getDistA(i))
					result[0][i] = true;
				if (getDistB(i))
					result[1][i] = true;
			}

			int max = 0;
			int value;
			boolean A, B;
			for (int i = 0; i < a; i++) {
				A = result[0][i];
				for (int j = 0; j < a; j++) {
					B = result[1][j];
					value = 0;

					if (i == j && A && B)
						value = bc[i].p;
					else {
						if (A)
							value += bc[i].p;
						if (B)
							value += bc[j].p;
					}
					max = Math.max(max, value);
				}
			}
			ans += max;
		}
	}

	private static boolean getDistA(int i) {
		if ((Math.abs(ax - bc[i].x) + Math.abs(ay - bc[i].y)) <= bc[i].c)
			return true;
		return false;
	}

	private static boolean getDistB(int i) {
		if ((Math.abs(bx - bc[i].x) + Math.abs(by - bc[i].y)) <= bc[i].c)
			return true;
		return false;
	}

}
