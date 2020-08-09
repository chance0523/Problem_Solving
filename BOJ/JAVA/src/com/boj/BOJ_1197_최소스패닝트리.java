package com.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1197_최소스패닝트리 {
	static int v, e, a, b, c;
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer str;
	static ArrayList<Edge> edgeList = new ArrayList<Edge>();
	private static int[] parents;
	
	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		str = new StringTokenizer(br.readLine());
		v = Integer.parseInt(str.nextToken());
		e = Integer.parseInt(str.nextToken());
		for (int i = 0; i < e; i++) {
			str = new StringTokenizer(br.readLine());
			a = Integer.parseInt(str.nextToken());
			b = Integer.parseInt(str.nextToken());
			c = Integer.parseInt(str.nextToken());

			edgeList.add(new Edge(a, b, c));
		}
		
		parents = new int[v+1];
		
		// 정렬
		Collections.sort(edgeList, new Comparator<Edge>(){
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.weight - o2.weight;
			}
        });
		
		// 동작
		make();
		int result = 0;
		int count = 0;
		for (Edge edge : edgeList) {
			if (union(edge.start, edge.end)) {
				result += edge.weight;
				count++;
				if (count == v - 1)
					break;
			}
		}
		System.out.println(result);
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
		for (int i = 1; i <= v; i++) {
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
