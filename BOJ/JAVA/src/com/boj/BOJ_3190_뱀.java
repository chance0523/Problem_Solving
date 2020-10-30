package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_3190_뱀 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n, k, l, r, c, ans;
	static int[][] map;
	static char command;
	static int[][] com;
	static List<int[]> snake;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken()) - 1; // 1씩 빼줌
			c = Integer.parseInt(st.nextToken()) - 1;
			map[r][c] = 1; // 사과
		}

		l = Integer.parseInt(br.readLine());
		com = new int[l][2];
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			com[i][0] = Integer.parseInt(st.nextToken());
			command = st.nextToken().charAt(0);
			if (command == 'L') // L, D 구분
				com[i][1] = -1;
			else
				com[i][1] = 1;
		}

		// 동작
		snake = new LinkedList<int[]>();
		snake.add(new int[] { 0, 0 }); // 시작 위치

		ans = 0;
		func(0, 0, 0); // 시작 방향 오른쪽

		System.out.println(ans);
	}

	static int nr, nc, nd;
	// 방향 순서 : 우하좌상
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	private static void func(int cr, int cc, int cd) { // current r, c, dir
		int turn = 0; // 방향 전환 횟수
		while (true) {
			ans++; // 1초 뒤
			nr = cr + dx[cd];
			nc = cc + dy[cd];

			// 종료 조건
			if (nr == -1 || nc == -1 || nr == n || nc == n) // 벽에 닿았을 경우
				return;

			// 몸통과 닿은 경우
			for (int i = 0; i < snake.size(); i++) {
				if (nr == snake.get(i)[0] && nc == snake.get(i)[1])
					return;
			}

			if (map[nr][nc] == 1) { // 사과를 먹은 경우
				// 사과가 없어지고 그 칸을 추가
				snake.add(new int[] { nr, nc });
				map[nr][nc] = 0;
			} else { // 아무 칸이 아닌 경우
				snake.add(new int[] { nr, nc }); // 칸 추가
				snake.remove(0); // 꼬리 제거
			}

			cr = nr; // 이곳으로 머리 위치
			cc = nc;

			if (turn < l) { // 방향전환이 아직 안 끝났다면
				if (ans == com[turn][0]) { // 방향 전환
					nd = (cd + com[turn][1]) % 4;
					if (nd == -1)
						nd = 3;
					cd = nd; // 방향 덮어쓰기
					turn++;
				}
			}
		}
	}

}
