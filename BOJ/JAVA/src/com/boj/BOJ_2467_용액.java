package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2467_용액 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int[] arr;

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
		// 이미 정렬됨
		int left = 0;
		int right = n - 1;
		int sum = Integer.MAX_VALUE;
		int minsum = Integer.MAX_VALUE;
		int ans1 = 0, ans2 = 0;
		while (true) {
			if (left >= right) // 종료조건
				break;
			sum = arr[left] + arr[right];
			if (sum == 0) {
				ans1 = arr[left];
				ans2 = arr[right];
				break;
			}
			if (minsum > Math.abs(sum)) { // 절대값 비교
				minsum = Math.abs(sum);
				ans1 = arr[left];
				ans2 = arr[right];
			}
			if (sum < 0) {
				left++;
			} else {
				right--;
			}
		}
		System.out.println(ans1 + " " + ans2);
	}
}
