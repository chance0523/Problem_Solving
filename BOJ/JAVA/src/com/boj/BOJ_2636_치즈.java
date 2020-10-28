package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636_치즈 {
	static BufferedReader br;
	static StringTokenizer st;
	static int x, y;
	static int[][] map;
	static int t, remainBefore;
	static int remain;
	static Queue<int[]> list;
	static Queue<int[]> list2;
	static ArrayList<int[]> forMelt;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int size;
	static int cnt;
	static int cr, cc, r, c, nr, nc;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		list = new LinkedList<int[]>(); // 치즈가 있는곳
		list2 = new LinkedList<int[]>(); // bfs
		forMelt = new ArrayList<int[]>(); // 녹을 곳
		map = new int[x][y];
		for (int i = 0; i < x; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < y; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					list.offer(new int[] { i, j });
			}
		}

		// 동작
		// 이 칸에서 0을 따라 모서리로 갈 수 있다면 녹는다.
		t = 0;
		size = list.size();
		cnt = 0;
		visited = new boolean[x][y];
		remain = size;

		while (true) {
			remainBefore = remain;
			cr = list.peek()[0];
			cc = list.peek()[1];
			list2.clear();
			list2.add(new int[] { cr, cc });
			list.poll(); // 일단 빼줌
			if (!canMelt()) { // 안 녹으면 다시 넣어줌
				list.add(new int[] { cr, cc });
			} else { // 녹을 수 있다면
				forMelt.add(new int[] { cr, cc });
			}
			cnt++;

			if (cnt == size) { // 리스트 한 번 다 돌았다면
				while (!forMelt.isEmpty()) {
					map[forMelt.get(0)[0]][forMelt.get(0)[1]] = 0;
					forMelt.remove(0);
				}
				t++; // 한 시간 카운트
				remain = list.size(); // 현재 남은 치즈 조각 개수
				size = list.size(); // 사이즈 업데이트
				cnt = 0;
				if (remain == 0) { // 다 녹았다면
					System.out.println(t);
					System.out.println(remainBefore);
					break;
				}
			}
		}

	}

	private static boolean canMelt() {
		initVisited();

		while (!list2.isEmpty()) {
			r = list2.peek()[0];
			c = list2.peek()[1];
			list2.poll();
			if (r == 0 || r == x - 1 || c == 0 || c == y - 1) { // 모서리는 녹음
				return true;
			}
			for (int dir = 0; dir < 4; dir++) {
				nr = r + dx[dir];
				nc = c + dy[dir];
				if (map[nr][nc] == 0 && !visited[nr][nc]) {
					list2.add(new int[] { nr, nc });
					visited[nr][nc] = true;
				}
			}
		}
		return false;
	}

	private static void initVisited() {
		for (int i = 0; i < x; i++) {
			Arrays.fill(visited[i], false);
		}
	}
}
