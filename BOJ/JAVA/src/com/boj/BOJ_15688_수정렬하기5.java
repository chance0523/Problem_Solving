package com.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_15688_수정렬하기5 {
	static int[] arr;
	static int n;
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		arr = new int[2222222];
		int num=0;
		for (int i = 0; i < n; i++) {
			num = Integer.parseInt(br.readLine());
			arr[num+1000000]+=1;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>0) {
				for (int j = 0; j < arr[i]; j++) {
					bw.write(i-1000000+"\n");
				}
			}
		}
		bw.flush();
		bw.close();
	}
}
