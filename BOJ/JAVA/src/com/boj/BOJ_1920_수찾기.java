package com.boj;

import java.util.Scanner;

public class BOJ_1920_수찾기 {
	static int n;
	static int[] nArr;
	static int num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		nArr = new int[n];
		for (int i = 0; i < n; i++) {
			nArr[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			check(sc.nextInt());
		}
		sc.close();
	}
	static void check(int k) {
		for (int i = 0; i < n; i++) {
			if(k == nArr[i]) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
		return;
	}
}
