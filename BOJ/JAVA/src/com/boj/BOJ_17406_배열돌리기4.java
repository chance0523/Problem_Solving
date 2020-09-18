package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17406_배열돌리기4 {
	static BufferedReader br;
	static StringTokenizer str;
	static int n, m, k;
	static int[][] a;
	static int[][] a2;
	static int[][] a3;
	static int[][] turnArr;
	static int finalAns;
	static int[] numbers;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		str = new StringTokenizer(br.readLine());
		n = Integer.parseInt(str.nextToken());
		m = Integer.parseInt(str.nextToken());
		k = Integer.parseInt(str.nextToken());
		a = new int[n][m];
		a2 = new int[n][m];
		a3 = new int[n][m];
		turnArr = new int[k][3];
		for (int i = 0; i < n; i++) {
			str = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(str.nextToken()); // 원본
				a2[i][j] = a[i][j]; // a를 계속 담아줄 배열
				a3[i][j] = a[i][j]; // 막 바꿀 배열
			}
		}
		for (int i = 0; i < k; i++) {
			str = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				turnArr[i][j] = Integer.parseInt(str.nextToken()) - 1;
			}
			turnArr[i][2]++;
		}

		numbers = new int[k]; // 순열을 담을 배열 (turnArr의 행 인덱스를 담는다)
		visited = new boolean[k + 1]; // 방문 체크

		finalAns = Integer.MAX_VALUE;
		permutation(0);
		System.out.println(finalAns);
	}

	static void permutation(int cnt) {
		if (cnt == k) {
			getValue(); // 이 순서로 회전
			return;
		}

		for (int i = 1; i <= k; i++) {
			if (visited[i]) // 방문 했으면 pass
				continue;
			numbers[cnt] = i - 1; // 현 위치에 담아주고
			visited[i] = true; // 방문했다고 표시한 다음
			permutation(cnt + 1); // 다음 위치의 수를 찾으러 간다
			visited[i] = false; // 재귀가 끝나면 방문 했던 곳들 체크 해제
		}

	}

	static int r, c, s;

	private static void getValue() {
		// a2에 a를 담아준다.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a2[i][j] = a[i][j];
				a3[i][j] = a[i][j];
			}
		}

		// a2배열로 연산
		for (int i = 0; i < k; i++) {
			int num = numbers[i];
			
			turn(turnArr[num][0], turnArr[num][1], turnArr[num][2]);


		}
		// 모든 회전 끝나고 배열 값 계산
		int minsum = Integer.MAX_VALUE;
		for (int ii = 0; ii < n; ii++) {
			int sum = 0;
			for (int j = 0; j < m; j++) {
				sum += a2[ii][j];
			}
			if (minsum > sum)
				minsum = sum;
		}
		if (finalAns > minsum)
			finalAns = minsum;
	}

	private static void turn(int r, int c, int s) {

		int nr = r, nc = c;

		for (int i = 1; i <= s; i++) {
			// a2에 덮어씌우기
			nr = r - i; // 왼쪽 모서리부터 시작
			nc = c - i;
			
			// 왼상부터 시작
			for (int j = 0; j < i * 2; j++) {
				a3[nr][nc + 1] = a2[nr][nc];
				nc++;
			}
			// 아래로 내려가기
			for (int j = 0; j < i * 2; j++) {
				a3[nr + 1][nc] = a2[nr][nc];
				nr++;
			}
			// 왼쪽으로
			for (int j = 0; j < i * 2; j++) {
				a3[nr][nc - 1] = a2[nr][nc];
				nc--;
			}
			// 위로
			for (int j = 0; j < i * 2; j++) {
				a3[nr - 1][nc] = a2[nr][nc];
				nr--;
			}

		}
		// a2를 update
		for (int j = 0; j < n; j++) {
			for (int j2 = 0; j2 < m; j2++) {
				a2[j][j2] = a3[j][j2];
			}
		}

	}
}
