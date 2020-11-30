# 11728번. 배열 합치기


import sys
input = sys.stdin.readline

n, m = map(int, input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
a.extend(b) # 그냥 한 리스트로 만들어주고
a.sort() # 정렬
print(*a) # 주어진 형식대로 출력
