package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_3042_트리플렛 {
	static BufferedReader br;
	static int n, ans;
	static char[][] map;
	static ArrayList<int[]> list;
	static int[] numbers;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// 동작
		list = new ArrayList<int[]>();
		// 알파벳이 써 있는 곳의 좌표를 넣는다.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != '.')
					list.add(new int[] { i, j });
			}
		}

		numbers = new int[3];
		ans = 0;
		comb(0, 0); // 세 좌표의 조합
		System.out.println(ans);
	}

	private static void comb(int start, int cnt) {
		if (cnt == 3) {
			// 세 좌표를 다 뽑았다면
			isLinear(); // 일직선인지 확인
			return;
		}

		for (int i = start; i < list.size(); i++) {
			numbers[cnt] = i;
			comb(i + 1, cnt + 1);
		}
	}

	static int x1, x2, x3, y1, y2, y3, a1, a2, a3;

	private static void isLinear() {
		// 세 좌표 만들어주기
		x1 = list.get(numbers[0])[0];
		y1 = list.get(numbers[0])[1];
		x2 = list.get(numbers[1])[0];
		y2 = list.get(numbers[1])[1];
		x3 = list.get(numbers[2])[0];
		y3 = list.get(numbers[2])[1];

		// 기울기를 구하면 실수값이 나올 수 있음
		// (y1-y2)*(x2-x3) vs (x1-x2)*(y2-y3) 같은 방식으로 구함
		// 12-23 / 23-31 / 31-12
		if ((y1 - y2) * (x2 - x3) == (x1 - x2) * (y2 - y3) && 
			(y2 - y3) * (x3 - x1) == (x2 - x3) * (y3 - y1) && 
			(y3 - y1) * (x1 - x2) == (x3 - x1) * (y1 - y2)) {
			ans++;
		}
	}
}
