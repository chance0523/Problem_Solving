/* 1218. [S/W 문제해결 기본] 4일차 - 괄호 짝짓기 [D4]
 * https://swexpertacademy.com/main/code/problem/problemSolver.do?contestProbId=AV14eWb6AAkCFAYD
 */

package com.swea;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1218 {
	static int t;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			sc.nextInt();
			Stack<Character> stack = new Stack<Character>();
			String str = sc.next();
			boolean flag = false;
			for (int j = 0; j < str.length(); j++) {
				if (stack.isEmpty() == false) { // 스택이 비어있지 않다면
					if (stack.peek() == '(' && str.charAt(j) == ')') {
						stack.push(str.charAt(j));
						stack.pop();
						stack.pop();
						flag = true;
					} else if (stack.peek() == '(' && str.charAt(j) == ')') {
						stack.push(str.charAt(j));
						stack.pop();
						stack.pop();
						flag = true;
					} else if (stack.peek() == '[' && str.charAt(j) == ']') {
						stack.push(str.charAt(j));
						stack.pop();
						stack.pop();
						flag = true;
					} else if (stack.peek() == '<' && str.charAt(j) == '>') {
						stack.push(str.charAt(j));
						stack.pop();
						stack.pop();
						flag = true;
					} else if (stack.peek() == '{' && str.charAt(j) == '}') {
						stack.push(str.charAt(j));
						stack.pop();
						stack.pop();
						flag = true;
					} else {
						stack.push(str.charAt(j));
						flag = false;
					}
				} else {
					stack.push(str.charAt(j));
					flag = false;
				}

			}
			if (flag == true && stack.isEmpty())
				System.out.println("#" + t + " " + 1);
			else
				System.out.println("#" + t + " " + 0);
		}
		sc.close();
	}
}