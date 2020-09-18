package com.boj;

import java.util.Scanner;

public class BOJ_2661_좋은수열 {
	static int n;
	static boolean flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		func(1, "1");
		sc.close();
	}

	private static void func(int len, String s) {
		if(flag)
			return;
		if (len == n) {
			flag=true;
			System.out.println(s);
		} else {
			for (int i = 1; i <= 3; i++) { // 1,2,3을 붙여본다.
				if (isGood(s + i)) { // 좋은 수열인지 판별
					func(len + 1, s + i); // 좋은 수열이면 이번 숫자를 붙인다.
				}
				
			}
		}
	}

	private static boolean isGood(String s) {
		int len = s.length();
		int start = len - 1;
		int end = len;
		for (int i = 1; i <= len / 2; i++) {
			if (s.substring(start, end).equals(s.substring(start - i, end - i)))
				return false;
			start--;
		}
		return true;
	}
}
