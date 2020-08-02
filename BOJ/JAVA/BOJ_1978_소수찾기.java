package com.boj;

import java.util.Scanner;

public class BOJ_1978_소수찾기 {
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		
		// 소수 배열 만들기 (false면 소수)
		// 0,1 예외 주의
		boolean[] isPrime = new boolean[1010]; // 여유 있게
		isPrime[0] = true;
		isPrime[1] = true;
		for (int i = 2; i < isPrime.length; i++) {
			if (isPrime[i] == true) // true면 소수가 아니다
				continue;
			for (int j = i + i; j < isPrime.length; j += i) {
				isPrime[j] = true;
			}
		}
		
		// 수들 입력 받기
		for (int i = 0; i < n; i++) {
			if(isPrime[sc.nextInt()]==false)
				ans++;
		}
		System.out.println(ans);
		
		sc.close();
	}
}
