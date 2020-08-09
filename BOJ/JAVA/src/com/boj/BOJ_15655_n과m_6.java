package com.boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_15655_n과m_6 {
	// 조합+input
	static int n, m;
	static int[] numbers;
	static ArrayList<Integer> nArr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		nArr = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			nArr.add(sc.nextInt());
		}
		// 들어온 배열 정렬
		Collections.sort(nArr);
		numbers = new int[m];

		func(0, 0);

		sc.close();
	}

	static void func(int cnt, int start) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < n; i++) {
			numbers[cnt] = nArr.get(i); // 현 위치에 넣어주고
			func(cnt + 1, i + 1); // 다음 위치로
		}
	}
}
