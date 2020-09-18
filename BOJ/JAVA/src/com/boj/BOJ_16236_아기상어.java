package com.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int n, m, ans, cnt;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[] baby;
	static int babysize;
	static ArrayList<Fish> f;
	static int mindist;
	static boolean[][] visited;
	static int[][] distance;
	static Fish shark;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		baby = new int[2];
		babysize = 2;
		visited = new boolean[n][n];
		f = new ArrayList<Fish>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) { // 아기 상어 위치
					shark = new Fish(i, j, babysize);
					map[i][j] = 0;
				}
				if (map[i][j] >= 1 && map[i][j] <= 6)
					f.add(new Fish(i, j, map[i][j]));
			}
		}
		// 동작 (아기상어 9, 크기 2)
		// 크기가 작은 물고기는 먹을 수 있고
		// 크기가 같은 물고기는 먹을 수 없지만, 그 칸은 지나갈 수 있다.
		// 크기가 큰 물고기가 있는 칸은 지나갈 수 없다.
		// 거리가 가장 가까운 물고기
		// 그런 물고기가 많다면 가장 위 -> 왼쪽 위
		// 자신의 크기와 같은 수의 물고기를 먹을 때마다 크기가 1 증가

		ans = 0;
		int br = shark.x;
		int bc = shark.y;
		int size = shark.size; // 상어의 크기
		int cnt = 0; // 지금까지 먹은 물고기 마리수
		while (true) {
			distance = new int[n][n];
			getDistance(br, bc, size); // distance 배열을 세팅해줌
			ArrayList<Fish> eat = new ArrayList<Fish>(); // 먹을 수 있는 물고기 리스트
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] > 0 && map[i][j] < size && distance[i][j] != 0) { // 먹을 수 있는 물고기
						eat.add(new Fish(i, j, map[i][j]));
					}
				}
			}

			if (eat.size() == 0) {
				// 먹을 수 있는 물고기가 없음
				break;
			} else if (eat.size() == 1) {
				// 딱 한마리 먹을 수 있음
				// 먹음
				Fish one = eat.get(0);
				eat.remove(0);
				br = one.x; // 그 위치로
				bc = one.y; // 이동
				ans += distance[br][bc];
				// 사이즈 체크
				cnt++;
				if (cnt == size) {
					size++;
					cnt = 0;
				}
			} else { // 여러마리
				int minr = Integer.MAX_VALUE;
				int minc = Integer.MAX_VALUE;
				int minidx = 0;
				int mind = Integer.MAX_VALUE;
				for (int i = 0; i < eat.size(); i++) {
					int r = eat.get(i).x;
					int c = eat.get(i).y;
					if (mind > distance[r][c]) { // 가장 가까운
						mind=distance[r][c];
						minr = r;
						minc = c;
						minidx = i;
					}
					else if(mind == distance[r][c]) { // 동일 거리
						if (r < minr) { // 가장 위
							minr = r;
							minc = c;
							minidx = i;
						} else if (r == minr) { // 여러개면
							if (c < minc) { // 가장 왼쪽
								minc = c;
								minidx = i;
							}
						}
					}
				}

				// 가장 왼쪽 위를 찾았다.
				// 먹는다.
				br = minr;
				bc = minc;
				cnt++;
				if (cnt == size) {
					size++;
					cnt = 0;
				}
				ans += distance[br][bc];
				eat.remove(minidx);
			}
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
	}

	private static void getDistance(int br, int bc, int size) {
		visited = new boolean[n][n];
		Queue<Fish> q = new LinkedList<Fish>();
		q.add(new Fish(br, bc, size)); // 이건 상어
		visited[br][bc] = true;
		map[br][bc] = 0;
		Fish shark = q.peek(); // 상어
		while (!q.isEmpty()) {
			Fish f = q.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nr = f.x + dx[dir];
				int nc = f.y + dy[dir];
				if (nr >= 0 && nc >= 0 && nr < n && nc < n && !visited[nr][nc] && map[nr][nc] <= shark.size) { // 지나갈 수
																												// 있음
					distance[nr][nc] = distance[f.x][f.y] + 1;
					visited[nr][nc] = true;
					q.offer(new Fish(nr, nc, size)); // 이건 물고기
				}
			}
		}
	}

	static class Fish {
		int x;
		int y;
		int size;

		public Fish(int x, int y, int size) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
		}

	}
}
