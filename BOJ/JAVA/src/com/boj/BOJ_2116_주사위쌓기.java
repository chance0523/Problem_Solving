package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2116_주사위쌓기 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int[] dice;
	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			dice = new int[6];
			for (int j = 0; j < 6; j++) {
				dice[j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
