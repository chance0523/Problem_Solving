package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_14469_소가길을건너간이유3 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n, arrive, check;
	static ArrayList<int[]> cow;
	static int ans;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		cow = new ArrayList<int[]>();
		for (int i = 0; i < n; i++) {
			// 도착시간, 검문시간
			st = new StringTokenizer(br.readLine());
			arrive = Integer.parseInt(st.nextToken());
			check = Integer.parseInt(st.nextToken());
			cow.add(new int[] { arrive, check });
		}

		// 동작
		// 도착시간 오름차순으로 정렬
		Collections.sort(cow, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		ans = 0;
		for (int[] arr : cow) { // foreach 사용
			if (arr[0] < ans) // 소가 이미 도착해있다면 바로 검문
				ans += arr[1];
			else // 소가 도착하지 않았다면 
				ans = arr[0] + arr[1];
		}

		// 출력
		System.out.println(ans);
	}
}
