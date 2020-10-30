package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14466_소가길을건너간이유6 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n, k, r, a1, a2, b1, b2;
	static ArrayList<int[]>[][] map;
	static int ans;
	static ArrayList<int[]> cow;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		map = new ArrayList[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			a1 = Integer.parseInt(st.nextToken());
			b1 = Integer.parseInt(st.nextToken());
			b1 = Integer.parseInt(st.nextToken());
			a2 = Integer.parseInt(st.nextToken());
			map[a1][b1].add(new int[] { a2, b2 });
			map[a2][b2].add(new int[] { a1, b1 });
		}
		
		cow = new ArrayList<int[]>();

		for (int i = 0; i < k; i++) {
			cow.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}

		// 동작
		ans = 0;
		for (int i = 0; i < k - 1; i++) {
			for (int j = i + 1; j < k; j++) {
				if (!canMeet(cow.get(i)[0], cow.get(i)[1], cow.get(j)[0], cow.get(j)[1]))
					ans++;
			}
		}
		System.out.println(ans);
	}

	static boolean flag;

	private static boolean canMeet(int cr1, int cc1, int cr2, int cc2) {

		return false;
	}
}
