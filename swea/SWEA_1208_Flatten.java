/* https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV139KOaABgCFAYh&categoryId=AV139KOaABgCFAYh&categoryType=CODE
 * 1208. [S/W 문제해결 기본] 1일차 - Flatten [D3]
 */
package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_1208_Flatten {

	// 최댓값을 update
	static int[] findMax(int[] arr) {
		int[] ret = new int[2];
		ret[0] = arr[0]; // 최댓값
		ret[1] = 0; // 최댓값의 인덱스
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > ret[0]) {
				ret[0] = arr[i];
				ret[1] = i;
			}
		}
		return ret;
	}

	// 최솟값을 update
	static int[] findmin(int[] arr) {
		int[] ret = new int[2];
		ret[0] = arr[0]; // 최솟값
		ret[1] = 0; // 최솟값의 인덱스
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < ret[0]) {
				ret[0] = arr[i];
				ret[1] = i;
			}
		}
		return ret;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int max, min, maxidx, minidx;
		int ans;
		for (int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt(); // 덤프횟수
			int[] boxes = new int[100];
			for (int j = 0; j < 100; j++) {
				boxes[j] = sc.nextInt();
			}
			max = findMax(boxes)[0];
			maxidx = findMax(boxes)[1];
			min = findmin(boxes)[0];
			minidx = findmin(boxes)[1];
			ans = max - min;

			for (int k = 0; k < n; k++) {
				// 덤프
				if (ans == 0) {
					break;
				}
				// 1회 덤프
				boxes[maxidx]--;
				boxes[minidx]++;
				max = findMax(boxes)[0];
				maxidx = findMax(boxes)[1];
				min = findmin(boxes)[0];
				minidx = findmin(boxes)[1];
				ans = max - min;
			}
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}
