package com.boj;

import java.util.Scanner;

public class BOJ_2292_벌집 {
	public static int execute(int N) {
		if(N==1)
			return 1;
		int cnt = 1;
		int d = 1;
		while(true) {
			if(cnt>=N) {
				return d;
			}
			cnt+=d*6;
			d++;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(execute(N)); // 3
		sc.close();
	}
}
