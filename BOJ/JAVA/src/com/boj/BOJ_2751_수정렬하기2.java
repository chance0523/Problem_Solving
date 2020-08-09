package com.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2751_수정렬하기2 {
	static int n;
	static ArrayList<Integer> numArr;
	static int temp;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(bf.readLine());
		numArr = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			numArr.add(Integer.parseInt(bf.readLine()));
		}
		Collections.sort(numArr);
		for (int i = 0; i < n; i++) {
			bw.write(numArr.get(i) + "\n");
		}
		bw.flush();
		bw.close();
	}

}
