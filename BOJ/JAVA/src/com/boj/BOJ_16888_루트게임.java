package com.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_16888_루트게임 {
	static BufferedReader br;
	static BufferedWriter bw;
	static int t, n;
	static boolean[] arr;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		t = Integer.parseInt(br.readLine());
		makeArray();
		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			// 0을 만드는 사람이 게임을 이긴다.
			// n이 완전 제곱수라면 바로 구사과가 이긴다.
			if (arr[n])
				System.out.println("koosaga");
			else
				System.out.println("cubelover");
		}
	}

	private static void makeArray() {
		arr = new boolean[1000001];
		// 구사과의 승리를 true
		// 제곱수 체크
		for (int i = 1; i * i <= 1000000; i++) {
			arr[i * i] = true;
		}

		for (int i = 1; i <= 1000000; i++) {
			if (!arr[i]) { // 이 숫자를 가지고 있는 사람이 지는 상황
				for (int j = 1; i + j * j <= 1000000; j++) {
					arr[i + j * j] = true; // 그 전에 제곱수를 뺀 사람은 이김
				}
			}
		}
	}
}
