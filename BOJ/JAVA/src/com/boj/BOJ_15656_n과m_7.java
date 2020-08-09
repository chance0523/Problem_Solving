package com.boj;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_15656_n과m_7 {
	// 중복순열+input
	static int n, m;
	static int[] numbers;
	static ArrayList<Integer> nArr;
	static BufferedWriter bw;

	public static void main(String[] args) throws Exception {
		bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 시간초과 방지
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

		func(0);

		sc.close();
		bw.flush();
		bw.close();
	}

	static void func(int cnt) throws Exception {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				bw.write(numbers[i] + " ");
			}
			bw.write("\n");

			return;
		}
		for (int i = 0; i < n; i++) {
			numbers[cnt] = nArr.get(i); // 현 위치에 넣어주고
			func(cnt + 1); // 다음 위치로
		}
	}
}