package com.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_8972_미친아두이노 {
	static BufferedReader br;
	static StringTokenizer st;
	static BufferedWriter bw;
	static int r, c;
	static char[][] map;
	static int[] op;
	static int ir, ic;
	static ArrayList<int[]> crazy;
	static int ans = 0;
	static int[] dr = { 1, 1, 1, 0, 0, 0, -1, -1, -1 };
	static int[] dc = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		input(); // 입력
		boolean flag = true;
		for (int i = 0; i < op.length; i++) {
			if (!moveI(op[i] - 1)) { // 종수가 움직임
				flag = false;
				break;
			}
			if (!moveCrazy()) { // 미친 아두이노 움직여줌. 종수와 겹치면 끝
				flag = false;
				break;
			}
			drawMap(); // 지도 업데이트 (폭발포함)
		}
		if (flag)
			printAns();
		else
			System.out.println("kraj " + ans); // 이걸 krag로 써서 틀림
	}

	private static boolean moveI(int dir) {
		// 보드를 벗어나는 입력은 주어지지 않는다.
		ir += dr[dir]; // 움직이고
		ic += dc[dir];
		ans++; // 카운트
		if (map[ir][ic] == 'R')
			return false;
		return true;
	}

	private static void drawMap() {
		int[][] newmap = new int[r][c];
		newmap[ir][ic] = -1; // 종수 (미친 아두이노와 구분. 이미 터졌으면 전에 터졌음)
		for (int i = 0; i < crazy.size(); i++) {
			int cr = crazy.get(i)[0];
			int cc = crazy.get(i)[1];
			newmap[cr][cc]++; // 미친 아두이노 체크
		}
		crazy = new ArrayList<int[]>(); // 미친 아두이노 리스트 업데이트
		for (int i = 0; i < r; i++) { // 지도 업데이트
			for (int j = 0; j < c; j++) {
				if (newmap[i][j] == -1)
					map[i][j] = 'I';
				else if (newmap[i][j] >= 2) // 터짐
					map[i][j] = '.';
				else if (newmap[i][j] == 1) { // 미친 아두이노 단 하나
					map[i][j] = 'R';
					crazy.add(new int[] { i, j });
				} else
					map[i][j] = '.';
			}
		}

	}

	private static boolean moveCrazy() {
		for (int i = 0; i < crazy.size(); i++) {
			int cr = crazy.get(i)[0];
			int cc = crazy.get(i)[1];
			int mind = 10000; // 아두이노와 종수 사이의 거리
			int go = 0; // 이 방향으로 이동
			for (int dir = 0; dir < 9; dir++) {
				if (dir == 4) // 8가지 방향
					continue;
				int nr = cr + dr[dir];
				int nc = cc + dc[dir];
				if (nr >= 0 && nc >= 0 && nr < r && nc < c) { // 경계조건
					int d = Math.abs(nr - ir) + Math.abs(nc - ic);
					if (mind > d) {
						mind = d;
						go = dir;
					}
				}
			}
			// 이동시켜줌
			crazy.set(i, new int[] { cr + dr[go], cc + dc[go] }); // set 사용
			if (crazy.get(i)[0] == ir && crazy.get(i)[1] == ic) { // 종수와 만날때
				return false;
			}
		}
		return true;
	}

	private static void printAns() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		crazy = new ArrayList<int[]>();
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
				// R : 미친 아두이노, I : 종수의 위치
				if (map[i][j] == 'I') { // 종수의 위치
					ir = i;
					ic = j;
				} else if (map[i][j] == 'R') { // 미친 아두이노
					crazy.add(new int[] { i, j });
				}
			}
		}
		String str = br.readLine();
		op = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			op[i] = str.charAt(i) - '0';
		}

	}

}
