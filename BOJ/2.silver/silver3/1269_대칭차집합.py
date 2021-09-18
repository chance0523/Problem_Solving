# 1269번. 대칭 차집합


a,b = map(int,input().split())
aSet = set(map(int,input().split()))
bSet = set(map(int,input().split()))
ab = aSet - bSet
ba = bSet - aSet
print(len(ab | ba))

