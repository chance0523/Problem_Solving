package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1952_수영장 {
	static BufferedReader br;
	static StringTokenizer st;
	static int t, day1, month1, month3, year;
	static int[] month;
	static int[] arr;
	static int ans;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		t = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= t; tc++) {
			arr = new int[4];
			month = new int[13];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}

			// 동작
			ans = 0;
			for (int i = 1; i <= 12; i++) {
				day1 = month[i] * arr[0] + month[i - 1]; // 1일권 누적합
				month1 = arr[1] + month[i - 1]; // 한달권 누적합
				month3 = Integer.MAX_VALUE; // 1,2월은 무시
				if (i >= 3)
					month3 = month[i - 3] + arr[2]; // 3달권 누적합
				
				// 최소 비용 구하기
				month[i] = Math.min(day1, month1);
				month[i] = Math.min(month[i], month3);
			}
			ans = Math.min(arr[3], month[12]); // 1년권과 비교

			// 출력
			System.out.println("#" + tc + " " + ans);
		}
	}
}
