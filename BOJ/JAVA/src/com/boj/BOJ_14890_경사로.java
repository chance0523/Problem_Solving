package com.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14890_경사로 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int t, n, x, ans;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		x = Integer.parseInt(st.nextToken()); // 경사로의 길이
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = 0;
		// 동작
		for (int i = 0; i < n; i++) {
			if (isGaro(i)) {
				System.out.println(i);
				ans++;
			}
//			if (isSero(i))
//				ans++;
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
	}

	// 경사로를 놓았을때 잘 연결 되는지
	// 놓아야할 곳은 무조건 놓아야한다.
	private static boolean isGaro(int r) {

		boolean flag = false;
		// 평지인지 체크
		for (int i = 1; i < n; i++) {
			if (map[r][0] == map[r][i]) {
				flag = true; // 경사로는 못 놓지만 안전
			} else {
				flag = false;
				break;
			}
		}
		if (flag) {
			System.out.println("all 평지 " + r);
			return true; // 평지면 ok
		}

		// 평지가 아닐때
		// 오른쪽으로 가면서 체크
		for (int i = 0; i < n - x; i++) {
			for (int j = i + 1; j < x; j++) {
				if (map[r][i] == map[r][j] + 1) {
					flag = true; // 경사로 놓아야 함
				} else {
					flag = false;
					break;
				}

			}
			if (flag) { // 경사로 놓을 수 있는 곳이면 x만큼 건너뜀
				i += x;
				flag = false;
			}
		}
		if (flag) {
			System.out.println("오른쪽으로 가면서 " + r);
			return true;
		}

		// 왼쪽으로 가면서 체크
		for (int i = n - 1; i >= x; i--) {
			for (int j = i - 1; j >= i - x; j--) {
				if (map[r][i] == map[r][j] + 1) {
					flag = true; // 경사로 놓아야 함
				} else {
					flag = false;
					break;
				}

			}
			if (flag) { // 경사로 놓을 수 있는 곳이면 x만큼 건너뜀
				i -= x;
			}

		}
		if (flag) {
			System.out.println("왼쪽으로 가면서 " + r);
			return true;
		}

		return false;
	}

	private static boolean isSero(int c) {
		boolean flag = false;
		// 평지인지 체크
		for (int i = 1; i < n; i++) {
			if (map[c][0] == map[c][i]) {
				flag = true; // 경사로는 못 놓지만 안전
			} else {
				flag = false;
				break;
			}
		}
		if (flag) {
			return true; // 평지면 ok
		}
		return false;
	}
}