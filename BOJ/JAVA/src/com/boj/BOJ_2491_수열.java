package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2491_수열 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int[] arr;
	static int inc, dec;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 동작
		inc = 1; // 증가하는 구간 길이
		dec = 1; // 감소하는 구간 길이
		int ans = 1; // 배열 길이가 1이라면 답은 1
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] < arr[i + 1]) { // 증가
				inc++; // 증가구간 길이++
				ans = Math.max(ans, inc); // 최대 길이
				dec = 1; // 감소구간 길이 초기화
			} else if (arr[i] > arr[i + 1]) { // 감소
				dec++;
				ans = Math.max(ans, dec);
				inc = 1;
			} else { // 같을 때
				// 둘 다 늘려주고 비교
				inc++;
				ans = Math.max(ans, inc);
				dec++;
				ans = Math.max(ans, dec);
			}
		}
		System.out.println(ans);
	}
}
