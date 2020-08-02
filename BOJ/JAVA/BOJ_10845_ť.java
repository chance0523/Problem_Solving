package com.boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_10845_큐 {
	static Queue<Integer> q;
	static int n;
	static String com; // command
	static int back;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			com = sc.next();
			switch (com) {
			case "push":
				back = sc.nextInt();
				q.offer(back);
				break;
			case "pop":
				if(q.isEmpty())
					System.out.println(-1);
				else
					System.out.println(q.poll());
				break;
			case "size":
				System.out.println(q.size());
				break;
			case "empty":
				if(q.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
				break;
			case "front":
				if(q.isEmpty())
					System.out.println(-1);
				else
					System.out.println(q.peek());
				break;
			case "back":
				if(q.isEmpty())
					System.out.println(-1);
				else
					System.out.println(back);
				break;
			default:
				break;
			}
		}
		sc.close();
	}
}
