package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15685_드래곤커브 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n, x, y, d, g, ans;
	static int[][] map;
	static ArrayList<ArrayList<Integer>> curve;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[101][101];
		curve = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(0);
		curve.add(list1);
		list1 = new ArrayList<Integer>();
		list1.add(1);
		curve.add(list1);
		// 0
		// 1
		// 2 1
		// 2 3 2 1
		// 2 3 0 3 2 3 2 1
		for (int i = 2; i <= 10; i++) {
			list1 = new ArrayList<Integer>();
			for (int j = i - 1; j >= 0; j--) { // 가장 최근 세대부터
				for (int k = curve.get(j).size() - 1; k >= 0; k--) { // 뒤에서부터 하나씩
					list1.add((curve.get(j).get(k) + 1) % 4);
				}
			}
			curve.add(list1);
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken()); // 시작 방향
			g = Integer.parseInt(st.nextToken()); // 세대
			draw();
		}

//		for (int i = 0; i <= 10; i++) {
//			for (int j = 0; j < curve.get(i).size(); j++) {
//				System.out.print(curve.get(i).get(j) + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();

//		for (int i = 0; i <= 100; i++) {
//			for (int j = 0; j <= 100; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}

		ans = 0;
		findSquare();
		System.out.println(ans);
	}

	static int[] dx = { 0, -1, 0, 1 }; // 우상좌하
	static int[] dy = { 1, 0, -1, 0 };

	private static void draw() {
		map[x][y] = 1; // 일단 시작점 체크해줌.
		for (int i = 0; i <= g; i++) { // 0세대부터 한 세대씩 그려준다.
			go(i);
//			System.out.println(i+" "+d);
//			for (int k = 0; k < 7; k++) {
//				for (int j = 0; j < 7; j++) {
//					System.out.print(map[k][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
	}

	private static void go(int g) {
		for (int i = 0; i < curve.get(g).size(); i++) {
			x += dx[(d + curve.get(g).get(i)) % 4];
			y += dy[(d + curve.get(g).get(i)) % 4];
			map[x][y] = 1;
		}
	}

	private static void findSquare() {
		for (int i = 0; i <= 99; i++) {
			for (int j = 0; j <= 99; j++) {
				if (map[i][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j] == 1 && map[i +1][j + 1] == 1)
					ans++;
			}
		}
	}

}
