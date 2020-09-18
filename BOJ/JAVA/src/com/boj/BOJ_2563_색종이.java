package com.boj;

import java.util.Scanner;

public class BOJ_2563_색종이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] fullmap = new int[101][101];
		// 색종이들 입력
		for (int t = 0; t < n; t++) {
			int c = sc.nextInt();
			int r = sc.nextInt();
			// 크기는 10x10
			for (int i = r; i < r + 10; i++) {
				for (int j = c; j < c + 10; j++) {
					// 색종이가 도화지 밖으로 나가는 경우는 없다.
					fullmap[i][j]++;
				}
			}
		}
		
		// 모든 색종이를 덮은 뒤 덮인 넓이 확인
		int ans=0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if(fullmap[i][j]>=1)
					ans++;
			}
		}
		System.out.println(ans);

		sc.close();
	}
}
