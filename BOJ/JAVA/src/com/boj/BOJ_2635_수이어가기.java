package com.boj;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2635_수이어가기 {
	static int n;
	static int ans;
	static ArrayList<Integer> ansList;
	static ArrayList<Integer> cntList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		if(n==1) { // 1일때 예외 조심
			System.out.println(4);
			System.out.println(1+" "+1+" "+0+" "+1);
			sc.close();
			return;
		}
		ans = 0;
		ansList = new ArrayList<Integer>(); // 최대 수열
		cntList = new ArrayList<Integer>(); // temp
		for (int i = 1; i < n; i++) {
			cntList.clear(); // 리스트 초기화
			cntList.add(n); // 첫번째 수와
			cntList.add(i); // 두번째 수는 넣어준다.
			makeSet();
		}
		System.out.println(ans + 1);
		for (int i = 0; i < ans + 1; i++) {
			System.out.print(ansList.get(i) + " ");
		}
		sc.close();
	}

	private static void makeSet() {
		int cnt = 1;

		while (true) {
			int num = cntList.get(cnt - 1) - cntList.get(cnt); // 다음 넣을 수를 구함.
			if (num < 0) { // 음의 정수면
				if (cnt > ans) { // 최대값 확인
					ans = cnt;
					ansList.clear();
					for (int i = 0; i < ans + 1; i++) {
						ansList.add(cntList.get(i));
					}
				}
				return;
			}
			// 음의 정수가 아닐 때
			cntList.add(num);
			cnt++;
		}
	}
}
