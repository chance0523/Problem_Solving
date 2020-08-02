/* 3499. 퍼펙트 셔플 D3
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWGsRbk6AQIDFAVW
 */
package com.swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_3499_퍼펙트셔플 {
	static int t;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			
			// 큐 구조로 생성
			Queue<String> queueFirst = new LinkedList<>();
			Queue<String> queueLast = new LinkedList<>();
			Queue<String> queueAns = new LinkedList<>();
			
			// n이 짝수여서 반반 딱 나눠질 때
			if (n % 2 == 0) {
				for (int i = 0; i < n; i++) {
					if (i < n / 2) // 앞의 입력은 first큐로
						queueFirst.offer(sc.next());
					else // 남은 뒤의 입력은 last큐로
						queueLast.offer(sc.next());
				}
			} 
			// n이 홀수여서 first큐로 들어가는 것이 한 개 더 많을 때
			else {
				for (int i = 0; i < n; i++) {
					if (i < n / 2 + 1) // 한 개 늘려줌 (5/2 = 2)
						queueFirst.offer(sc.next());
					else
						queueLast.offer(sc.next());
				}
			}
			
			// 큐에서 한 개 씩 빼면서 answer큐에 넣어준다.
			for (int i = 0; i < n; i++) {
				if (i % 2 == 0)
					queueAns.offer(queueFirst.poll());
				else
					queueAns.offer(queueLast.poll());
			}
			
			// 출력
			System.out.print("#" + tc);
			for (int i = 0; i < n; i++) {
				System.out.print(" "+queueAns.poll());
			}
			System.out.println();
		}
		sc.close();
	}
}
