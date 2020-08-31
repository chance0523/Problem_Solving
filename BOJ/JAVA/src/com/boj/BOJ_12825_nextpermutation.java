package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_12825_nextpermutation {
	static BufferedReader br;
	static StringTokenizer str;
	static int n;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		str = new StringTokenizer(br.readLine());
		n = Integer.parseInt(str.nextToken());
		arr = new int[n];
		str = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}

		// 동작
		int i = n - 1;
		while (i > 0 && arr[i - 1] >= arr[i])
			--i;

		int j = n - 1;
		while (arr[i - 1] >= arr[j])
			--j;
		swap(arr, i - 1, j);
		
		
		// 뒤에 정렬하는 부분
		// i-1(4)과 j(5)를 swap
		ArrayList<Integer> tarr = new ArrayList<Integer>();
		for (int k = 0; k <= i-1; k++) {
			tarr.add(arr[k]);
		}
		
		// 작은 것들 넣기
		for (int k = j; k < n; k++) {
			tarr.add(arr[k]);
		}
		
		// 큰 수가 있다면
		if(Math.abs(i-1-j)>1) {
			for (int k = j-1; k >= i; k--) {
				tarr.add(arr[k]);
			}
		}

		for (int k = 0; k < n; k++) {
			System.out.print(tarr.get(k)+" ");
		}
	}

	private static void swap(int numbers[], int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
