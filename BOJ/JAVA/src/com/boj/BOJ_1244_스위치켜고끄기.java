package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244_스위치켜고끄기 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n, stu, s, h;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1]; // 인덱스 관리 편하게
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		stu = Integer.parseInt(br.readLine());
		for (int i = 0; i < stu; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken()); // 성별
			h = Integer.parseInt(st.nextToken()); // 스위치 번호
			if (s == 1) // 남
				boy(h);
			else // 여
				girl(h);
		}

		for (int j = 1; j < n + 1; j++) {
			System.out.print(arr[j] + " ");
			if (j % 20 == 0) // 한 줄에 20개씩만 출력!!
				System.out.println();
		}
	}

	private static void boy(int h) {
		// 남자는 구현하기 쉽다
		for (int i = h; i < n + 1; i += h) {
			// 스위치 상태 바꿔줌
			arr[i] ^= 1; // XOR 연산자
		}
	}

	private static void girl(int h) {
		// 여학생 구현은 어렵다.
		int i = 1;
		arr[h] ^= 1; // 중심이 되는 스위치는 무조건 바꿈
		while (true) {
			if (h - i < 1 || h + i > n) { // 범위 넘어가면 종료
				return;
			}
			if (arr[h - i] == arr[h + i]) { // 대칭이고 같은 상태면
				arr[h - i] ^= 1; // 바꿔준다.
				arr[h + i] ^= 1;
				i++; // 좌우 탐색 범위 늘려줌
			} else // 다른 상태면 종료
				return;
		}
	}
}
