package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n, num, temp, ans;
	static int[] pop;
	static int[][] map;
	static int[] numbers;
	static ArrayList<Integer> numbers1;
	static ArrayList<Integer> numbers2;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		pop = new int[n];
		for (int i = 0; i < n; i++) { // 인구
			pop[i] = Integer.parseInt(st.nextToken());
		}

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken()); // 연결된 구역의 수
			for (int j = 0; j < num; j++) { // 구역 연결
				temp = Integer.parseInt(st.nextToken());
				map[i][temp] = 1;
				map[temp][i] = 1;
			}
		}

		// 동작
		numbers = new int[n];

		ans = Integer.MAX_VALUE;
		for (int i = 1; i < n; i++) { // 1개 이상, 모두는 안됨
			comb(0, 0, i);
		}

		if(ans==Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

	private static void comb(int start, int cnt, int m) {
		if (cnt == m) {
			numbers1 = new ArrayList<Integer>();
			for (int i = 0; i < m; i++) {
				numbers1.add(numbers[i]);
			}
			if (make2sets()) {
				calPop();
			}
			return;
		}
		for (int i = start; i < n; i++) {
			numbers[cnt] = i;
			comb(i + 1, cnt + 1, m);
		}
	}

	private static boolean make2sets() {
		numbers2 = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			if (!numbers1.contains(i)) // 1번에 포함되어있지 않으면
				numbers2.add(i); // 2번에 넣어줌
		}

		// 1번, 2번 선거구 조합 완성
		if (isConnected(numbers1) && isConnected(numbers2)) {
			return true;
		} else {
			return false;
		}

	}

	private static boolean isConnected(ArrayList<Integer> numbers) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(numbers.get(0)); // 항상존재
		boolean[] visited = new boolean[n]; // 방문처리 배열
		visited[numbers.get(0)] = true;
		int cnt = 1;
		while (!q.isEmpty()) { // bfs로 돌기
			int num = q.poll();
			for (int i = 1; i < numbers.size(); i++) {
				numbers.get(i);
				if (map[num][numbers.get(i)] == 1 && visited[numbers.get(i)] == false) {
					visited[numbers.get(i)] = true;
					cnt++;
					q.offer(numbers.get(i));
				}
			}
		}
		if (cnt == numbers.size()) { // 모두 연결되어있다면
			return true;
		}
		return false;
	}

	private static void calPop() { // 두 선거구의 인구 차이의 최소값
		int diff = 0;
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < numbers1.size(); i++) {
			sum1 += pop[numbers1.get(i)];
		}
		for (int i = 0; i < numbers2.size(); i++) {
			sum2 += pop[numbers2.get(i)];
		}

		diff = Math.abs(sum1 - sum2);
		ans = Math.min(diff, ans);
	}

}
