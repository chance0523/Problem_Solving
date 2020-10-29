package com.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1249_보급로 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int t, n, r, c, cost, nr, nc,ncost;
	static int[][] map;
	static int[][] dist;
	static int ans;
	static Queue<int[]> q;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// 동작
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			dist = new int[n][n];
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = str.charAt(j) - '0';
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			bfs();
			bw.write("#" + tc + " " + dist[n-1][n-1] + "\n");
		}
		bw.flush();
		bw.close();
	}

	private static void bfs() {
		q = new LinkedList<>();
		q.offer(new int[] { 0, 0, 0 });
		dist[0][0] = 0;
		while (!q.isEmpty()) {
			r = q.peek()[0];
			c = q.peek()[1];
			cost = q.peek()[2];
			q.poll();
			for (int dir = 0; dir < 4; dir++) {
				nr = r + dx[dir];
				nc = c + dy[dir];
				if (nr != -1 && nc != -1 && nr != n && nc != n) {
					ncost = cost + map[nr][nc];
					if(ncost<dist[nr][nc]) {
						dist[nr][nc] = ncost;
						q.offer(new int[] {nr,nc,dist[nr][nc]});
					}
				}
			}
		}
	}
}
