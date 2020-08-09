package com.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697_숨바꼭질 {
	static int N, K;
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer str;
	static int[][] map;
	static int mincnt;
	static boolean[] visited;
	static Queue<Integer> q;
	static Queue<Integer> cntq;

	public static void main(String[] args) throws Exception {

		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		K = Integer.parseInt(str.nextToken());

		// 동작
		mincnt = Integer.MAX_VALUE; // 비교를 위한 카운트

		visited = new boolean[100001]; // 방문 처리를 위한 배열
		q = new LinkedList<Integer>(); // 큐 사용
		cntq = new LinkedList<Integer>(); // 초 큐 사용

		q.offer(N); // 처음 위치를 넣어준다
		cntq.offer(0); // 처음 cnt(0)도 넣어준다

		mincnt = bfs();

		// 출력
		System.out.println(mincnt);
	}

	private static int bfs() {
		int cnt = 0;
		int curn = 0;
		while (!q.isEmpty()) {
			curn = q.poll(); // 현재 수빈이의 위치
			cnt = cntq.poll(); // 현재 초

			if (visited[curn] != true) {
				visited[curn] = true; // 방문처리
				if (curn == K) { // 만나면 무조건 return
					return cnt;
				}

				cnt++; // 1초 뒤
				if (curn != 0) { // 왼쪽으로 한 칸 갈 수 있을 때
					q.offer(curn - 1);
					cntq.offer(cnt);
				}
				if (curn != 100000) {
					q.offer(curn + 1);
					cntq.offer(cnt);
				}
				if (curn * 2 <= 100000) {
					q.offer(curn * 2);
					cntq.offer(cnt);
				}
			}

		}
		return cnt;
	}

}
