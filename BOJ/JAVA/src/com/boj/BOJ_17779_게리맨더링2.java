package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17779_게리맨더링2 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n, num, ans, x, y, d1, d2;
	static int[][] pop;
	static int[] numbers;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		pop = new int[n + 1][n + 1]; // (1,1)을 시작점으로 두기 위함
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) { // 구역 연결
				pop[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 동작
		ans = Integer.MAX_VALUE;
		// x,y,d1,d2 고르기
		for (int i = 1; i < n; i++) { // 범위 조심
			for (int j = 2; j < n; j++) {
				x = i; // 기준점
				y = j;
				for (int dx = 1; dx < n; dx++) {
					for (int dy = 1; dy < n; dy++) {
						d1 = dx; // 경계의 길이
						d2 = dy;
						if (x + d1 + d2 <= n && 1 <= y - d1 && y + d2 <= n) { // 경계조건 만족
							makemap(x, y, d1, d2);
						}
					}
				}
			}
		}

		System.out.println(ans);
	}

	private static void makemap(int x, int y, int d1, int d2) {
		// x,y,d1,d2로 구역을 나눈다.
		int[][] tempmap = new int[n + 1][n + 1]; // 구역을 나눌 맵
		int p1=0,p2=0,p3=0,p4=0,p5=0;
		for (int r = 1; r <= n; r++) {
			for (int c = 1; c <= n; c++) {
				if (r < x + d1 && c <= y && 
						!(r >= x && c >= (y - (r - x)))) { // 1번구역
					tempmap[r][c] = 1;
					p1+=pop[r][c];
				}
				else if (r <= x + d2 && y < c &&
						!(r>=x&&c<=y+(r-x))) {
					tempmap[r][c] = 2;
					p2+=pop[r][c];
				}
				else if (x + d1 <= r && c < y - d1 + d2&&
						!(r<=x+d1+d2&& c >= (y - d1 + d2 - (x + d1 + d2 - r)))) {
					tempmap[r][c] = 3;
					p3+=pop[r][c];
				}
				else if (x + d2 < r && y - d1 + d2 <= c &&
						!(r <= x + d1 + d2 && c <= (y - d1 + d2 + (x + d1 + d2 - r)))) {
					tempmap[r][c] = 4;
					p4+=pop[r][c];
				}
				else {
					tempmap[r][c] = 5;
					p5+=pop[r][c];
				}
			}
		}
		int[] p = new int[]{p1,p2,p3,p4,p5};
		Arrays.sort(p);
		
		int diff = p[4]-p[0];
		ans = Math.min(diff,ans);
		
		
	}

}
