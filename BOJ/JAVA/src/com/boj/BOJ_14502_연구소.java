package com.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer str;
	static int n, m;
	static int[][] map;

	static ArrayList<Integer[]> zeroList;

	static int[] numbers; // 조합

	// 상하좌우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		str = new StringTokenizer(br.readLine());
		n = Integer.parseInt(str.nextToken());
		m = Integer.parseInt(str.nextToken());
		map = new int[n][m];
		zeroList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			str = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
				if (map[i][j] == 0) {
					zeroList.add(new Integer[] { i, j });
				}
			}
		}

		// 0 빈칸, 1 벽, 2 바이러스
		// 벽 3개 무조건 세워야함

		// 동작
		// 벽 3개 놓기 조합
		numbers = new int[3];
		combinations(0, 0);
		
		// 출력
		System.out.println(maxCnt);
	}

	public static void combinations(int cnt, int start) { // 조합 생성
		if (cnt == 3) {
			selectZero(numbers); // 이 조합으로 bfs한다. // {1 5 8}
			return;
		}
		
		for (int i = start; i < zeroList.size(); i++) {
			numbers[cnt] = i + 1;
			combinations(cnt + 1, i + 1);
		}
	}

	static int[][] newmap;
	public static void selectZero(int[] numbers) {
		// 1로 바꿀 곳을 뽑아준다.
		int[][] set = new int[3][2]; // 이 배열에 넣어준다.
		newmap =  new int[n][m]; // 여기다가 계산한다.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				newmap[i][j]=map[i][j];
			}
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				set[i][j] = zeroList.get(numbers[i]-1)[j]; // 바꿔줄 곳을 찾는다.
			}
		}
		
		for (int i = 0; i < 3; i++) {
			newmap[set[i][0]][set[i][1]]=1; // 1로 바꿔준다.
		}

		bfs(); // 바뀐 map으로 탐색한다.
	}

	static int maxCnt = 0;
	static Queue<Integer[]> q;

	public static void bfs() {

		q = new LinkedList<Integer[]>(); // bfs를 위한 queue

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (newmap[i][j] == 2) {
					q.offer(new Integer[] { i, j }); // 현재 좌표를 넣어줌
				}
			}
		}

		Integer[] set = new Integer[2];
		int r, c;
		int nr, nc;
		while (!q.isEmpty()) {
			set = q.poll();
			r = set[0];
			c = set[1];
			for (int dir = 0; dir < 4; dir++) {
				nr = r + dx[dir];
				nc = c + dy[dir];
				if (nr != -1 && nc != -1 && nr != n && nc != m && newmap[nr][nc] == 0) { // 범위 체크
					newmap[nr][nc] = 2; // 바이러스 전파
					q.offer(new Integer[] { nr, nc }); // 새로 큐에 넣어줌
				}
			}
		}

		int curCnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (newmap[i][j] == 0) { // 0인곳 찾아줌
					curCnt++;
				}
			}
		}
		
		
		if (maxCnt < curCnt)
			maxCnt = curCnt;
	}
}
