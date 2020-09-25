package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13300_방배정 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n, k, s, y;
	static int[][] room;
	static int ans;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		room = new int[7][2]; // 0학년은 빼준다.
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken()); // 성별
			y = Integer.parseInt(st.nextToken()); // 학년
			room[y][s]++; // 해당 방의 인원수를 늘려준다.
		}

		int ans = 0;
		for (int i = 1; i < 7; i++) {
			for (int j = 0; j < 2; j++) {
				if (room[i][j] == 0) // 방에 아무도 없으면 무시
					continue;
				
				// 딱 k명의 배수이면 num/k만큼의 방
				if (room[i][j] % k == 0)
					ans += room[i][j] / k;
				// 그 외에는 하나씩 더 필요
				else
					ans += room[i][j] / k + 1;
			}
		}
		System.out.println(ans);
	}
}
