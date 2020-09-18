package com.boj;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2605_줄세우기 {
	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
		}

		// 동작
		ArrayList<Integer> arr = new ArrayList<Integer>(); // 학생들의 순서를 넣어줄 리스트
		// ArrayList.add(index,value) 사용
		arr.add(0, 1); // 첫번째 학생은 무조건 앞에
		for (int i = 1; i < n; i++) { // 1부터 시작
			int num = numbers[i]; // 번호를 뽑음
			// 맨끝(arr크기)에서 뽑은 번호(num)만큼 앞으로
			arr.add(arr.size() - num, i + 1); // i+1이 학생번호
		}

		// 출력
		for (int i = 0; i < n; i++) {
			System.out.print(arr.get(i) + " ");
		}
		sc.close();
	}
}
