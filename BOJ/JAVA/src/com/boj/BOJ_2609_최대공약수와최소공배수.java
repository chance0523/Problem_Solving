package com.boj;

import java.util.Scanner;

public class BOJ_2609_최대공약수와최소공배수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		// GCD
		int gcd = 1;
		for (int i = 2; i <= (a < b ? a : b); i++) { // 더 작은 수까지
			if (a % i == 0 && b % i == 0)
				gcd = i;
		}

		// LCM
		int lcm = a * b; // a*b부터 둘 중 더 큰 수까지 감소하는 식으로
		for (int i = lcm - 1; i >= (a > b ? a : b); i--) {
			if (i % a == 0 && i % b == 0)
				lcm = i;
		}
		System.out.println(gcd);
		System.out.println(lcm);
		sc.close();
	}
}
