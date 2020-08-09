package com.boj;

import java.util.Scanner;

public class BOJ_15649_n과m_1 {
	static int n, m;
	static int[] numbers;
	static boolean[] visited;

	public static void main(String[] args) {
		// 순열
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		numbers = new int[m]; // 순열을 담을 배열
		visited = new boolean[n + 1]; // 방문 체크

		permutation(0);

		sc.close();
	}

	static void permutation(int cnt) {
		if (cnt == m) { // 출력
			for (int i = 0; i < m; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (visited[i]) // 방문 했으면 pass
				continue;
			numbers[cnt] = i; // 현 위치에 담아주고
			visited[i] = true; // 방문했다고 표시한 다음
			permutation(cnt + 1); // 다음 위치의 수를 찾으러 간다
			visited[i] = false; // 재귀가 끝나면 방문 했던 곳들 체크 해제
		}

	}
}
