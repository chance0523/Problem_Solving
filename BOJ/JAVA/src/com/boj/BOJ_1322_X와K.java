package com.boj;

import java.util.Scanner;

public class BOJ_1322_X와K {
	static int x, k;
	static long y;

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
//		x = sc.nextInt();
//		k = sc.nextInt();
		x = 26;
		k = 4;
		// 주어진 조건을 만족하면
		// x가 이진수로 1001010 이면
		// y는 0에 들어가야함
		// 1. x를 이진수로 변환
		char[] bArr = Integer.toBinaryString(x).toCharArray(); // 배열로 변환
		int[] zero = new int[100];
		int index = 0;
		
		// 2. 0이 몇번째에 있는지 찾기
		for (int i = bArr.length - 1; i >= 0; i--) { // 맨 뒤부터
			if (bArr[i] == '0') { // 0을 찾고 몇번째인지 저장
				zero[index++] = i;
			}
		}

		for (int i = 0; i < 10; i++) {
			System.out.print(zero[i] + " ");
		}
		System.out.println();
		// 3. k를 이진수로 변환
		char[] bK = Integer.toBinaryString(k).toCharArray();

		for (int i = 0; i < bK.length; i++) {
			System.out.print(bK[i] + " ");
		}
		System.out.println();

		int maxIdx = bArr.length;
		// 4. bK를 뒤부터 보면서 zero랑 mapping
		for (int i = 0; i < bK.length; i++) {
			if (bK[bK.length - 1 - i] == '1') {
				if (i < zero.length)
					y += (int) Math.pow(2, zero[i]);
//				else // 더 크게 될 경우의 처리...
//					y += (int) Math.pow(2, maxIdx++);
			}
		}

		System.out.println(y);
		sc.close();
	}
}
