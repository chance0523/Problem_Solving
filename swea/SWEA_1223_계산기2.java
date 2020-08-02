/* 1223. [S/W 문제해결 기본] 6일차 - 계산기2 D4
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14nnAaAFACFAYD
 */

package com.swea;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1223_계산기2 {
	static Stack<Integer> numStack;
	static Stack<Character> opStack;
	static int n;
	static String str;
	static char c;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			n = sc.nextInt();
			numStack = new Stack<Integer>();
			opStack = new Stack<Character>();
			str = sc.next();

			for (int i = 0; i < n; i++) {
				c = str.charAt(i); // int형으로

				if (c == '+') { // +일때
					if (opStack.empty()) // 비어있으면 넣어줌
						opStack.push('+');
					else {
						while (!opStack.empty()) {
							if (opStack.peek() == '*') {
								opStack.pop(); // *를 빼주고
								// num스택의 두 수를 pop해서 더해주고 push
								numStack.push(numStack.pop() * numStack.pop());
							} else { // +일때
								opStack.pop();
								numStack.push(numStack.pop() + numStack.pop());
							}
						}
						if (opStack.empty())
							opStack.push('+');
					}
				} 
				// * 일 때
				else if (c == '*') {
					if (opStack.empty()) // 비어있으면 넣어줌
						opStack.push('*');
					else {
						while (!opStack.empty()) {
							if (opStack.peek() == '*') {
								opStack.pop(); // *를 빼주고
								// num스택의 두 수를 pop해서 더해주고 push
								numStack.push(numStack.pop() * numStack.pop());
							} else { // +일때
								opStack.push('*');
								break;
							}
						}
						if (opStack.empty())
							opStack.push('*');
					}
				} 
				// 숫자
				else {
					numStack.push(c - '0');
				}
			}

			// 모든 것을 다 작업 한 후 각 stack에 남은 것들을 처리
			while (!opStack.empty()) {
				if (opStack.peek() == '*') {
					opStack.pop();
					numStack.push(numStack.pop() * numStack.pop());
				} else {
					opStack.pop();
					numStack.push(numStack.pop() + numStack.pop());
				}
			}
			System.out.println("#" + tc + " " + numStack.pop());
		}
		sc.close();
	}
}
