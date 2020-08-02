/* 10828. 스택
 * https://www.acmicpc.net/problem/10828
 */

package com.boj;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_10828_스택 {
	static Stack<Integer> s;
	static int n;
	static String com; // command
	static int num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s = new Stack<Integer>();
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			com = sc.next();
			switch (com) {
			case "push":
				s.push(sc.nextInt());
				break;
			case "pop":
				if (s.empty())
					System.out.println(-1);
				else
					System.out.println(s.pop());
				break;
			case "size":
				System.out.println(s.size());
				break;
			case "empty":
				if (s.empty())
					System.out.println(1);
				else
					System.out.println(0);
				break;
			case "top":
				if (s.empty())
					System.out.println(-1);
				else
					System.out.println(s.peek());
				break;
			default:
				break;
			}
		}
		sc.close();
	}
}
