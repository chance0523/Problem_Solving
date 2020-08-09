package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_4963_섬의개수 {
	static int w, h;
	static int[][] map;
	static int ans;
	static int[][] visited;
	// 상하좌우 북동 남동 남서 북서
	static int[] dx = { -1, 1, 0, 0, -1, 1, 1, -1 };
	static int[] dy = { 0, 0, -1, 1, 1, 1, -1, - 1 };
	static Stack<Integer> s;
	static int r, c;
	static int nr, nc;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		while (true) {
			// 입력
			str = new StringTokenizer(br.readLine());
			w = Integer.parseInt(str.nextToken());
			h = Integer.parseInt(str.nextToken());
			if (w == 0 && h == 0)
				break;
			map = new int[h][w];
			s = new Stack<Integer>();
			ans = 0;
			for (int i = 0; i < h; i++) {
				str = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(str.nextToken());
					if (map[i][j] == 1) {
						s.push(i);
						s.push(j);
					}
				}
			}
//			System.out.println(s.toString());
			// 동작
			while (!s.isEmpty()) {
				c = s.pop();
				r = s.pop();
				if (map[r][c] == 1) {
					dfs(r, c);
					ans++;
				}
			}
			System.out.println(ans);
		}
	}

	static void dfs(int r, int c) {
		map[r][c] = 2; // 방문표시
		for (int dir = 0; dir < 8; dir++) {
			nr = r + dx[dir];
			nc = c + dy[dir];
			if (nr != -1 && nc != -1 && nr != h && nc != w) {
				if (map[nr][nc] == 1) {
					dfs(nr,nc); // 그곳에서  dfs
				}
			}
		}
	}
}
