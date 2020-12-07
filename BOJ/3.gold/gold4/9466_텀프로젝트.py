# 9466번. 텀 프로젝트


import sys
input = sys.stdin.readline

for _ in range(int(input())):
    n = int(input())
    select = [0] + list(map(int, input().split()))
    visited = [0 for i in range(n + 1)]

    team = 1
    for i in range(1, n + 1):
        if visited[i] == 0:  # 이 지점에서 처음 시작해볼 때
            while True:
                if visited[i] != 0:
                    break
                visited[i] = team  # 팀 번호 매겨준다.
                i = select[i]  # 이 학생이 선택한 학생 찾아간다.
            # 여기까지 하면 이 팀이 다 선택된 것
            while visited[i] == team:  # 이제 이 팀을
                visited[i] = -1  # 다 방문 체크해준다.
                i = select[i]
            team += 1  # 다음 팀 구성

    ans = 0
    for v in visited[1:]:
        if v > 0:  # 팀이 없는 학생
            ans += 1
    print(ans)
