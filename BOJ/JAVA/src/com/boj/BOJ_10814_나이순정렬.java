package com.boj;

import java.io.*;
import java.util.*;

public class BOJ_10814_나이순정렬 {
	static int n;
	static String[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력
		n = Integer.parseInt(br.readLine());
		arr = new String[n][3];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = st.nextToken(); // 나이
			arr[i][1] = i+""; // 순서
			arr[i][2] = st.nextToken();
		}
		
		Arrays.sort(arr,new Comparator<String[]>(){
            @Override
            public int compare(String[] one, String[] two){
                return Integer.compare(Integer.parseInt(one[0]),Integer.parseInt(two[0]));
            }
        });
		

		for (int i = 0; i < n; i++) {
			bw.write(arr[i][0] + " "+ arr[i][2] + "\n");
		}
		bw.flush();
		bw.close();
	}

}
