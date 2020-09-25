package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1838_버블정렬 {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		N[] arr = new N[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = new N(Integer.parseInt(st.nextToken()), i);
		}

		// 동작
		Arrays.sort(arr);

		int ans = 0;
		// 정렬 전후의 인덱스 비교해서 차이가 제일 큰 값 찾기
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, arr[i].index - i);
		}

		System.out.println(ans);
	}

	private static class N implements Comparable<N> {
		int value;
		int index;

		public N(int value, int index) {
			super();
			this.value = value;
			this.index = index;
		}

		@Override
		public int compareTo(N o) {
			// TODO Auto-generated method stub
			return this.value - o.value;
		}
	}
}
