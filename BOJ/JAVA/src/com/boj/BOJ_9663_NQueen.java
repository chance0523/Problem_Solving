package com.boj;

import java.util.Scanner;

public class BOJ_9663_NQueen {

	static int N;
	static int[] col; // 각 행의 퀸의 위치를 저장
	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N + 1];
		setQueens(1);
		System.out.println(answer);
		sc.close();
	}

	// 퀸을 현재(rowNo) 행에 놓기
	public static void setQueens(int rowNo) {
		if (rowNo > N) {
			answer++;
			return;
		}

		// 가능한 선택지 (1열~N열)
		for (int j = 1; j <= N; j++) {
			col[rowNo] = j;
			if (checking(rowNo)) { // 현재 퀸의 열위치가 가능하다면 다음 퀸으로
				setQueens(rowNo + 1);
			}
			// 일차원배열로 퀸의 위치를 관리하므로  시도했던 선택지 열 값을 되돌릴 필요가 없다
		}
	}

	// rowNo행의 퀸을 놓는게 가능한지 체크 : 놓을 수 있다면 true, 놓을 수 없다면 false
	private static boolean checking(int rowNo) {
		for (int i = 1; i < rowNo; i++) {
			if ((col[rowNo] == col[i]) || Math.abs(col[rowNo] - col[i]) == rowNo - i)
				return false;
		}
		return true;
	}
}
