package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194_달이차오른다가자 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n, m;
	static char[][] map;
	static boolean[][][] visited;
	static Queue<int[]> list;
	static int ans;
	static int sr, sc;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new boolean[65][n][m];
		list = new LinkedList<int[]>();
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '0') { // 시작점
					list.offer(new int[] { i, j, 0, 0 }); // r,c,cnt,key
				}
			}
		}

		// 동작
		visited[0][list.peek()[0]][list.peek()[1]] = true;
		boolean flag = false;
		
		while (!list.isEmpty()) {
			int r = list.peek()[0];
			int c = list.peek()[1];
			int cnt = list.peek()[2];
			int key = list.peek()[3];
			
			if (map[r][c] == '1') {
				System.out.println(cnt);
				flag = true;
				break;
			}
			list.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if (nr >= 0 && nc >= 0 && nr < n && nc < m && map[nr][nc] != '#' && !visited[key][nr][nc]) {
					if (map[nr][nc] == '.' || map[nr][nc] == '0' || map[nr][nc] == '1') { // 그냥 갈 수 있는 경우
						visited[key][nr][nc] = true;
						list.offer(new int[] { nr, nc, cnt + 1, key });
					} else if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f') { // 열쇠
						int ckey = key | 1 << (map[nr][nc] - 'a');
						if (visited[ckey][nr][nc])
							continue;
						visited[ckey][nr][nc] = true;
						list.offer(new int[] { nr, nc, cnt + 1, ckey });
					} else if (map[nr][nc] >= 'A' && map[nr][nc] <= 'F') { // 문
						if ((key & (1 << (map[nr][nc] - 'A'))) != 0) { // 이동가능
							visited[key][nr][nc] = true;
							list.offer(new int[] { nr, nc, cnt + 1, key });
						}
					}
				}
			}
		}
		if (!flag) // 빠져나갈 수 없는 경우
			System.out.println(-1);
	}
}
