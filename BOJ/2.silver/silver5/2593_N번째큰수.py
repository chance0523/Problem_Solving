# 2593번. N번째 큰 수


for _ in range(int(input())):
    nList = list(map(int, input().split()))
    nList.sort() # 정렬
    print(nList[-3]) # 세번째로 큰 수
