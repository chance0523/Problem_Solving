# # k, m = map(int,input().split())

# p = [False for _ in range(45000)]
# p[0] = True
# p[1] = True
# for i in range(2, len(p)):
#     for j in range(i+i, len(p), i):
#         p[j] = True

# # 만들 수 있는 가장 큰 수 = 98765
# # 가장 작은 소수(2) * 가장 큰 소수 <= 98765여야한다.
# # 45000이하의 수만 구해줌
# pList = []
# for i in range(len(p)):
#     if not p[i]:
#         pList.append(i)

# sList = []
# for i in range(len(pList)-1):
#     for j in range(i+1, len(pList)):
#         s = pList[i]+pList[j]
#         if s < 99999:
#             sList.append(s)
# # print(pList)
# print(len(pList))
# # print(sList)
# print(len(sList))
# print(sList[-1])

for _ in range(int(input())):
    a,b = map(int,input().split())
    print('yes')