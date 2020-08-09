package com.boj;

import java.util.Scanner;

public class BOJ_14648_쿼리맛보기 {
	static int n, q, a, b, c, d;
	static int num;
	static long sum;
	static int temp;
	static long sum1, sum2; // sum은 long으로 해야된다. '수열의 각 숫자는 int형 범위이다'

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 기본 입력
		n = sc.nextInt();
		q = sc.nextInt();
		int[] nArr = new int[n];
		for (int i = 0; i < n; i++) {
			nArr[i] = sc.nextInt();
		}
		
		// 쿼리 입력, 동작
		for (int i = 0; i < q; i++) {
			num = sc.nextInt();
			if (num == 1) {
				a = sc.nextInt() - 1;
				b = sc.nextInt() - 1;
				sum = 0;
				for (int j = a; j <= b; j++) {
					sum += nArr[j];
				}
				System.out.println(sum);
				temp = nArr[a];
				nArr[a] = nArr[b];
				nArr[b] = temp;

			} else {
				a = sc.nextInt() - 1;
				b = sc.nextInt() - 1;
				c = sc.nextInt() - 1;
				d = sc.nextInt() - 1;
				sum1 = 0;
				sum2 = 0;
				for (int j = a; j <= b; j++) {
					sum1 += nArr[j];
				}
				for (int j = c; j <= d; j++) {
					sum2 += nArr[j];
				}
				System.out.println(sum1 - sum2);
			}
		}
		sc.close();
	}
}
