package com.boj;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ_10866_덱 {
	static int n;
	static String com; // command
	static int num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			com = sc.next();
			switch (com) {
			case "push_front":
				deque.offerFirst(sc.nextInt());
				break;
			case "push_back":
				deque.offerLast(sc.nextInt());
				break;
			case "pop_front":
				if(deque.isEmpty())
					System.out.println(-1);
				else
					System.out.println(deque.pollFirst());
				break;
			case "pop_back":
				if(deque.isEmpty())
					System.out.println(-1);
				else
					System.out.println(deque.pollLast());
				break;
			case "size":
				System.out.println(deque.size());
				break;
			case "empty":
				if(deque.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
				break;
			case "front":
				if(deque.isEmpty())
					System.out.println(-1);
				else
					System.out.println(deque.peekFirst());
				break;
			case "back":
				if(deque.isEmpty())
					System.out.println(-1);
				else
					System.out.println(deque.peekLast());
				break;
			default:
				break;
			}
		}
		sc.close();
	}
}
