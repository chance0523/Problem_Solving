package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11004_K번째수 {
	static BufferedReader br;
	static StringTokenizer str;
	static int n, k;
	static Integer[] arr;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		str = new StringTokenizer(br.readLine());
		n = Integer.parseInt(str.nextToken());
		k = Integer.parseInt(str.nextToken());
		arr = new Integer[n];
		str = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}
		
		Arrays.sort(arr);
		System.out.println(arr[k-1]);
	}
}
