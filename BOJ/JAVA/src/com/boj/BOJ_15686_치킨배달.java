package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15686_치킨배달 {
	static BufferedReader br;
	static StringTokenizer str;
	static int n, m;
	static int[][] map;
	static ArrayList<int[]> houseList;
	static ArrayList<int[]> chickenList;
	static int[] chickenIndex;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		str = new StringTokenizer(br.readLine());
		n = Integer.parseInt(str.nextToken());
		m = Integer.parseInt(str.nextToken());
		map = new int[n][n];
		houseList = new ArrayList<>();
		chickenList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			str = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
				if (map[i][j] == 1)
					houseList.add(new int[] { i, j });
				else if (map[i][j] == 2)
					chickenList.add(new int[] { i, j });
			}
		}

		// 동작
		// 모든 (chicken)C(M)조합마다 치킨 거리를 구한다.
		minD = Integer.MAX_VALUE;
		chickenIndex = new int[m];
		combinations(0, 0);
		System.out.println(minD);

	}

	static void combinations(int cnt, int start) {
		if (cnt == m) {
			getChickenDistance(); // 조합을 구해서 도시 치킨거리를 구해줌
			return;
		}

		for (int i = start; i < chickenList.size(); i++) {
			chickenIndex[cnt] = i + 1;
			combinations(cnt + 1, i + 1);
		}

	}

	static int minD; // 최소 도시 치킨거리

	static void getChickenDistance() {
		int d = 0;
		int curChickenD = 0;
		for (int i = 0; i < houseList.size(); i++) {
			int[] house = houseList.get(i);
			int curminD = Integer.MAX_VALUE; // 한 집에서의 치킨 거리
			for (int j = 0; j < m; j++) { // m개만큼 고른다.
				int[] chicken = chickenList.get(chickenIndex[j] - 1);
				d = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
				if (d < curminD) // 치킨 거리의 최소값
					curminD = d;
			}
			curChickenD += curminD; // 도시 치킨거리
		}
		if (curChickenD < minD) // 도시 치킨거리의 최소값
			minD = curChickenD;
	}
}
