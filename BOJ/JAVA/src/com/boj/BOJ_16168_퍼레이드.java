package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_16168_퍼레이드 {
	static BufferedReader br;
	static StringTokenizer st;
	static int v, e;
	static int[][] visited;
	static boolean flag;
	static ArrayList<ArrayList<Integer>> map;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		visited = new int[v][v];
		// TLE 방지를 위해 이중 ArrayList 사용
		map = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < v; i++) {
			map.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1; // 1 빼주기
			int b = Integer.parseInt(st.nextToken()) - 1;
			map.get(a).add(b);
			map.get(b).add(a);
		}

		// 동작
		for (int i = 0; i < v; i++) {
			dfs(i, i, 0);
			if (flag)
				break;
		}

		// 출력
		if (flag)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	private static void dfs(int start, int id, int cnt) {
		if (cnt == e) {
			flag = true;
			return;
		}
		for (int dst : map.get(start)) { // 이렇게 하지 않으면 TLE
			if (visited[start][dst] == id || visited[dst][start] == id)
				continue;
			visited[start][dst] = id;
			visited[dst][start] = id;
			dfs(dst, id, cnt + 1);
		}
	}
}
