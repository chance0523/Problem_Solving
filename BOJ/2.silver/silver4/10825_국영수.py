# 10825번. 국영수


import sys
input = sys.stdin.readline

# 자바로 다시 풀어봄직한 문제이다.
n = int(input())
nList = []
for i in range(n):
    name, kor, eng, math = input().split()
    kor = -int(kor)  # 감소하는 순서로 넣기 위함
    eng = int(eng)
    math = -int(math)  # 감소하는 순서로 넣기 위함
    nList.append([kor, eng, math, name])

nList.sort()  # 정렬

for p in nList:
    print(p[-1])  # 이름만 출력
