package com.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_6603_로또 {
	static int k;
	static int[] arr;
	static int limit = 6;
	static int[] numbers;
	static BufferedWriter bw;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (true) {
			// 입력
			StringTokenizer str = new StringTokenizer(br.readLine());
			k = Integer.parseInt(str.nextToken());
			if (k == 0) // 종료
				break;
			arr = new int[k];
			for (int i = 0; i < k; i++) {
				arr[i] = Integer.parseInt(str.nextToken());
			}
			numbers = new int[6];
			// 동작
			func(0, 0);

			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

	static void func(int cnt, int start) throws Exception {
		// 6개 숫자
		if (cnt == limit) {
			for (int i = 0; i < limit; i++) {
				bw.write(numbers[i] + " ");
			}
			bw.write("\n");
			return;
		}
		for (int i = start; i < k; i++) {
			numbers[cnt] = arr[i];
			func(cnt+1,i+1);
		}
	
	}
}
