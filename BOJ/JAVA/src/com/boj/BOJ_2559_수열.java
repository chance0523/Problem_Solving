package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2559_수열 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n, k;
	static int[] arr;
	static int ans;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 동작
		// 맨 첫번째 sum을 구해줌
		int sum = 0;
		int max = 0;
		for (int i = 0; i < k; i++) {
			sum+=arr[i];
		}
		
		// 그 다음부터 수열을 sliding하면서 최대값을 구해줌
		max = sum;
		for (int i = 0; i < n-k; i++) {
			sum-=arr[i]; // 맨 왼쪽 값을 덜고
			sum+=arr[i+k]; // 맨 오른쪽 값을 더한다
			if(sum>max)
				max = sum;
		}
		
		System.out.println(max);
		
	}
}
