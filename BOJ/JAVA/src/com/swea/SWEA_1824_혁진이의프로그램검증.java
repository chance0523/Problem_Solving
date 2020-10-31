package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1824_혁진이의프로그램검증 {
	static BufferedReader br;
	static StringTokenizer st;
	static int t, r, c;
	static char[][] map;
	static boolean flag;
	static int mem;
	static boolean[][][][] visited;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		visited = new boolean[21][21][16][4];
		map = new char[21][21];
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			init();

			for (int i = 0; i < r; i++) {
				String str = br.readLine();
				map[i] = str.toCharArray();
			}

			// @이 있는지 체크. 없으면 바로 NO
			flag = false;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (map[i][j] == '@')
						flag = true;
				}
			}
			if (!flag) {
				System.out.println("#" + tc + " NO");
				continue;
			}

			flag = false;

			// @이 있을 때
			// 초기에는 (0,0) 이동 방향 오른쪽
			mem = 0;
//			visited[0][0][0][0] = true;
			go(0, 0, 0);
			if (flag)
				System.out.println("#" + tc + " YES");
			else
				System.out.println("#" + tc + " NO");
		}
	}

	private static void init() {
		cnt = 0;
		for (int i2 = 0; i2 < 21; i2++) {
			for (int j2 = 0; j2 < 21; j2++) {
				for (int k = 0; k < 16; k++) {
					for (int d = 0; d < 4; d++) {
						visited[i2][j2][k][d] = false;
					}
				}
			}
		}
	}

	// 우하좌상
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static int nr, nc;

	private static void go(int cr, int cc, int dir) { // current
		cnt++;
		if (cnt >= 1000) {
			flag = false;
			return;
		}
//		System.out.println(mem);
		char cur = map[cr][cc];

		// command 처리
		switch (cur) {
		case '<': // 좌
			dir = 2;
			goDir(cr, cc, dir);
			break;
		case '>':
			dir = 0;
			goDir(cr, cc, dir);
			break;
		case '^':
			dir = 3;
			goDir(cr, cc, dir);
			break;
		case 'v':
			dir = 1;
			goDir(cr, cc, dir);
			break;
		case '_':
			if (mem == 0)
				dir = 0; // 우
			else
				dir = 2; // 좌
			goDir(cr, cc, dir);
			break;
		case '|':
			if (mem == 0)
				dir = 1; // 하
			else
				dir = 3; // 상
			goDir(cr, cc, dir);
			break;
		case '?':
			for (dir = 0; dir < 4; dir++) {
				goDir(cr, cc, dir);
			}
			break;
		case '.':
			goDir(cr, cc, dir);
			break;
		case '@':
			flag = true;
			return;
		case '+':
			if (mem == 15)
				mem = 0;
			else
				mem++;
			goDir(cr, cc, dir);
			break;
		case '-':
			if (mem == 0)
				mem = 15;
			else
				mem--;
			goDir(cr, cc, dir);
			break;

		default: // 숫자
			mem = cur - '0';
			goDir(cr, cc, dir);
			break;
		}
	}

	private static void out() {
		// 격자 벗어났을 때 처리
		if (nr == -1)
			nr = r - 1;
		else if (nr == r)
			nr = 0;
		if (nc == -1)
			nc = c - 1;
		else if (nc == c)
			nc = 0;
		return;
	}

	private static void goDir(int cr, int cc, int dir) {
		nr = cr + dx[dir];
		nc = cc + dy[dir];
		out();
		if (visited[nr][nc][mem][dir])
			return;
		else {
			visited[nr][nc][mem][dir] = true;
			go(nr, nc, dir);
		}
	}
}
