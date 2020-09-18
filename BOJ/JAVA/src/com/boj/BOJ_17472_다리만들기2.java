package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_17472_다리만들기2 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n, m, ans;
	static int[][] map;
	static int mask;
	static boolean[][] masked;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static ArrayList<Edge> edgeList;
	private static int[] parents;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 동작
		/*
		 * MST를 사용해야한다. -> 모든 섬을 일단 다 연결하고 시작 섬들을 다 마스킹하기
		 */

		edgeList = new ArrayList<Edge>();

		// 1. 마스킹하기
		mask = 2; // 기존 1과 헷갈리지 않게 2부터 시작
		masked = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					masking(i, j);
					mask++;
				}
			}
		}

		// 2. 모든 섬 연결하기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0) { // 마스킹 된 상태
					if (j <= m - 4 && map[i][j + 1] == 0) {
						makeGaroBridge(i, j);
					}
					if (i <= n - 4 && map[i + 1][j] == 0) {
						makeSeroBridge(i, j);
					}
				}
			}
		}
		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		// 3. 크루스칼로 MST를 만들어준다.
		parents = new int[mask];
		Collections.sort(edgeList, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.weight - o2.weight;
			}
		});

		make();
		ans = 0;
		int cnt = 0;
		for (Edge edge : edgeList) {
			if (union(edge.start, edge.end)) {
				ans += edge.weight;
				cnt++;
			}
		}
		
//		System.out.println(mask+" "+cnt);
		if (mask-cnt==3)
			System.out.println(ans);
		else // 모든 섬을 연결 할 수 없을 때
			System.out.println(-1);

	}

	private static void makeGaroBridge(int r, int c) { // 가로로 다리 놓기
		int cnt = 1;
		while (true) {
			if (c + cnt == m) { // 섬을 찾지 못했으면
				return;
			}
			if (map[r][c + cnt] != 0) {
				// 다리 건설 (길이만)
				if (cnt > 2) { // 길이가 2 이상인 경우에만 (cnt 조심)
					edgeList.add(new Edge(map[r][c], map[r][c + cnt], cnt - 1)); // 섬과 다리 길이만 넣는다.
				}
				return;
			} else {
				cnt++;
			}
		}
	}

	private static void makeSeroBridge(int r, int c) {
		int cnt = 1;
		while (true) {
			if (r + cnt == n) { // 섬을 찾지 못했으면
				return;
			}
			if (map[r + cnt][c] != 0) {
				// 다리 건설 (길이만)
				if (cnt > 2) // 길이가 2 이상인 경우에만 (cnt 조심)
					edgeList.add(new Edge(map[r][c], map[r + cnt][c], cnt - 1)); // 섬과 다리 길이만 넣는다.
				return;
			} else {
				cnt++;
			}
		}
	}

	private static void masking(int r, int c) {
		map[r][c] = mask;
		masked[r][c] = true;
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dx[dir];
			int nc = c + dy[dir];
			if (nr >= 0 && nc >= 0 && nr < n && nc < m && !masked[nr][nc] && map[nr][nc] == 1) {
				map[nr][nc] = mask;
				masking(nr, nc);
			}
		}
	}

	static class Edge {
		int start;
		int end;
		int weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}
	}

	private static void make() {
		for (int i = 0; i < mask; i++) {
			parents[i] = i;
		}
	}

	private static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a > b) {
			parents[a] = b;
			return true;
		} else if (a < b) {
			parents[b] = a;
			return true;
		}
		return false;
	}

}
