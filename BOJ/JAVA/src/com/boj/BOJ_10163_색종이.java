package com.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10163_색종이 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[101][101]; // 가로 세로 101칸
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // 왼쪽 아래
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken()); // 너비
			int h = Integer.parseInt(st.nextToken()); // 높이
			for (int j = x; j < x + w; j++) {
				for (int k = y; k < y + h; k++) {
					map[j][100 - k] = i + 1; // 마스킹. 좌표에 주의
				}
			}
		}

		for (int k = 1; k <= n; k++) { // 각 번호마다 세준다.
			int ans = 0;
			for (int i = 0; i < 101; i++) {
				for (int j = 0; j < 101; j++) {
					if (map[i][j] == k) // 이 번호와 같은 수
						ans++;
				}
			}
			bw.write(ans+"\n");
		}
		bw.flush();
		bw.close();
	}
}
