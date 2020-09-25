package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2304_창고다각형 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n, l, h;
	static int[][] arr;
	static int ans;
	static Stack<int[]> s;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][2];
		int size = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		if (n == 1) {
			System.out.println(arr[0][1]);
			return;
		}
		// 위치 오름차순으로 정렬
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		int max = 0;
		int left = 0;
		int right = 0;
		// 최대 높이 구간을 구함
		for (int i = 0; i < n; i++) {
			if (arr[i][1] > max) { // 높이 비교
				max = arr[i][1];
				left = arr[i][0]; // 구간의 맨 왼쪽 위치 설정
				right = left + 1; // 오른쪽도 설정
			} else if (arr[i][1] == max) { // 최대 높이 구간
				right = arr[i][0] + 1; // 구간의 맨 오른쪽 위치 갱신
			}
		}
		
		s = new Stack<int[]>();
		s.push(new int[] { arr[0][0], arr[0][1] }); // 처음은 무조건 넣어줌
		size = arr[0][1]; // 처음 기둥 넓이

		for (int i = 1; i < n; i++) { // 올라갈때
			l = arr[i][0];
			h = arr[i][1];
			if (s.peek()[1] <= h) { // 들어온 높이가 더 높다면
				size += h; // 기둥 넓이 더하고
				size += (l - s.peek()[0] - 1) * s.peek()[1]; // 사이의 넓이를 구한다
				s.push(new int[] { l, h });
			} else { // 그 외는 무시
				continue;
			}
		}
		
		// 최대 높이의 구간은 오른쪽->왼쪽으로 탐색하면서 다시 더해줄거라 다시 빼준다
		if (left + 1 == right) { // 최대 높이 구간이 1이라면
			size -= max;
		} else {
			size -= (right - left) * max;
		}
		
		s = new Stack<int[]>();
		s.push(new int[] { arr[n - 1][0], arr[n - 1][1] });
		size += arr[n - 1][1];
		for (int i = n - 2; i >= 0; i--) {
			l = arr[i][0];
			h = arr[i][1];
			if (s.peek()[1] <= h) { // 들어온 높이가 더 높다면
				size += h; // 기둥 넓이 더하고
				size += (s.peek()[0] - 1 - l) * s.peek()[1]; // 사이의 넓이를 구한다
				s.push(new int[] { l, h });
			} else { // 그 외는 무시
				continue;
			}
		}
		System.out.println(size);
	}
}
