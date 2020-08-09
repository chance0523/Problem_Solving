package com.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10816_숫자카드2 {
	static int n, m;
	static int[] nArr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 입력
		n = Integer.parseInt(br.readLine());
		nArr = new int[20000010]; // 여유있게 설정
		for (int i = 0; i < nArr.length; i++) {
			nArr[i]=0;
		}
		
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		// 마치 딕셔너리처럼 접근. 음수 방지를 위해 천만을 더해준다
		for (int i = 0; i < n; i++) {
			nArr[Integer.parseInt(st.nextToken())+10000000]++;
		}
		
		m = Integer.parseInt(br.readLine());
		s= br.readLine();
		st = new StringTokenizer(s);
		// 인덱스에 접근만 하면 된다.
		for (int i = 0; i < m; i++) {
			bw.write(nArr[Integer.parseInt(st.nextToken())+10000000]+" ");
		}
		bw.flush();
		bw.close();
	}
}
