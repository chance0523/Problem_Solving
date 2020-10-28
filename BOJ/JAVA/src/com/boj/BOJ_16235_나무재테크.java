package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_16235_나무재테크 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n, m, k;
	static int[][] a;
	static int x, y, z;
	static ArrayList<ArrayList<ArrayList<Tree>>> tree;

	private static class Tree {
		int tx;
		int ty;
		int year;
		boolean alive;

		public Tree() {
		}

		public Tree(int tx, int ty, int year, boolean alive) {
			super();
			this.tx = tx;
			this.ty = ty;
			this.year = year;
			this.alive = alive;
		}
	}

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		a = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		tree = new ArrayList<ArrayList<ArrayList<Tree>>>();

		for (int i = 0; i < n; i++) {
			tree.add(new ArrayList<>());
			for (int j = 0; j < n; j++) {
				tree.get(i).add(new ArrayList<Tree>());
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			tree.get(x).get(y).add(new Tree(x, y, z, true));
		}

		// 동작
		for (int i = 0; i < k; i++) {
			spring();
//			summer();
//			fall();
//			winter();
		}
	}

	static int curYear;
	private static void spring() {
		
	}
}
