package com.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2961_도영이가만든맛있는음식 {
	static int n;
	static int[][] arr;
	static StringTokenizer str;
	static int mincnt;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력
		n = Integer.parseInt(br.readLine());
		arr = new int[n][2];
		visited = new boolean[n];
		mincnt = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			str = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(str.nextToken());
			arr[i][1] = Integer.parseInt(str.nextToken());
		}

		// 신맛:곱, 쓴맛:합

		// 동작
		func(1, 0, 0); // 신맛은 곱하니까 1에서 시작, 인덱스 0부터

		// 출력
		bw.write(mincnt + "\n");

		bw.flush();
		bw.close();
	}

	private static void func(int s, int b, int index) {
		if (index == n) {
			if (mincnt > Math.abs(s - b) && b != 0) // b==0이면 재료를 아무것도 사용 안 했을 때
				mincnt = Math.abs(s - b);
			return;
		}
		
		// visited의 모든 경우의 수
		visited[index] = true;
		func(s * arr[index][0], b + arr[index][1], index + 1);
		visited[index] = false;
		func(s, b, index + 1);
	}
}
