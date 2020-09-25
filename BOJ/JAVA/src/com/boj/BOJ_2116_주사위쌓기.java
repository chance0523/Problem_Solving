package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2116_주사위쌓기 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int[][] dice;
	static int ans;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		dice = new int[10001][6];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			// ABCFDE 순으로 넣어줌
			dice[i][0] = Integer.parseInt(st.nextToken()); // A
			dice[i][1] = Integer.parseInt(st.nextToken()); // B
			dice[i][2] = Integer.parseInt(st.nextToken()); // C
			dice[i][4] = Integer.parseInt(st.nextToken()); // D
			dice[i][5] = Integer.parseInt(st.nextToken()); // E
			dice[i][3] = Integer.parseInt(st.nextToken()); // F
		}
		ans = 0;
		for (int i = 0; i < 6; i++) {
			func(0, dice[0][i], 0); // 면을 돌려가면서 확인한다.
		}
		System.out.println(ans);
	}

	private static void func(int floor, int num, int cnt) {
		if (floor == n) { // 모든 주사위를 쌓았으면
			ans = Math.max(ans, cnt); // 최대값 계산
			return;
		}

		for (int i = 0; i < 6; i++) {
			if (dice[floor][i] == num) { // 면이 같으면
				int sum = 0;
				for (int j = 0; j < 6; j++) {
					// 옆면만 찾기
					if (j == i || (j + 3) % 6 == i)
						continue;
					sum = Math.max(sum, dice[floor][j]); // 옆면에서 최대값으로
				}
				cnt += sum;
				func(floor + 1, dice[floor][(i+3)%6], cnt); // 다음 주사위를 쌓는다
				cnt -= sum; // 처음 주사위 (dice[0])의 다른 면으로 할 때를 위해 빼준다.
			}
		}
	}
}
