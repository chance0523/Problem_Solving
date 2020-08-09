package com.boj;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ_15651_n과m_3 {
	// 중복순열
	static int n, m;
	static int[] numbers;
	static BufferedWriter bw;
	public static void main(String[] args) throws Exception{
		bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 시간초과 방지
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		numbers = new int[m];

		func(0);

		sc.close();
		bw.flush();
		bw.close();
	}

	static void func(int cnt) throws Exception{
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				bw.write(numbers[i] + " ");
			}
			bw.write("\n");

			return;
		}

		for (int i = 1; i <= n; i++) {
			numbers[cnt] = i;
			func(cnt + 1);
		}
	}
}
