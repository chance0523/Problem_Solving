package com.boj;

import java.util.Scanner;

public class BOJ_2564_경비원 {
	static int r, c;
	static int dong;

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		int n = sc.nextInt();
		int ans = 0;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			int dir = sc.nextInt(); // 방향
			int d = sc.nextInt(); // 거리
			arr[i] = getDistanceFromZero(dir, d); // 왼쪽위 모서리로부터 상점까지의 거리
		}

		dong = getDistanceFromZero(sc.nextInt(), sc.nextInt()); // 동근이도 구해준다.
		
		for (int i = 0; i < n; i++) {
			ans += getDistance(arr[i]); // 최단경로 구해서 더해주기
		}

		// 출력
		System.out.println(ans);
		sc.close();
	}

	private static int getDistanceFromZero(int dir, int d) {
		if (dir == 1) // 북
			return d;
		else if (dir == 2) // 남
			return r + c + r - d;
		else if (dir == 3) // 서
			return r + c + r + c - d;
		else // 동
			return r + d;
	}

	private static int getDistance(int loc) {
		int total = r * 2 + c * 2; // 둘레
		// temp와 arr[i]의 거리를 두가지 방면에서 구하기
		return Math.min(Math.abs(dong - loc), (total - Math.abs(dong - loc)));
	}
}
