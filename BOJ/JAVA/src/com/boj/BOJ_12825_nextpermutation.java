package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 풀이 미완
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
		while (np(arr)) {
			for (int i = 0; i < n; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
//			return;
		}
	}

	private static boolean isnot312() {
		for (int i = 0; i < n - 2; i++) {
			for (int j = i; j < n - 1; j++) {
				for (int k = j; k < n; k++) {
					if (arr[i] > arr[j] && arr[i] > arr[k] && arr[j] < arr[k]) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private static boolean np(int numbers[]) {
		int i = n - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i])
			--i;

		if (i == 0)
			return false;

		int j = n - 1;
		while (numbers[i - 1] >= numbers[j])
			--j;
		swap(numbers, i - 1, j);

		int k = n - 1;
//		while (i < k) {
//			swap(numbers, i++, k--);
//		}
		return true;
	}

	private static void swap(int numbers[], int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
