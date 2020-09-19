package com.boj;

import java.util.Scanner;

public class BOJ_2669_직사각형네개의합집합의면적구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] fullmap = new int[101][101];
		// 입력
		for (int t = 0; t < 4; t++) { // 사각형 네개
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					fullmap[i][j]++;
				}
			}
		}

		int ans = 0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (fullmap[i][j] >= 1)
					ans++;
			}
		}
		System.out.println(ans);

		sc.close();
	}
}