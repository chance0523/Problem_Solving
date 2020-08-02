/* 1225. [S/W 문제해결 기본] 7일차 - 암호생성기 D3
 * https://swexpertacademy.com/main/code/problem/problemSolver.do?contestProbId=AV14uWl6AF0CFAYD
 */
package com.swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1225 {
	static int tc;
	static int dNum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			tc = sc.nextInt(); // 테스트케이스 num 받기
			dNum = 1; // 감소할 숫자
			Queue<Integer> queue = new LinkedList<Integer>(); // queue 생성
			
			for (int j = 0; j < 8; j++) {
				queue.offer(sc.nextInt()); // 숫자 넣기
			}
			
			while (true) {
				if ((queue.peek() - dNum) <= 0) { // 0보다 작거나 같아지면
					queue.poll(); // 꺼내고
					queue.offer(0); // rear에는 0을 넣어줌
					break;
				} else { // 그 외의 경우
					queue.offer(queue.poll() - dNum); // front에서 숫자를 감소시켜서 rear에 넣어줌
					dNum++; // 감소할 숫자를 증가시켜줌
					if (dNum == 6)
						dNum = 1; // 5보다 커지면 다시 1로 만든다
				}
			}
			
			// 출력
			System.out.print("#" + tc + " ");
			for (int j = 0; j < 8; j++) {
				System.out.print(queue.poll()); // 하나씩 꺼내고
				if (j < 7)
					System.out.print(" "); // 공백을 넣어준다.
			}
			System.out.println();
		}
		sc.close();
	}
}
