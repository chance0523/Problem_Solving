# 1062번. 가르침


import sys
input = sys.stdin.readline


def func(index, cnt):
    global ans

    if cnt == k-5:
        read_cnt = 0
        for word in words:
            for w in word:
                if not visited[ord(w)-ord('a')]:  # 배운 단어라 아니라면
                    break
            else:
                read_cnt += 1
        ans = max(ans, read_cnt) if ans else read_cnt
        return

    # 기본 5단어를 빼고 배우기
    for i in range(index, 26):
        if not visited[i]:
            visited[i] = True
            func(i, cnt+1)
            visited[i] = False  # 백트래킹


n, k = map(int, input().split())
# anta / tica는 무조건 가르쳐야
# acint - 5글자
# k가 5미만이라면 한 단어도 읽지 못한다.
if k < 5:
    print(0)
    sys.exit(0)
# 알파벳 26개를 모두 가르칠 수 있으면 다 배울 수 있다.
if k == 26:
    print(n)
    sys.exit(0)

words = []
visited = [False for i in range(26)]

for i in range(n):
    words.append(set(input().rstrip()))

# acint 는 미리 방문처리
visited[ord('a')-ord('a')] = True
visited[ord('c')-ord('a')] = True
visited[ord('i')-ord('a')] = True
visited[ord('n')-ord('a')] = True
visited[ord('t')-ord('a')] = True

ans = None
func(0, 0)
print(ans)
