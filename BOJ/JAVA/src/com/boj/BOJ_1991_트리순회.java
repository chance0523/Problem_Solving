package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1991_트리순회 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static Map<Character, List<Character>> map;
	static char center, left, right;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new HashMap<>(); // 해시맵 사용
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			center = st.nextToken().charAt(0);
			left = st.nextToken().charAt(0);
			right = st.nextToken().charAt(0);
			List<Character> list = new ArrayList<>();
			list.add(left);
			list.add(right);
			map.put(center, list);
		}

		preOrder('A');
		System.out.println();
		inOrder('A');
		System.out.println();
		postOrder('A');
	}

	private static void preOrder(char c) {
		if (c == '.') // 자식이 없는 곳이면 return
			return;
		System.out.print(c); // 출력
		preOrder(map.get(c).get(0)); // 왼쪽 먼저 쭉 탐색
		preOrder(map.get(c).get(1)); // 나와서 오른쪽 탐색
	}

	private static void inOrder(char c) {
		if (c == '.')
			return;
		inOrder(map.get(c).get(0)); // 왼쪽 먼저 쭉 탐색
		System.out.print(c); // 출력
		inOrder(map.get(c).get(1)); // 나와서 오른쪽 탐색
	}

	private static void postOrder(char c) {
		if (c == '.')
			return;
		postOrder(map.get(c).get(0)); // 왼쪽 먼저 쭉 탐색
		postOrder(map.get(c).get(1)); // 나와서 오른쪽 탐색
		System.out.print(c); // 출력
	}

}
