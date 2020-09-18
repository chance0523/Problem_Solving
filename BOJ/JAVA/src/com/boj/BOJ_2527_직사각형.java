package com.boj;

import java.util.Scanner;

public class BOJ_2527_직사각형 {
	static int n;

	static class S {
		int x1;
		int y1;
		int x2;
		int y2;

		public S(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}

	public static void main(String[] args) throws Exception {
		// 입력
		Scanner sc = new Scanner(System.in);
		for (int t = 0; t < 4; t++) { // 테스트케이스 4개
			S a = new S(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
			S b = new S(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());

			// 동작
			char ans = '0';

			if ( // 점에서 만나는 경우
					(a.x2 == b.x1 && a.y2 == b.y1) || // 우상
					(a.x1 == b.x2 && a.y2 == b.y1) || // 우하
					(a.x2 == b.x1 && a.y1 == b.y2) || // 좌상
					(a.x1 == b.x2 && a.y1 == b.y2)) { // 좌하
				ans = 'c';
			} else if ( // 선분
					(a.x2 == b.x1 && a.y2 != b.y1) || // 우상
					(a.x1 == b.x2 && a.y2 != b.y1) || // 우하
					(a.x2 != b.x1 && a.y1 == b.y2) || // 좌상
					(a.x1 != b.x2 && a.y1 == b.y2)) { // 좌하
				ans = 'b';
			} else if ( // 안 만나는 경우
					a.x2 < b.x1 || // 오른쪽
					b.x2 < a.x1 || // 왼쪽
					a.y2 < b.y1 || // 위
					b.y2 < a.y1) { // 아래
				ans = 'd';
			} else {
				ans = 'a';
			}
			System.out.println(ans);
		}
		sc.close();
	}
}