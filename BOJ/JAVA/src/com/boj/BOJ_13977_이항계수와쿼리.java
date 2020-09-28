package com.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_13977_이항계수와쿼리 {
	static StringTokenizer st;
	static int n, k;
	static long p, ans;
	static long[] fact;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		long p = 1000000007;
		
		fact = new long[4000001];
		fact[0] = 1;
		// 팩토리얼 배열 채워주기
		for (int i = 1; i <= 4000000; i++) {
			fact[i] = fact[i - 1] * i % p;
		}
		
		// 테스트 케이스마다 실행
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			long ans = nCr(n, k, p);
			bw.write(ans + "\n");
		}
		bw.flush();
		bw.close();
	}

	private static long nCr(int n, int r, long p) {
		if (r == 0)
			return 1L;

		return (fact[n] * power(fact[r], p - 2, p) % p * power(fact[n - r], p - 2, p) % p) % p;
	}

	private static long power(long x, long y, long p) {
		long res = 1L;
		x = x % p;

		while (y > 0) {
			if (y % 2 == 1)
				res = (res * x) % p;
			y = y >> 1;
			x = (x * x) % p;
		}
		return res;
	}
}
