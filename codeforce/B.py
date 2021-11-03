import sys
input = sys.stdin.readline

for _ in range(int(input())):
    x0, n = map(int,input().split())
    if x0 % 2 == 0:
        if n % 4 == 0:
            print(x0)
        elif n % 4 == 1:
            print(x0 + (-1 - (n // 4) * 4))
        elif n % 4 == 2:
            print(x0 + 1)
        else:
            print(x0 + (4 + (n // 4) * 4))
    else:
        if n % 4 == 0:
            print(x0)
        elif n % 4 == 1:
            print(x0 + (1 + (n // 4) * 4))
        elif n % 4 == 2:
            print(x0 - 1)
        else:
            print(x0 + (-4 - (n // 4) * 4))
# nList = [2]
# for i in range(1, 20):
#     cur = nList[-1]
#     if cur%2==0:
#         nList.append(cur-i)
#     else:
#         nList.append(cur+i)
# print(nList)

# nList2 = [5]
# for i in range(1, 20):
#     cur = nList2[-1]
#     if cur%2==0:
#         nList2.append(cur-i)
#     else:
#         nList2.append(cur+i)
# print(nList2)
# print(987654321%4)