package com.boj;

import java.util.Scanner;

public class BOJ_1074_Z {
	static int n, r, c;
	static int[][] map;

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();

		int np = (int) Math.pow(2, n);

		// 동작
		System.out.println(dq(np, r, c));
		sc.close();
	}

	static int cnt;

	private static int dq(int n, int r, int c) {
		if (n == 2) { // 2x2 사각형
			if (r % n == 0 && c % n == 0) // 왼상단
				return cnt;
			else if (r % n == 0 && c % n == 1) // 우상단
				return cnt + 1;
			else if (r % n == 1 && c % n == 0) // 왼하단
				return cnt + 2;
			else // 우하단
				return cnt + 3;
		} else { // 그외
			if ((r % n < (n / 2)) && (c % n < (n / 2))) { // 왼상단
				return dq(n / 2, r, c);
			} else if (r % n < (n / 2) && (c % n > (n / 2 - 1))) { // 우상단
				cnt += ((n / 2) * (n / 2)) * 1; // 왼상단의 숫자 카운트
				return dq(n / 2, r, c);
			} else if ((r % n > (n / 2 - 1)) && (c % n < (n / 2))) { // 왼하단
				cnt += ((n / 2) * (n / 2)) * 2; // 왼상단 + 우상단의 숫자 카운트
				return dq(n / 2, r, c);
			} else { // 우하단
				cnt += ((n / 2) * (n / 2)) * 3; // 지금까지의 숫자 카운트
				return dq(n / 2, r, c);
			}
		}

	}
}
