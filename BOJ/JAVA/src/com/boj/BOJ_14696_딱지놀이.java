package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14696_딱지놀이 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n, a, b;
	static int[] A;
	static int[] B;
	static int ans;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());

		// 동작
		for (int i = 0; i < n; i++) {
			// 한 라운드
			// A
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			A = new int[a];
			for (int j = 0; j < a; j++) {
				A[j] = Integer.parseInt(st.nextToken());
			}

			// B
			st = new StringTokenizer(br.readLine());
			b = Integer.parseInt(st.nextToken());
			B = new int[b];
			for (int j = 0; j < b; j++) {
				B[j] = Integer.parseInt(st.nextToken());
			}

			System.out.println(Winner()); // 라운드의 결과 출력
		}
	}

	private static char Winner() {
		// 세모 : 1, 네모 : 2, 동그라미 : 3, 별 : 4

		char winner;
		// 1단계 : 별의 개수 세기
		winner = Match(4);
		if(winner!='D') // 개수가 다르다면
			return winner;
		// 2단계 : 동그라미 개수 세기
		winner = Match(3);
		if(winner!='D')
			return winner;
		// 3단계 : 네모 개수 세기
		winner = Match(2);
		if(winner!='D')
			return winner;
		// 4단계 세모 개수 세기
		winner = Match(1);
		return winner; // 여기까지 비겼으면 비긴거라 D도 반환
	}

	private static char Match(int shape) {
		int cnt1 = 0;
		int cnt2 = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == shape)
				cnt1++;
		}
		for (int i = 0; i < B.length; i++) {
			if (B[i] == shape)
				cnt2++;
		}

		// 모양의 개수가 더 많은 쪽이 승리
		if (cnt1 > cnt2)
			return 'A';
		else if (cnt1 < cnt2)
			return 'B';
		else
			return 'D';
	}
}
