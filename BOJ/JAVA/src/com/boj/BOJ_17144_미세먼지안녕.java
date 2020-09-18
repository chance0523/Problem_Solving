package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지안녕 {
	static BufferedReader br;
	static StringTokenizer st;
	static int r, c, t;
	static int[][] map;
	static int[][] maptemp;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int ar1;
	static int ar2;

	public static void main(String[] args) throws Exception {
		// 입력
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		maptemp = new int[r][c];

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 동작

		for (int i = 0; i < r; i++) { // 공기청정기 위치 찾기
			if (map[i][0] == -1) {
				ar1 = i;
				break; // 한 번 찾으면 무조건 그 아래가 ar2
			}
		}
		ar2 = ar1 + 1;
		
		int ans=0;
		
		while (t > 0) {
			dust();
			air();
			t--;
		}

		
		// 출력
//		for (int i = 0; i < r; i++) {
//			for (int j = 0; j < c; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(map[i][j]!=-1)
					ans+=map[i][j];
			}
		}
		System.out.println(ans);
	}

	private static void dust() {
		for (int x = 0; x < r; x++) {
			for (int y = 0; y < c; y++) {
				maptemp[x][y]=0;
			}
		}
		
		// 미세먼지가 번지는 것
		int nx, ny, cnt = 0;
		for (int x = 0; x < r; x++) { // 전체
			for (int y = 0; y < c; y++) { // 탐색

				if (map[x][y] > 0) { // 미세먼지가 있다면
					cnt = 0;
					for (int dir = 0; dir < 4; dir++) { // 사방탐색
						nx = x + dx[dir];
						ny = y + dy[dir];
						if (nx >= 0 && ny >= 0 && nx < r && ny < c && map[nx][ny] != -1) { // 범위, 그곳에 공기청정기가 없는 경우
							maptemp[nx][ny] += (map[x][y] / 5); // 미세먼지 확산. 소수점 버림
							cnt++; // 번진 횟수
						}
					}
					map[x][y] -= ((map[x][y] / 5) * cnt); // 남은 미세먼지의 양
				}
			}
		}

		// 전체적으로 다 번졌다면 temp에 있는 것을 map에 업데이트
		for (int x = 0; x < r; x++) {
			for (int y = 0; y < c; y++) {
				map[x][y] += maptemp[x][y]; // 업데이트 해주고
			}
		}
		// 1초동안 미세먼지 확산 완료
	}

	private static void air() {
		
		for (int x = 0; x < r; x++) {
			for (int y = 0; y < c; y++) {
				if(x==ar1 || x==ar2 || x==0 || x==r-1 || y==0 || y == c-1)
					maptemp[x][y]=0;
				else
					maptemp[x][y] = map[x][y];
			}
		}
		
		// 공기청정기 작동

		// 위 공기청정기
		// 오른쪽으로
		for (int i = 1; i <= c - 2; i++) { // maptemp에 덮는다
			maptemp[ar1][i + 1] = map[ar1][i];
		}

		// 위쪽으로
		for (int i = ar1; i >= 1; i--) {
			maptemp[i - 1][c - 1] = map[i][c - 1];
		}

		// 왼쪽으로
		for (int i = c - 1; i >= 1; i--) {
			maptemp[0][i - 1] = map[0][i];
		}

		// 아래로
		for (int i = 0; i <= ar1 - 2; i++) {
			maptemp[i + 1][0] = map[i][0];
		}

		/* ------ */

		// 아래 공기청정기
		// 오른쪽으로
		for (int i = 1; i <= c - 2; i++) {
			maptemp[ar2][i + 1] = map[ar2][i];
		}

		// 아래로
		for (int i = ar2; i <= r - 2; i++) {
			maptemp[i + 1][c-1] = map[i][c-1];
		}

		// 왼쪽으로
		for (int i = c - 1; i >= 1; i--) {
			maptemp[r - 1][i - 1] = map[r - 1][i];
		}

		// 위쪽으로
		for (int i = r - 1; i > ar2; i--) {
			maptemp[i - 1][0] = map[i][0];
		}
		
		
		// 업데이트
		for (int x = 0; x < r; x++) {
			for (int y = 0; y < c; y++) {
				map[x][y]=maptemp[x][y];
				maptemp[x][y]=0;
			}
		}
		
		map[ar1][0] = -1;
		map[ar2][0] = -1;
	}
}
