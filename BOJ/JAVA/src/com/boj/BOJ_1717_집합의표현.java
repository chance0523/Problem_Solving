package com.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1717_집합의표현 {
	static int n, m, a, b;
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer str;
	static int op;
	static int[] parents;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		str = new StringTokenizer(br.readLine());
		n = Integer.parseInt(str.nextToken());
		m = Integer.parseInt(str.nextToken());
		parents = new int[n+1];
		// 동작
		make();
		for (int i = 0; i < m; i++) {
			str = new StringTokenizer(br.readLine());
			op = Integer.parseInt(str.nextToken());
			a = Integer.parseInt(str.nextToken());
			b = Integer.parseInt(str.nextToken());
			if (op == 0) {
				union(a,b);
			} else {
				if(find(a)==find(b))
					bw.write("YES\n");
				else
					bw.write("NO\n");
			}
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
		parents[a] = find(parents[a]);
		return parents[a];
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a > b)
			parents[a] = b;
		else
			parents[b] = a;
	}
}
