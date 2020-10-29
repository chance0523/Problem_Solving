package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14468_소가길을건너간이유2 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n, num, loc, ans;
	static int[][] cow;
	static char[] map;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		map = br.readLine().toCharArray();
		cow = new int[26][2];
		for (int i = 0; i < 52; i++) {
			num = map[i] - 'A';
			if (cow[num][0] == 0) // 처음 나온거라면
				cow[num][0] = i + 1; // 1부터 시작하기 위함
			else // 두번째 나온거라면
				cow[num][1] = i + 1;
		}

		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {
				// i0 j0 i1 j1
				if (cow[i][0] < cow[j][0] && cow[j][0] < cow[i][1] && cow[i][1] < cow[j][1])
					ans++;
			}
		}

		// 출력
		System.out.println(ans);
	}
}
