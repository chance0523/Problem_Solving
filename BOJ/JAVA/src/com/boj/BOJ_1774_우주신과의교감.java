package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1774_우주신과의교감 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n, m;
	static boolean[] visited;
	static ArrayList<int[]> god;
	static int x, y;
	// for MST
	static int v, e, a, b, c;
	static ArrayList<Edge> edgeList = new ArrayList<Edge>();
	private static int[] parents;
	static int ans;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		god = new ArrayList<int[]>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			// 좌표 넣기
			god.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}

		// make
		v = god.size();
		parents = new int[v+1];
		for (int i = 1; i <= v; i++) {
			parents[i] = i;
		}
		for (int i = 0; i < m; i++) {
			// 합쳐주기 (*번째라서 1 빼줌)
			st = new StringTokenizer(br.readLine());
			union(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
		}

		// 동작
		// 두 쌍의 길이를 Edge로 만들어줌
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				edgeList.add(new Edge(i, j, getDistance(i, j)));
			}
		}

		// 정렬
		Collections.sort(edgeList, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Double.compare(o1.weight, o2.weight);
			}
		});
		
		// 합치기
		double result = 0;
		int count = 0;
		for (Edge edge : edgeList) {
//			System.out.println(edge);
			if (union(edge.start, edge.end)) {
//				System.out.println(result);
				result += edge.weight;
				count++;
				if (count == v - 1)
					break;
			}
		}
		
		// 소수점 두자리만 출력
		System.out.println(String.format("%.2f", result));
	}

	private static double getDistance(int i, int j) {
		// 두 점 사이의 길이 구하기
		return Math.sqrt(Math.pow(god.get(i)[0] - god.get(j)[0], 2) + Math.pow(god.get(i)[1] - god.get(j)[1], 2));
	}

	// for MST
	private static class Edge {
		int start;
		int end;
		double weight;

		private Edge(int start, int end, double weight) {
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
