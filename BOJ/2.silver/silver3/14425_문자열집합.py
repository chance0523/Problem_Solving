# 14425번. 문자열 집합


n,m = map(int,input().split())
nDict = {}
for i in range(n):
    # 집합 S에 같은 문자열이 여러 번 주어지는 경우는 없다.
    nDict[input()] = True

ans = 0
for i in range(m):
    s = input()
    try:
        if nDict[s]:
            ans += 1
    except:
        continue
print(ans)    
