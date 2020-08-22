package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {
	static int n, m, v;
	static int[][] map;
	static BufferedReader br;
	static StringTokenizer str;

	static Stack<Integer> s;
	static Queue<Integer> q;

	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		str = new StringTokenizer(br.readLine());
		n = Integer.parseInt(str.nextToken());
		m = Integer.parseInt(str.nextToken());
		v = Integer.parseInt(str.nextToken());

		map = new int[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			str = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(str.nextToken());
			int v2 = Integer.parseInt(str.nextToken());
			map[v1][v2] = 1;
			map[v2][v1] = 1;
		}

		// dfs
		s = new Stack<Integer>();
		visited = new boolean[n + 1];
		s.push(v);
		while (!s.isEmpty()) {
			int p = s.pop();
			if (visited[p])
				continue;
			visited[p]=true;
			System.out.print(p + " ");
			for (int i = n; i >= 1; i--) {
				if (map[p][i] == 1 && visited[i] == false) {
					s.push(i);
				}
			}
		}

		System.out.println();

		// bfs
		q = new LinkedList<Integer>();
		visited = new boolean[n + 1];
		q.offer(v);
		while (!q.isEmpty()) {
			int p = q.poll();
			if (visited[p])
				continue;
			visited[p] = true;
			System.out.print(p + " ");
			for (int i = 1; i < n + 1; i++) {
				if (map[p][i] == 1 && visited[i] == false) {
					q.offer(i);
				}
			}
		}
	}
	


}
