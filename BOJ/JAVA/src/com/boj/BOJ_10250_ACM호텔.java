package com.boj;

import java.util.Scanner;

public class BOJ_10250_ACM호텔 {
	static int t, h, w, n;
	static int xx,yy;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			h = sc.nextInt(); // 층 수 (세로)
			w = sc.nextInt(); // 방 수 (가로)
			n = sc.nextInt(); // 손님번호
			xx = n % h; // 이게 층 XX
			yy = n / h + 1; // 이게 호 YY
			if(xx==0) {
				xx=h;
				yy--;
			}
			
			
			// XXYY호
			System.out.println(xx*100+yy);
		}
		sc.close();
	}
}
