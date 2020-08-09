package com.boj;

import java.util.Scanner;

public class BOJ_2798_블랙잭 {
	static int n, m;
	static int[] card;
	static int sum;
	static int minDiff;
	static int maxSum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		card = new int[n];
		for (int i = 0; i < n; i++) {
			card[i] = sc.nextInt();
		}
		minDiff = 1000000;
		maxSum = 0;
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					sum = card[i] + card[j] + card[k];
					if (sum <= m && (m - sum) < minDiff) {
						maxSum = sum;
						minDiff = m - sum;
					}
				}
			}
		}
		System.out.println(maxSum);
		sc.close();
	}
}
