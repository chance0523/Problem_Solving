package com.boj;

import java.util.Scanner;

public class BOJ_15650_n과m_2 {
	static int n, m;
	static int[] numbers;

	public static void main(String[] args) {
		// 조합
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		numbers = new int[m];

		combinations(0, 0);
		sc.close();
	}

	static void combinations(int cnt, int start) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < n; i++) {
			numbers[cnt] = i + 1;
			combinations(cnt + 1, i + 1);
		}

	}
}
