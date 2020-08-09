package com.boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11866_요세푸스문제0 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		StringBuilder sb = new StringBuilder(); // 출력을 위한 sb
		sb.append("<");
		Queue<Integer> q = new LinkedList<Integer>();
		// 큐 채워주기
		for (int i = 1; i <= n; i++) {
			q.offer(i);
		}
		
		while(!q.isEmpty()) {
			// k-1번만큼 앞에서 빼서 뒤에 넣고
			for (int i = 0; i < k-1; i++) {
				q.offer(q.poll());
			}
			// k번째는 sb에 넣는다.
			if(q.size()==1)
				sb.append(q.poll());
			else
				sb.append(q.poll()+", ");
		}
		
		// 출력
		sb.append(">");
		System.out.println(sb.toString());
		sc.close();
	}
}
