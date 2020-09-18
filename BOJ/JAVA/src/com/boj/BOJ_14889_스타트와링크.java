package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int[][] map;
	static int ans;
	static int[] numbers;
	static int[] numbers2;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 동작
		numbers = new int[n / 2];
		numbers2 = new int[n / 2];
		ans = Integer.MAX_VALUE;
		// 두 팀의 능력치 차이를 최소로
		
		combinations(0, 0);
		
		System.out.println(ans);
	}

	private static void combinations(int start, int cnt) {
		if (cnt == n / 2) { //
			func();
			return;
		}
		for (int i = start; i < n; i++) {
			numbers[cnt] = i;
			combinations(i + 1, cnt + 1);
		}
	}

	private static void func() {
		boolean flag;
		int k = 0;
		// 링크 팀 멤버 찾기
		for (int i = 0; i < n; i++) {
			flag = true;
			for (int j = 0; j < n / 2; j++) {
				if (i == numbers[j]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				numbers2[k++] = i;
			}
		}

		int t1 = 0; // 스타트팀
		int t2 = 0; // 링크팀
		for (int i = 0; i < n / 2 - 1; i++) {
			for (int j = i + 1; j < n / 2; j++) {
				t1 += map[numbers[i]][numbers[j]];
				t1 += map[numbers[j]][numbers[i]];
				
				t2 += map[numbers2[i]][numbers2[j]];
				t2 += map[numbers2[j]][numbers2[i]];
			}
		}


		ans = Integer.min(ans, Math.abs(t2 - t1)); // 크기비교
	}
}
