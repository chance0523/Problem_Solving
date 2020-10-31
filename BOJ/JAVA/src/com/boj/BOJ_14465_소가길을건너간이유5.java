package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14465_소가길을건너간이유5 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n, k, b, sum;
	static int[] sin;
	static int ans;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		sin = new int[n];
		for (int i = 0; i < b; i++) {
			sin[Integer.parseInt(br.readLine()) - 1] = 1; // 고장 표시
		}

		// 동작
		// k개씩 스위핑?
		// 누적합? 시간 복잡도는 똑같나...

		// init sum
		sum = 0;
		for (int i = 0; i < k; i++) {
			sum += sin[i];
		}
		ans = Integer.MAX_VALUE;
		ans = Math.min(ans, sum); // 비교

		// 스위핑
		for (int i = k; i < n; i++) {
			sum += sin[i];
			sum -= sin[i - k];
			ans = Math.min(ans, sum);
		}

		System.out.println(ans);
	}
}
