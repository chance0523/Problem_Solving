package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10972_다음순열 {
	static int n;
	static BufferedReader br;
	static StringTokenizer str;
	static int[] arr;

	public static void main(String[] args) throws Exception {

		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		str = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}

		if (n == 1) { // 하나면 이걸로 수행 끝
			System.out.println(-1);
			return;
		}
		// 동작

		int i = n - 1;
		while (true) { // 뒤에서 앞으로 오면서 꺾이는 점 찾기
			if (arr[i - 1] < arr[i]) {
				break;
			}
			i--;
			if (i == 0) {
				System.out.println(-1);
				return;
			}
		}

		// 뒤에서부터 꼭대기 앞 수와 바꿀 큰 수 찾아줌 (반드시 존재)
		int j = n - 1;
		while (true) {
			if (arr[i - 1] < arr[j]) { // swap
				int temp = arr[i - 1];
				arr[i - 1] = arr[j];
				arr[j] = temp;
				break;
			}
			j--;
		}

		// i부터 맨 끝까지 sort
		int[] tempArr = new int[n - i]; // 부분배열을 담을 배열
		for (j = 0; j < tempArr.length; j++) {
			tempArr[j] = arr[i + j];
		}

		Arrays.sort(tempArr); // 정렬하고
		// 다시 넣어준다
		for (j = 0; j < tempArr.length; j++) {
			arr[i + j] = tempArr[j];
		}

		for (j = 0; j < n; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println();

	}
}
