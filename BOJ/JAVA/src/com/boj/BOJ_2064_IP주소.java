package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2064_IP주소 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static long[] arr;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new long[n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			String[] strs = str.split("\\.");
			long[] narr = new long[4];
			for (int j = 0; j < 4; j++) {
				narr[j] = Integer.parseInt(strs[j]);
			}

			// 동작 (32비트로 바꿔줌)
			long temp = 0;
			for (int j = 0; j < 4; j++) {
				temp = temp << 8;
				temp |= narr[j];
			}
			// n개 다 담아줌
			arr[i] = temp;
		}
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
	}
}
