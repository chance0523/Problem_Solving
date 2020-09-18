package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2477_참외밭 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[6];
		int w = 0;
		int h = 0;
		for (int i = 0; i < 6; i++) { // 6각형
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken()) - 1; // 방향
			int len = Integer.parseInt(st.nextToken()); // 길이
			arr[i] = len;
			// 가로와 세로의 최대값을 정해줌 (큰 사각형)
			if (i % 2 == 0)
				w = Math.max(w, len);
			else
				h = Math.max(h, len);
		}

		// 앞변 + 뒷변 == 최대변일때 움푹 들어간 변이다
		int w2 = 0, h2 = 0;
		for (int i = 0; i < 6; i++) {
			if (i % 2 == 0 && h == arr[(i + 5) % 6] + arr[(i + 1) % 6]) {
				w2 = arr[i];
			} else if (i % 2 == 1 && w == arr[(i + 5) % 6] + arr[(i + 1) % 6]) {
				h2 = arr[i];
			}

		}
		System.out.println(n * (w * h - w2 * h2));
	}
}