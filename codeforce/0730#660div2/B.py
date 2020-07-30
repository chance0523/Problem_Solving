import sys
input = sys.stdin.readline

t = int(input())
num8List = [0]
cnt = 1
for i in range(1, 10**5+10):
    num8List.append(cnt)
    if(i % 4 == 0):
        cnt += 1
for _ in range(t):
    n = int(input())
    n8 = num8List[n]  # number of 8
    n9 = n-n8  # number of 9
    print('9'*n9+'8'*n8)


# 9998
# 1001100110011000
# 100110011001
# 1001100110011001 #### 4->5
# 99988 # 5
# 10011001100110001000
# 999988
# 100110011001100110
# 8->9
# 999999888
# 100110011001100110011001100
