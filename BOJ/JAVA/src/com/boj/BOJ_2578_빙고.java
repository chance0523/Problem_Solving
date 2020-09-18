package com.boj;

import java.util.Scanner;

public class BOJ_2578_빙고 {
	static int[][] check;
	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int[][] box = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				box[i][j] = sc.nextInt();
			}
		}
		
		// 동작
		// 하나씩 수 받으면서 빙고가 완성 되었는지 확인
		check = new int[5][5];
		for (int k = 1; k <= 25; k++) { // 25번 수 부름
			int num = sc.nextInt(); // 번호 받기
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if(box[i][j]==num) { // 번호의 위치 찾기
						check[i][j] = 1; // 체크
						if(isBingo()) {
							System.out.println(k);
							sc.close();
							return;
						}
					}
				}
			}
		}
	}

	private static boolean isBingo() {
		int cnt=0;
		int s=0;
		// 세로줄 확인
		for (int i = 0; i < 5; i++) {
			s = 0;
			for (int j = 0; j < 5; j++) {
				s+=check[i][j];
			}
			if(s==5)
				cnt++;
		}
		// 가로줄 확인
		for (int i = 0; i < 5; i++) {
			s=0;
			for (int j = 0; j < 5; j++) {
				s+=check[j][i];
			}
			if(s==5)
				cnt++;
		}
		// 대각선 11시->5시
		s=0;
		for (int i = 0; i < 5; i++) {
			s+=check[i][i];
		}
		if(s==5)
			cnt++;
		
		// 대각선 1시->7시
		s=0;
		for (int j = 0; j < 5; j++) {
			s+=check[j][4-j];
		}
		if(s==5)
			cnt++;
		if(cnt>=3)
			return true;
		return false;
	}
}
