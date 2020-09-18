package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로 {
	static class Edge {
		int vertex;
		int cost;

		public Edge(int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}

	}

	static BufferedReader br;
	static StringTokenizer st;
	static int V, E, K;
	static ArrayList<ArrayList<Edge>> adj;
	static int v1, v2, c;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

		adj = new ArrayList<ArrayList<Edge>>();

		for (int i = 0; i <= V; i++) {
			adj.add(new ArrayList<Edge>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj.get(v1).add(new Edge(v2, c));
		}

		
		// 동작
		
		int[] vCost = new int[V + 1];
		Arrays.fill(vCost, Integer.MAX_VALUE);

		PriorityQueue<Edge> pq = new PriorityQueue<Edge>((e1, e2) -> e1.cost - e2.cost);
		boolean[] visit = new boolean[V + 1];

		pq.add(new Edge(K, 0)); 

		vCost[K] = 0;

		while (!pq.isEmpty()) {
			Edge e = pq.poll();

			if (visit[e.vertex])
				continue;
			visit[e.vertex] = true;

			for (Edge ne : adj.get(e.vertex)) {
				if(vCost[ne.vertex]>vCost[e.vertex]+ne.cost) {
					vCost[ne.vertex] = vCost[e.vertex]+ne.cost;
					pq.add(new Edge(ne.vertex,vCost[ne.vertex]));
				}
			}
		}

		// 출력
		for (int i = 1; i <= V; i++) {
			if (!visit[i])
				System.out.println("INF");
			else {
				System.out.println(vCost[i]);
			}
		}
	}
}
