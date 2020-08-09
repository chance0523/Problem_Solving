package com.boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2164_카드2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		
		// 초기화
		for (int i = 1; i <= n; i++) {
			q.offer(i);
		}
		// 동작
		while(true) {
			if(q.size()==1) {
				System.out.println(q.poll());
				break;
			}
			else {
				q.poll();
				if(q.size()==1) {
					System.out.println(q.poll());
					break;
				}
				else
					q.offer(q.poll());
			}
			
		}
		
		
		
		sc.close();
	}
}
