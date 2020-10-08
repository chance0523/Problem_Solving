package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18443_우체국2 {
	static BufferedReader br;
	static StringTokenizer st;
	static int v, p, l;
	static int[] vill;
	static int[] D;
	static int[][] C, dist;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		vill = new int[v];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < v; i++) {
			vill[i] = Integer.parseInt(st.nextToken());
		}

		// 동작
		D = new int[v];
		C = new int[v][v];
		dist = new int[v][v]; // 각 마을들 사이의 거리 (누적합으로)

		// 각 마을들 사이의 거리
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				dist[i][j] = Math.min(Math.abs(vill[i] - vill[j]), l - Math.abs(vill[i] - vill[j]));
			}
		}
//		for (int i = 0; i < v; i++) {
//			for (int j = 0; j < v; j++) {
//				System.out.print(dist[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		// 누적합으로 만들어주기
		for (int i = 0; i < v; i++) {
			for (int j = 1; j < v; j++) {
				dist[i][j] = dist[i][j - 1] + dist[i][j];
			}
		}

//		for (int i = 0; i < v; i++) {
//			for (int j = 0; j < v; j++) {
//				System.out.print(dist[i][j]+" ");
//			}
//			System.out.println();
//		}
//
//		System.out.println();
		// D(N, K) = 처음 N개의 마을만 고려했을 때, 우체국을 K개 설치하는 최소 거리
		// C(s, e) = s번째 마을부터 e번째 마을까지 "한 개"의 우체국을 설치해서 만드는 최소 거리
		// D(N, K) = min{ D(i, K-1) + C(i+1, N) }

		// C 배열 채우기
		for (int i = 0; i < v - 1; i++) {
			for (int j = i + 1; j < v; j++) {
				getC(i, j);
			}
		}

		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				System.out.print(C[i][j] + " ");
			}
			System.out.println();
		}

		// D 배열 채우기
		for (int i = 0; i < v; i++) {
			int temp = Integer.MAX_VALUE;
			for (int j = 0; j < v; j++) {
				temp = Math.min(temp, D[j]+C[j][i]);
			}
		}
	}

	private static void getC(int s, int e) {
		int temp = Integer.MAX_VALUE;
		for (int i = s; i < e; i++) {
			if (s == 0)
				temp = Math.min(temp, dist[i][e]);
			else
				temp = Math.min(temp, dist[i][e] - dist[i][s - 1]);
		}
		C[s][e] = temp;
	}
}
