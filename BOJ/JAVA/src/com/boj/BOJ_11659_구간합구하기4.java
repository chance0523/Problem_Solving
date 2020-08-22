package com.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11659_구간합구하기4 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer str;
	static int n, m;
	static int[] nArr;
	static int start, end;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		str = new StringTokenizer(br.readLine());
		n = Integer.parseInt(str.nextToken());
		m = Integer.parseInt(str.nextToken());
		nArr = new int[n];
		str = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nArr[i] = Integer.parseInt(str.nextToken());
		}

		// 동작
		// prefix sum array
		int[] sumArr = new int[n];
		sumArr[0] = nArr[0];
		for (int i = 1; i < n; i++) {
			sumArr[i] = nArr[i] + sumArr[i - 1];
		}
		// 5 4 3 2 1
		// 5 9 12 14 15

		for (int i = 0; i < m; i++) {
			str = new StringTokenizer(br.readLine());
			start = Integer.parseInt(str.nextToken());
			end = Integer.parseInt(str.nextToken());
			bw.write(sumArr[end - 1] - sumArr[start - 1] + nArr[start - 1] + "\n");
		}
		bw.flush();
		bw.close();
	}
}
