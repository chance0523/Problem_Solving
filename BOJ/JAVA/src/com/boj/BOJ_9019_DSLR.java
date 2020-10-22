package com.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9019_DSLR {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int t;
	static int a, b;
	static boolean[] visited;
	static Queue<Integer> q;
	static int n, D, S, L, R;
	static String[] ans;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		visited = new boolean[10000];
		ans = new String[10000];
		q = new LinkedList<Integer>();
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			// 동작
			// 초기화(메모리 아끼기)
			for (int j = 0; j < 10000; j++) {
				visited[j] = false;
				ans[j] = "";
			}
			q.clear();

			// 담아주기
			q.add(a);
			visited[a] = true;
			// bfs 돌기
			bfs();
			System.out.println(ans[b]);
		}
	}

	private static void bfs() {
		while (!q.isEmpty() && !visited[b]) {
			n = q.poll(); // 숫자 꺼내줌
			D = (n * 2) % 10000;
			if (n == 0)
				S = 9999;
			else
				S = (n - 1);
			L = (n % 1000) * 10 + n / 1000; // 잘 생각해보면 4자리수가 아니어도 적용 가능
			R = (n / 10) + n % 10 * 1000;

			// 메소드 간단하게
			func(D, "D");
			func(S, "S");
			func(L, "L");
			func(R, "R");
		}
	}

	private static void func(int num, String command) {
		if (!visited[num]) {
			q.add(num);
			visited[num] = true;
			ans[num] = ans[n] + command; // 명령어 더해주기
		}
	}
}
