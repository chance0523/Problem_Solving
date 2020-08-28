package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15787_기차가어둠을헤치고은하수를 {
	static BufferedReader br;
	static StringTokenizer str;
	static int n, m;
	static int op, i, x;
	static int[] map;
	static boolean[] check;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		str = new StringTokenizer(br.readLine());
		n = Integer.parseInt(str.nextToken());
		m = Integer.parseInt(str.nextToken());
		map = new int[n + 1];
		check = new boolean[1 << 21];
		for (int k = 0; k < m; k++) {
			str = new StringTokenizer(br.readLine());
			op = Integer.parseInt(str.nextToken());
			i = Integer.parseInt(str.nextToken());
			switch (op) {
			case 1:
				x = Integer.parseInt(str.nextToken());
				map[i] |= (1 << x);
				break;
			case 2:
				x = Integer.parseInt(str.nextToken());
				map[i] &= ~(1 << x);
				break;
			case 3:
				map[i] = map[i] << 1;
				map[i] &= (1 << 21) - 1; // 하차 처리
				break;
			case 4:
				map[i] = map[i] >> 1;
				map[i] = map[i] & ~1; // 하차 처리
				break;
			default:
				break;
			}

		}
		int ans = 0;

		for (int i = 1; i <= n; i++) {
			if (!check[map[i]]) {
				ans++;
				check[map[i]] = true;
			}
		}

		System.out.println(ans);
	}
}
