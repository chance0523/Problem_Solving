package com.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_12970_AB {
	static BufferedReader br;
	static StringTokenizer st;
	static BufferedWriter bw;
	static int n, k;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		for (int a = 0; a < n; a++) {
			int b = n - a;
			if (a * b < k)
				continue;
			
			// word[i] : i 번째 들어갈 A의 개수
			// 좌우 뒤집어서 처리
			int[] word = new int[b + 1];
			for (int i = 0; i < a; i++) {
				int x = Math.min(b, k);

				word[x]++;
				k -= x;
			}

			for (int i = b; i >= 0; i--) {
				for (int j = 0; j < word[i]; j++) {
					System.out.print("A");
				}
				if (i > 0)
					System.out.print("B");
			}
			return;
		}
		System.out.println(-1);
	}
}
