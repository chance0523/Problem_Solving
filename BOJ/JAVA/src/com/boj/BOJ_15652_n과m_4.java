package com.boj;

import java.util.Scanner;

public class BOJ_15652_n과m_4 {
	// 중복 조합
	static int n, m;
	static int[] numbers;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		numbers = new int[m];

		func(0, 0);

		sc.close();
	}

	static void func(int cnt, int start) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < n; i++) {
			numbers[cnt] = i + 1;
			func(cnt + 1, i);
		}
	}
}
