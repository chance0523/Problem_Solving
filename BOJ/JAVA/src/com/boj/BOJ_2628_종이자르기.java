package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2628_종이자르기 {
	static BufferedReader br;
	static StringTokenizer st;
	static int r, c, n, dir, loc;
	static ArrayList<Integer> garo;
	static ArrayList<Integer> sero;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken()); // 가로
		c = Integer.parseInt(st.nextToken()); // 세로
		n = Integer.parseInt(br.readLine()); // 점선의 개수
		garo = new ArrayList<Integer>();
		sero = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			dir = Integer.parseInt(st.nextToken()); // 가로 or 세로
			if (dir == 0) { // 가로
				garo.add(Integer.parseInt(st.nextToken()));
			} else { // 세로
				sero.add(Integer.parseInt(st.nextToken()));
			}
		}

		// 가로와 세로에 양끝을 포함하고 정렬
		garo.add(0);
		garo.add(c);
		sero.add(0);
		sero.add(r);
		Collections.sort(garo);
		Collections.sort(sero);
		
		// 사이사이의 거리를 구해준다.
		int[] g = new int[garo.size() - 1];
		int[] s = new int[sero.size() - 1];
		for (int i = 0; i < garo.size() - 1; i++) {
			g[i] = garo.get(i + 1) - garo.get(i);
		}
		for (int i = 0; i < sero.size() - 1; i++) {
			s[i] = sero.get(i + 1) - sero.get(i);
		}
		// 나온 배열을 정렬한다.
		Arrays.sort(g);
		Arrays.sort(s);
		
		// 가장 큰 값끼리 곱한다
		int size = g[g.length - 1] * s[s.length - 1];
		System.out.println(size);
	}
}
