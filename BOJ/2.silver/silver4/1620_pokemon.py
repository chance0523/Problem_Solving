# 1620번. 나는야 포켓몬 마스터 이다솜


import sys
input = sys.stdin.readline


# 딕셔너리 + 리스트 (메모리와 시간 조금 이득)
n, m = map(int, input().split())
dogamDict = {}
dogamList = [0 for i in range(n+1)]
for i in range(1, n+1):
    pokemon = input().rstrip()
    dogamDict[pokemon] = i
    dogamList[i] = pokemon

for i in range(m):
    ii = input().rstrip()

    if ii.isdigit():
        print(dogamList[int(ii)])
    else:
        print(dogamDict[ii])

# 딕셔너리 + 딕셔너리
# n, m = map(int, input().split())
# dogamName = {}  # 키에 이름을 넣음
# dogamNum = {}  # 키에 번호를 넣음
# for i in range(1, n+1):
#     pokemon = input().rstrip()
#     dogamName[pokemon] = i
#     dogamNum[i] = pokemon

# for i in range(m):
#     ii = input().rstrip()

#     if ii.isdigit():
#         print(dogamNum[int(ii)])
#     else:
#         print(dogamName[ii])

