package com.boj;

import java.util.Scanner;

public class BOJ_1259_팰린드롬수 {
	static String str;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			str = sc.next();
			if (str.equals("0"))
				break;
			isPalindrome(str);
		}

		sc.close();
	}

	// 팰린드롬인지 체크
	static void isPalindrome(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				System.out.println("no");
				return;
			}
		}
		System.out.println("yes");
		return;
	}
}
