# 17219번. 비밀번호 찾기


import sys
input = sys.stdin.readline

n, m = map(int, input().split())
# 딕셔너리를 이용해 url과 password가 바로 매칭 가능하게 함
upDict = {}
pList = [0 for i in range(m)]
for i in range(n):
    url, password = input().rstrip().split()
    upDict[url] = password
for i in range(m):
    url = input().rstrip()
    print(upDict[url])
