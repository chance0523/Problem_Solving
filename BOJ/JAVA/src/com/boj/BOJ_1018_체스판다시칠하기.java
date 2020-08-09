package com.boj;

import java.util.*;
import java.io.*;

public class BOJ_1018_체스판다시칠하기 {
	static int n, m;
	static String str;
	static char[][] board;
	static int mincnt;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new char[n][m];
		// 체스판 입력
		for (int i = 0; i < n; i++) {
			str = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = str.charAt(j);
			}
		}

		// 0,0이 W일때
		mincnt = Integer.MAX_VALUE;
		cnt = 0;
		for (int x = 0; x <= n - 8; x++) {
			for (int y = 0; y <= m - 8; y++) {
				// 8x8비교
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if ((x + y + i + j) % 2 == 0) {
							if (board[x + i][y + j] == 'B') {
								// 바꿔줘야함
								cnt++;
							}
						} else {
							if (board[x + i][y + j] == 'W') {
								cnt++;
							}
						}
					}
				}
				if (cnt < mincnt) // 최솟값 비교
					mincnt = cnt;
				cnt=0;
			}
		}
		

		for (int x = 0; x <= n - 8; x++) {
			for (int y = 0; y <= m - 8; y++) {
				// 8x8비교
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if ((x + y + i + j) % 2 == 0) {
							if (board[x + i][y + j] == 'W') {
								// 바꿔줘야함
								cnt++;
							}
						} else {
							if (board[x + i][y + j] == 'B') {
								cnt++;
							}
						}
					}
				}
				if (cnt < mincnt) // 최솟값 비교
					mincnt = cnt;
				cnt=0;
			}
		}
		bw.write(mincnt + "\n");
		bw.flush();
		bw.close();
	}
}
