package com.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1181_단어정렬 {
	static int n; // 입력

	static String[] strArr; // 배열들

	static String str; // 입력

	static String tmpstr; // temp들
	static int len1;
	static int len2;

	public static void main(String[] args) throws Exception {
		// BufferedReader, BufferedWriter를 써야 시간초과 안 난다...
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(bf.readLine());
		strArr = new String[n]; // 문자열을 넣을 배열

		for (int i = 0; i < n; i++) {
			// 두 배열에 문자열, 문자열의 길이를 넣어준다.
			str = bf.readLine();
			strArr[i] = str;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				len1 = strArr[j].length();
				len2 = strArr[j + 1].length();
				if (len1 > len2)
					sort(j); // 문자열 길이 sort
				else if (len1 == len2) {
					if (strArr[j].equals(strArr[j + 1]))
						continue;
					if (strArr[j].compareTo(strArr[j + 1]) > 0) {
						sort(j);
					}
				} else
					continue;
			}
		}

		for (int i = 0; i < n; i++) {
			// 중복은 한 번만 출력
			if (i != n - 1 && strArr[i].equals(strArr[i + 1]))
				continue;
			else
				bw.write(strArr[i]+"\n");
		}
		bw.flush();
		bw.close();
	}

	static void sort(int j) {
		tmpstr = strArr[j];
		strArr[j] = strArr[j + 1];
		strArr[j + 1] = tmpstr;
	}
}
