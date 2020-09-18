package com.swea;

import java.util.Scanner;

public class SWEA_4796_의석이의우뚝선산 {
	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			// 동작
			int up = 0;
			int down = 0;
			int ans = 0;
			boolean flag = true;
			for (int i = 0; i < n - 1; i++) {
				if (flag && arr[i] < arr[i + 1]) // 오름차순
					up++;
				else if (!flag && arr[i] > arr[i + 1]) // 내림차순
					down++;
				else if (flag && arr[i] > arr[i + 1]) {
					// 오르고 있었는데 내리막길이 나오면
					down++;
					flag = false;
				} else if (!flag && arr[i] < arr[i + 1]) {
					// 내리막길이었는데 오르막이 나오면
					flag = true;
					ans += (up * down); // 현재까지의 모든 구간 더해줌
					down = 0; // 초기화
					up = 1; // 이번에 올라가서 1로
				}
			}

			// 마지막에 남은 것들 다 구해줌
			ans += (up * down);
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}
