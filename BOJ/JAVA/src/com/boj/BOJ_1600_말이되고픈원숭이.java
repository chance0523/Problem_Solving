package com.boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1600_말이되고픈원숭이 {
	static int K, W, H;
	static int[][] map;
	static boolean[][][] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();

		map = new int[H][W];
		visit = new boolean[H][W][31];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		visit[0][0][0] = true;
		solution();

		sc.close();
	}

	// 동서남북 좌우상하(말)
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[] hx = { -2, -2, 2, 2, 1, -1, 1, -1 };
	static int[] hy = { 1, -1, 1, -1, 2, 2, -2, -2 };

	private static void solution() {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(0, 0, 0, K));

		while (!q.isEmpty()) {
			Pair cur = q.poll();
			int curX = cur.x;
			int curY = cur.y;
			int cnt = cur.cnt;
			int curK = cur.k;

			if (curX == W - 1 && curY == H - 1) {
				System.out.println(cnt);
				return;
			}

			if (curX >= W || curY >= H || curX < 0 || curY < 0)
				continue;
			if (map[curY][curX] == 1)
				continue;

			if (visit[curY][curX][curK])
				continue;
			visit[curY][curX][curK] = true;

			for (int i = 0; i < 4; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];

				q.add(new Pair(nextX, nextY, cnt + 1, curK));

			}

			if (curK == 0)
				continue;
			for (int i = 0; i < 8; i++) {
				int nextX = curX + hx[i];
				int nextY = curY + hy[i];

				q.add(new Pair(nextX, nextY, cnt + 1, curK - 1));

			}

		}
		System.out.println("-1");
		return;

	}

	static class Pair {
		int x;
		int y;
		int cnt;
		int k;

		Pair(int x, int y, int cnt, int k) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.k = k;
		}
	}
}