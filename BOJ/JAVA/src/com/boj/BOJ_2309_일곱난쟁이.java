package com.boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309_일곱난쟁이 {
	static int[] arr;
	static int s;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		s = 0;
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
			s += arr[i];
		}
		Arrays.sort(arr);
		solve();
		sc.close();
	}

	private static void solve() {
		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (s - arr[i] - arr[j] == 100) {
					for (int k = 0; k < 9; k++) {
						if (k == i || k == j)
							continue;
						System.out.println(arr[k]);
					}
					return;
				}
			}
		}
	}
}