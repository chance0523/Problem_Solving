package com.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_17135_캐슬디펜스 {
	static int n, m, d;
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer str;
	static int[][] map;
	static int maxcnt;
	static int[] archer;

	public static void main(String[] args) throws Exception {

		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		str = new StringTokenizer(br.readLine());
		n = Integer.parseInt(str.nextToken());
		m = Integer.parseInt(str.nextToken());
		map = new int[n][m];
		d = Integer.parseInt(str.nextToken());
		for (int i = 0; i < n; i++) {
			str = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		
		
		// 동작
		archer = new int[3];
		maxcnt = 0;
		func(0, 0);
		
		// 출력
		System.out.println(maxcnt);
	}

	private static void func(int cnt, int start) {
		if (cnt == 3) { // 궁수 3명 셋 만들기
			battle(); // 몇명 잡을 수 있는지 계산
			return;
		}

		for (int i = start; i < m; i++) { // 조합
			archer[cnt] = i + 1;
			func(cnt + 1, i + 1);
		}
	}

	private static void battle() {
		int curn = n; // 현재 궁수의 위치 (한 턴에 하나씩 줄 것이다)
		int curcnt = 0;
		// d 이하인 적 중에서 가장 가까운, 그리고 왼쪽의 적
		// 궁수 1~3이 잡을 수 있는 것 (한 턴)
		// 궁수의 위치를 map[n][archer[a]-1] 으로 생각
		// 탐색을 왼쪽아래->오른쪽아래, 한 칸위 방식으로
		
		while (true) {
			
			if (curn == 0) { // 모든 턴이 끝났을 때
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						if (map[i][j] == -1) { // 죽은 적들을
							curcnt++;         // 카운트
							map[i][j] = 1; // 다시 살려놓기
						}
					}
				}
				
				if (curcnt > maxcnt) {
					maxcnt = curcnt;
				}
				return;
			}

			else {
				
				int[][] hitArr = new int[3][2];
				for (int i = 0; i < 3; i++) { // 20정도로 초기화를 한다.
					for (int j = 0; j < 2; j++) {
						hitArr[i][j]=20;
					}
				}
				
				for (int a = 0; a < 3; a++) { // 한 턴
					int curd = 1;
					ArrayList<Integer> colList = new ArrayList<Integer>();
					ArrayList<Integer> rowList = new ArrayList<Integer>();
					while (curd <= d) { // 가장 짧은 거리부터
						for (int i = curn - 1; i >= 0; i--) { // 맨 아래부터
							for (int j = 0; j < m; j++) { // 왼쪽 -> 오른쪽
								if (map[i][j] == 1 && (curn - i) + Math.abs(archer[a] - 1 - j) == curd) {
									// 해당 범위에 적이 있을 때
									colList.add(j); // 가장 왼쪽인 것을 확인하기 위해 리스트에 넣어준다.
									rowList.add(i); // 가장 왼쪽인 것을 확인하기 위해 리스트에 넣어준다.
								}
							}
						}
						if (!colList.isEmpty()) { // 무언가를 맞출 수 있는 상황이면 break
							int mincol = Integer.MAX_VALUE;
							int minidx = 0;
							for (int i = 0; i < colList.size(); i++) {
								if (mincol > colList.get(i)) { // 가장 왼쪽의 적을 찾는다.
									mincol = colList.get(i);
									minidx = i;
								}
							}
							hitArr[a][0] = rowList.get(minidx); // 궁수들이
							hitArr[a][1] = colList.get(minidx); // 맞춘 적 (한턴)
							break;
						}
						curd++; // 범위를 늘려준다.
					}
				}
				
				// 모든 궁수가 한 턴을 마침
				// 죽은 적을 만들어줌
				for (int i = 0; i < 3; i++) {
					if(hitArr[i][0]!=20) { // hitArr를 0으로 초기화해주면 여기서 문제가 생긴다.
						map[hitArr[i][0]][hitArr[i][1]] = -1; // 게임에서 제외되는 적
					}
				}
				curn--; // 궁수가 한 칸 올라가는 식으로 생각한다.
			}
		}

	}
}
