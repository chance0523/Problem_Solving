package com.boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1342_행운의문자열 {
	static char[] s;
	static int[] input;
	static int totalCount;
	static boolean flag;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		s = sc.next().toCharArray();
		
		Arrays.sort(s);
		
		cnt=0;
		flag=true;
		do {
			flag=true;
			// 인접 비교
			for (int i = 1; i < s.length-1; i++) {
				if(s[i-1]==s[i] || s[i]==s[i+1]) {
					flag=false;
					break;
				}
			}
			
			if(flag)
				cnt++;
			
		}while(np(s)); // 다음 순열로
		
		System.out.println(cnt);
		sc.close();
	}

	private static boolean np(char numbers[]) {
		totalCount++;
		int i=s.length-1;
		while(i>0 && numbers[i-1]>=numbers[i]) --i;
		
		if(i==0) return false;
		
		int j=s.length-1;
		while(numbers[i-1]>=numbers[j])	--j;
		swap(numbers,i-1,j);
		
		int k = s.length-1;
		while(i<k) {
			swap(numbers,i++,k--);			
		}
		return true;
	}
	
	private static void swap(char numbers[],int i,int j) {
		char temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
