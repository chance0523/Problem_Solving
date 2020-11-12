package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4256_트리 {
	static BufferedReader br;
	static StringTokenizer st;
	static int t, n;
	static int[] pre, in, post;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			pre = new int[n];
			in = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				pre[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				in[i] = Integer.parseInt(st.nextToken());
			}

			// 동작
			getPost(0, n, 0);
			System.out.println();
		}
	}

	private static void getPost(int s, int e, int root) {
		for (int i = s; i < e; i++) {
			// pre : 3 6 5 4 8 7 1 2
			// in : 5 6 8 4 3 1 2 7
			// post : 5 8 4 6 2 1 7 3
			if (in[i] == pre[root]) {
				getPost(s, i, root + 1); // 왼쪽 트리
				getPost(i + 1, e, i + root + 1 - s); // 오른쪽 트리
				System.out.print(pre[root] + " ");
			}
		}
	}
}
