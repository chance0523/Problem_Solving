package com.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_15961_회전초밥 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer str;
	static int n, d, k, c;
	static int ans;
	static int[] sushi;
	static int[] ate;
	static int kind;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		str = new StringTokenizer(br.readLine());
		n = Integer.parseInt(str.nextToken()); // 접시 수
		d = Integer.parseInt(str.nextToken()); // 가짓수
		k = Integer.parseInt(str.nextToken()); // 연속 접시
		c = Integer.parseInt(str.nextToken()); // 쿠폰 번호
		sushi = new int[n * 2];
		for (int i = 0; i < n; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < k; i++) {
			sushi[n + i] = sushi[i];
		}
		ate = new int[d + 1];
		kind = 0;
		eat(c);

		for (int i = 0; i < k - 1; i++) {
			eat(sushi[i]); // k-1개 연속으로 먹어보고
		}

		for (int i = 0; i < n; i++) { // 슬라이딩 윈도우
			eat(sushi[i + k - 1]); // 그 다음 먹기를 시도
			ans = Math.max(ans, kind); // 현재까지 먹은 초밥의 종류
			del(sushi[i]); // 맨 처음 것을 삭제 시도
		}
		System.out.println(ans);
	}

	private static void eat(int s) {
		if (ate[s] == 0) // 안 먹었던거라면
			kind++; // 먹은 초밥 종류 늘리고
		ate[s]++; // 체크
	}

	private static void del(int s) {
		ate[s]--;
		if (ate[s] == 0)
			kind--;
	}
}
