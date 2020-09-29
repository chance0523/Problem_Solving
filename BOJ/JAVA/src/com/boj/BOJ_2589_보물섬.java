package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2589_보물섬 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int n, m;
	static char[][] map;
	static int[][] distance;
	static boolean[][] visited;
	static ArrayList<Integer> result = new ArrayList<Integer>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");

		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);

		map = new char[n][m];
		distance = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = tmp[j];
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'L') {
					bfs(new dot(i, j));
					// 초기화는 필수이다.
					for (int k = 0; k < n; k++) {
						Arrays.fill(visited[k], false);
						Arrays.fill(distance[k], 0);
					}
				}
			}
		}

		System.out.println(Collections.max(result));
	}

	static void bfs(dot d) {
		Queue<dot> q = new LinkedList<dot>();
		q.add(d);
		visited[d.x][d.y] = true;

		while (!q.isEmpty()) {
			dot t = q.poll();
			int x1 = t.x;
			int y1 = t.y;

			for (int i = 0; i < 4; i++) {
				int x2 = x1 + dx[i];
				int y2 = y1 + dy[i];

				if (x2 >= 0 && x2 < n && y2 >= 0 && y2 < m && map[x2][y2] == 'L' && !visited[x2][y2]) {
					q.add(new dot(x2, y2));
					visited[x2][y2] = true;
					distance[x2][y2] = distance[x1][y1] + 1;
				}
			}
		}

		result.add(findMax(distance));
	}

	static int findMax(int[][] arr) {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (max <= arr[i][j]) {
					max = arr[i][j];
				}
			}
		}

		return max;
	}

}

class dot {
	int x;
	int y;

	public dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}