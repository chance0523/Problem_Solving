package com.boj;

import java.util.Scanner;

public class BOJ_11050_이항계수1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		// nCk를 출력
		int son = 1; // 분자
		int mom = 1; // 분모
		for (int i = n; i > n - k; i--) {
			son *= i;
		}
		for (int i = k; i >= 1; i--) {
			mom *= i;
		}
		System.out.println(son/mom);
		sc.close();
	}
}
