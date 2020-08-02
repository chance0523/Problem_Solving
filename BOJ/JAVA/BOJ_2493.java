package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {
	static int n;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더로 해야 메모리 초과 안남
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> index = new Stack<Integer>();

		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken()); // 높이 입력
			if (stack.isEmpty()) {
				stack.push(num);
				index.push(i);
				System.out.print(0 + " ");
				continue;
			} 
			else {
				while (!stack.isEmpty()) {
					if (stack.peek() < num) { // 앞 숫자가 더 작으면 가차없이 밀어버린다.
						stack.pop();
						index.pop();
					} else { // 앞 숫자가 더 크면 인덱스 출력
						System.out.print(index.peek() + " ");
						break;
					}
				}
				
				if (stack.isEmpty())
					System.out.print(0 + " ");
				stack.push(num);
				index.push(i);
			}
		}

	}
}
