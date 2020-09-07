package com.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17129_윌리암슨수액빨이딱따구리가정보섬에올라온이유 {
	static BufferedReader br;
	static StringTokenizer st;
	static BufferedWriter bw;
	static int n, m;
	static int[][] map;
	static int sr, sc;
	static Queue<Integer[]> q;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		q = new LinkedList<Integer[]>();
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
				if (map[i][j] == 2) {
					q.offer(new Integer[] { i, j ,1});
					map[i][j] = 0;
				}
			}
		}
		// 0:빈 복도, 1:장애물
		// 2:식구, 3:청국장, 4:스시, 5:맥앤치즈 (지나갈수있음)
		// 시작점은 딱다구리(2)의 위치
		while (!q.isEmpty()) {
			int cr = q.peek()[0];
			int cc = q.peek()[1];
			int cnt = q.peek()[2];
			q.poll();
			if (visited[cr][cc])
				continue;
			visited[cr][cc] = true;
			for (int dir = 0; dir < 4; dir++) {
				int nr = cr + dx[dir];
				int nc = cc + dy[dir];
				if (nr >= 0 && nc >= 0 && nr < n && nc < m && !visited[nr][nc] && map[nr][nc]!=1) {
					if(map[nr][nc]==0) {
						q.offer(new Integer[] {nr,nc,cnt+1});
						continue;
					}
					else { // 무언가 만났을 때
						bw.write("TAK\n"+cnt+"\n");
						bw.flush();
						bw.close();
						return;
					}
				}
			}
		}
		bw.write("NIE"+"\n");
		bw.flush();
		bw.close();
	}
}
