package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_9205_맥주마시면서걸어가기 {
	static BufferedReader br;
	static StringTokenizer st;
	static int t, n;
	static int hr, hc, fr, fc;
	static ArrayList<int[]> con;
	static int beer;
	static boolean flag;
	static int dist;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			beer = 20; // 1000만큼 동안 다 마심
			flag = false;
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			hr = Integer.parseInt(st.nextToken()); // 집
			hc = Integer.parseInt(st.nextToken());
			con = new ArrayList<int[]>();
			for (int i = 0; i < n; i++) { // 편의점
				st = new StringTokenizer(br.readLine());
				con.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
			}
			st = new StringTokenizer(br.readLine());
			fr = Integer.parseInt(st.nextToken()); // 페스티벌
			fc = Integer.parseInt(st.nextToken());

			// 동작
			// 집과 페스티벌 사이의 거리 계산
			dist = getDist(hr, hc, fr, fc);
			if (dist <= 1000) { // 이 경우에는 무조건 맥주와 함께 갈 수 있다.
				System.out.println("happy");
				continue;
			}

			// 그 외의 경우는 중간에 편의점을 들려줘야한다.
			// 모든 점들(집, 편의점, 페스티벌) 사이의 거리를 구해서 집->페스티벌의 정점 사이의 거리가 1000이하이면 happy
			// 플로이드-와샬
			map = new int[n + 2][n + 2];
			fillDist();
			for (int k = 0; k < n + 2; k++) {
				for (int i = 0; i < n + 2; i++) {
					for (int j = 0; j < n + 2; j++) {
						// i->k 거리와 i->j, j->k 거리 비교
						if (map[i][j] > map[i][k] + map[k][j]) {
							map[i][j] = map[i][k] + map[k][j];
						}
					}
				}
			}

			// for debug
//			for (int i = 0; i < n + 2; i++) {
//				for (int j = 0; j < n + 2; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();

			if (map[0][n + 1] < 100000)
				System.out.println("happy");
			else
				System.out.println("sad");
		}
	}

	private static void fillDist() { // 각각의 거리들 미리 채워주기
		for (int i = 0; i < n + 2; i++) {
			for (int j = 0; j < n + 2; j++) {
				map[i][j] = 100000; // 큰 값으로 채워주기
			}
		}
		// 집 <-> 편의점
		for (int i = 1; i <= n; i++) {
			dist = getDist(hr, hc, con.get(i - 1)[0], con.get(i - 1)[1]);
			if (dist <= 1000)
				map[0][i] = 1;
		}

		// 편의점 <-> 편의점
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(i==j)
					continue;
				dist = getDist(con.get(i - 1)[0], con.get(i - 1)[1], con.get(j - 1)[0], con.get(j - 1)[1]);
				if (dist <= 1000)
					map[i][j] = 1;
			}
		}
		// 편의점 <-> 페스티벌
		for (int i = 1; i <= n; i++) {
			dist = getDist(con.get(i - 1)[0], con.get(i - 1)[1], fr, fc);
			if (dist <= 1000)
				map[i][n+1] = 1;
		}
		// 집<->페스티벌
		dist = getDist(hr, hc, fr, fc);
		if (dist <= 1000)
			map[0][n + 1] = 1;
	}

	private static int getDist(int ar, int ac, int br, int bc) {
		return (Math.abs(ar - br) + Math.abs(ac - bc));
	}
}
