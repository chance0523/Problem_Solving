package com.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1806_부분합 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer str;
	static int n, s;
	static int[] nArr;
	static int start, end;
	static int minlen;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		str = new StringTokenizer(br.readLine());
		n = Integer.parseInt(str.nextToken());
		s = Integer.parseInt(str.nextToken());
		nArr = new int[n];
		str = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nArr[i] = Integer.parseInt(str.nextToken());
		}

		// 동작
		// prefix sum
		int[] sumArr = new int[n];
		sumArr[0] = nArr[0];
		for (int i = 1; i < n; i++) {
			sumArr[i] = nArr[i] + sumArr[i - 1];
		}

		// 최소 길이
		minlen = Integer.MAX_VALUE;
		start = 0;
		end = 0;
		int curSum = 0;
		while (true) {
			curSum = sumArr[end] - sumArr[start] + nArr[start];
			if (curSum >= s) {
				// 현재 합이 s보다 클 경우
				// 최소 길이 확인
				if (minlen > end - start + 1)
					minlen = end - start + 1;
				start++; // 범위 좁혀줌.
				if (start == n) // start가 맨끝이면 break
					break;
			} else {
				// 현재 합이 s보다 작을 경우
				if (end != n - 1) // end가 맨끝이 아니라면
					end++; // end를 밀어줌
				else // 이미 최대이면 break
					break;

			}
		}

		// 출력
		if (minlen == Integer.MAX_VALUE) // s보다 크게 만들 수 없으면 0
			System.out.println(0);
		else
			System.out.println(minlen);

	}
}
