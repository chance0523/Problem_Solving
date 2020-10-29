package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14467_소가길을건너간이유1 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n, num, loc, ans;
	static int[] map;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n];
		for (int i = 0; i < n; i++) {
			map[i] = -1; // default 값
		}
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken())-1;
			loc = Integer.parseInt(st.nextToken());
			// 0 : 왼쪽, 1 : 오른쪽
			if (map[num] == 0 && loc == 1) // 0->1
				ans++;
			else if (map[num] == 1 && loc == 0) // 1->0
				ans++;
			map[num] = loc;
		}
		System.out.println(ans);
	}
}
