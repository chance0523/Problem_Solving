package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_14464_소가길을건너간이유4 {
	static BufferedReader br;
	static StringTokenizer st;
	static int c, n, a, b;
	static int[] t;
	static ArrayList<int[]> cow;
	static int ans;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken()); // 닭
		n = Integer.parseInt(st.nextToken()); // 소

		t = new int[c];
		for (int i = 0; i < c; i++) {
			t[i] = Integer.parseInt(br.readLine()); // 닭이 도와줄 수 있는 시각
		}

		cow = new ArrayList<int[]>();
		visited = new boolean[n];

		for (int j = 0; j < n; j++) {
			st = new StringTokenizer(br.readLine());
			// j번 소가 길을 건널 수 있는 시각. Aj~Bj
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			cow.add(new int[] { b, a }); // 도착시간, 출발시간
		}

		// 소는 최대 한 마리의 닭에게만 도움 받을 수 있음
		// 닭도 최대 한 마리의 소만 도와줄 수 있다.
		// 도움 받을 수 있는 소의 최대
		/** 최소 시간이 아니라 도움을 받을 수 있는 최대 소의 수이다!!! */

		ans = 0;

		// 닭 오름차순으로 정렬
		Arrays.sort(t);

		// 소 오름차순으로 정렬
		Collections.sort(cow, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else
					return o1[0] - o2[0];
			}
		});

		
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < n; j++) {
				// 소가 도움을 받지 않았고, 도움을 받을 수 있는 상황일 때
				if (cow.get(j)[0] >= t[i] && t[i] >= cow.get(j)[1] && visited[j] == false) {
					ans++;
					visited[j] = true;
					break;
				}
			}
		}

		System.out.println(ans);
	}
}
