package com.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_8275_햄스터 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int t, n, x, m, l, r, s;
	static int[] ans;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				l = Integer.parseInt(st.nextToken());
				r = Integer.parseInt(st.nextToken());
				s = Integer.parseInt(st.nextToken());
			}
		}

		// 동작
	}
}
