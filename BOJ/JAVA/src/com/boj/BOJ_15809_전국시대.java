package com.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_15809_전국시대 {
	static int n, m, o, p, q;
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer str;
	static int[] population;
	static int[] parents;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		str = new StringTokenizer(br.readLine());
		n = Integer.parseInt(str.nextToken());
		m = Integer.parseInt(str.nextToken());
		population = new int[n + 1]; // 병력
		for (int i = 1; i <= n; i++) {
			population[i] = Integer.parseInt(br.readLine());
		}
		parents = new int[n + 1];

		// 동작
		make();
		for (int i = 0; i < m; i++) {
			str = new StringTokenizer(br.readLine());
			o = Integer.parseInt(str.nextToken());
			p = Integer.parseInt(str.nextToken());
			q = Integer.parseInt(str.nextToken());
			if (o == 1) {
				union(p, q);
			} else {
				war(p, q);
			}
		}

		// 정렬된 출력을 위한 list
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			if (i == parents[i] && population[i] != 0) // 살아남은 국가
				ans.add(population[i]);
		}

		// 정렬
		Collections.sort(ans);
		bw.write(ans.size() + "\n");
		for (int i = 0; i < ans.size(); i++) {
			bw.write(ans.get(i) + " ");
		}

		bw.flush();
		bw.close();
	}

	static void make() {
		for (int i = 1; i < n + 1; i++) {
			parents[i] = i;
		}
	}

	static int find(int a) {
		if (parents[a] == a)
			return a;
		else
			return parents[a] = find(parents[a]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a > b) {
			parents[a] = b;
			// 병력 합치기
			population[a] += population[b];
			population[b] = population[a];
		} else {
			parents[b] = a;
			// 병력 합치기
			population[b] += population[a];
			population[a] = population[b];
		}
	}

	static void war(int a, int b) {
		a = find(a);
		b = find(b);
		if (population[a] > population[b]) {
			population[a] -= population[b];
			population[b] = 0;
			parents[b] = a; // 속국
		} else if (population[a] < population[b]) {
			population[b] -= population[a];
			population[a] = 0;
			parents[a] = b;
		} else { // 둘 다 멸망
			population[a] = 0;
			population[b] = 0;
			parents[a] = 0;
			parents[b] = 0;

		}
	}
}
