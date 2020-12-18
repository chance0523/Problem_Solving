# 15918번. 랭퍼든 수열쟁이야!!


def Lang(cnt):
    global ans
    if cnt == 2 * n:  # 2n개 다 채웠을때
        ans += 1  # 경우의 수 ++
        return

    if not nList[cnt]:
        for i in range(1, n + 1):  # 1~n까지의 수 넣어주기
            if v[i]:
                continue
            if cnt + i + 1 <= 2 * n and not nList[cnt + i + 1]:  # boundary 체크
                nList[cnt] = i
                nList[cnt + i + 1] = i  # i+1만큼 떨어진 곳에 같은 수가 있음
                v[i] = True
                Lang(cnt + 1)  # 재귀
                v[i] = False  # 백트래킹 시작
                nList[cnt + i + 1] = 0
                nList[cnt] = 0
    else:
        Lang(cnt+1)


n, x, y = map(int, input().split())
ans = 0
# x번째 수와 y번째 수가 같다는 것은
# 두 수가 모두 y-x+1이라는 것 (3으로 예를 들면 이해 할 수 있다)
# x~y 사이에 y-x-1개의 수가 있을 것

nList = [0 for i in range(50)]  # 넉넉히 잡아주기 (n<=12)
nList[x] = y - x + 1
nList[y] = y - x + 1
v = [False for i in range(50)]
v[y - x - 1] = True

Lang(1)
print(ans)
