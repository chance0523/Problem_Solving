package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10158_개미 {
	static BufferedReader br;
	static StringTokenizer st;
	static int w, h, p, q, t;
	static int r, c;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		p = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(br.readLine());

		// 동작
		// 개미는 오른쪽 위 45도 방향으로 먼저 움직임
		int garo = (p + t) / w;
		int sero = (q + t) / h;

		// garo=0 이면 오른쪽으로 가는 중, 1이면 왼쪽으로 가는중 ...
		r = (p + t) % w;
		if (garo % 2 == 1)
			r = w - r;
		c = (q + t) % h;
		if (sero % 2 == 1)
			c = h - c;
		System.out.println(r + " " + c);
	}
}