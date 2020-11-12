package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6064_카잉달력 {
	static BufferedReader br;
	static StringTokenizer st;
	static int t, x, y, m, n, ans;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			// 동작
			
			// <M:N>
			// <x:y>
			ans = 0;

			int max = m * n;
			int idx = 0;
			if (y == n)
				y = 0;
			
			while (true) {
				if ((m * idx + x) % n == y) {
					ans = m * idx + x;
					break;
				}
				if (m * idx + x > max) { // 표현 할 수 없을 때
					ans = -1;
					break;
				}
				idx++;
			}

			System.out.println(ans);
		}
	}
}
