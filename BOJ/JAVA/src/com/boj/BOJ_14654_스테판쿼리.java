package com.boj;

import java.util.Scanner;

public class BOJ_14654_스테판쿼리 {
	static int a1, a2, b1, b2, ans1, ans2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] map1 = new int[n];
		int[] map2 = new int[n];
		for (int i = 0; i < n; i++) {
			map1[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			map2[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			a1 = map1[i];
			a2 = map2[i];
			if (a1 == a2) { // 비겼으면
				if (b1 == 0) { // 지금 들어온 사람이 승리
					b1++; // 승리 적립
					b2 = 0; // 초기화
				} else if (b2 == 0) {
					b2++;
					b1 = 0;
				}
			} else { // 다를때
				if ((a1 == 1 && a2 == 3) || (a1 == 2 && a2 == 1) || (a1 == 3 && a2 == 2)) { // a1승
					b1++;
					b2 = 0;
				} else if ((a1 == 1 && a2 == 2) || (a1 == 2 && a2 == 3) || (a1 == 3 && a2 == 1)) {
					b2++;
					b1 = 0;
				}
			}
			ans1 = Math.max(ans1, b1);
			ans2 = Math.max(ans2, b2);
		}
		System.out.println(Math.max(ans1, ans2));
		sc.close();
	}
}
