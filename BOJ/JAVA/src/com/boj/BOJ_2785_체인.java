package com.boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_2785_체인 {
	static StringTokenizer st;
	static int n;
	static ArrayList<Integer> list;

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			list.add(sc.nextInt());
		}

		Collections.sort(list); // 정렬

		int ans = 0;
		int s = 0;
		while (true) {
			s = list.size();
			if (s <= 1) {
				System.out.println(ans);
				break;
			}		

			list.set(0, list.get(0) - 1);
			list.remove(s - 1);
			ans++;

			if (list.get(0) == 0)
				list.remove(0);
		}
		sc.close();
	}
}
