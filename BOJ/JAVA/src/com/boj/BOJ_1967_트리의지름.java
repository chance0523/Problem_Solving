package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1967_트리의지름 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n, p, c, dist, ans;
	static ArrayList<Tree> tree[];
	static Tree maxDistNode;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		if(n==1) { // 이거 안 써주면 100%에서 런타임 에러...
			System.out.println(0);
			System.exit(0);
		}
			
		tree = new ArrayList[n];
		for (int i = 0; i < n; i++) { // 초기화
			tree[i] = new ArrayList<>();
		}
		visited = new boolean[n];
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken()) - 1;
			dist = Integer.parseInt(st.nextToken());
			tree[p].add(new Tree(c, dist));
			tree[c].add(new Tree(p, dist));
		}
		
		// https://koosaga.com/14
		// maxDistNode 탐색
		for (Tree root : tree[0]) {
			visited[0] = true;
			dfs(root, root.d);
			visited[0] = false;
		}
		
		ans = 0;

		dfs(maxDistNode, 0);
		System.out.println(ans);

	}

	private static void dfs(Tree cur, int d) {
		visited[cur.idx] = true;

		for (Tree next : tree[cur.idx]) {
			if (!visited[next.idx]) {
				visited[next.idx] = true;
				dfs(next, d + next.d);
				visited[next.idx] = false;
			}
		}

		if (d > ans) {
			maxDistNode = cur;
			ans = d;
		}

		visited[cur.idx] = false;

	}

	private static class Tree {
		int idx, d;

		public Tree(int idx, int d) {
			this.idx = idx;
			this.d = d;
		}
	}
}
