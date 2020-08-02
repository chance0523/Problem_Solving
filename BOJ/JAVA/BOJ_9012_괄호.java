package com.boj;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_9012_괄호 {
	static Stack<Character> stack;
	static String str;
	static char c;
	static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			stack = new Stack<Character>();
			str = sc.next();
			flag = true;
			
			for (int j = 0; j < str.length(); j++) {
				c = str.charAt(j);
				if (c == '(')
					stack.push(c); // ( 는 무조건 push
				else {
					if (stack.empty()) {
						System.out.println("NO");
						flag = false; // 출력 한 번만
						break;
					} else {
						stack.pop(); // stack에는 ( 만 있어서 pop으로만 가능
					}
				}
			}
			if (!flag)
				continue;
			else {
				if (stack.empty())
					System.out.println("YES");
				else // 스택에 뭔가 남아있으면
					System.out.println("NO");
			}

		}
		sc.close();
	}
}
