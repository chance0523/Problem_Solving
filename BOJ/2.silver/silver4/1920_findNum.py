# 1920번. 수 찾기

n = int(input())
nList = list(map(int, input().split()))
m = int(input())
mList = list(map(int, input().split()))

# 이분 탐색을 위한 sort
nList.sort()

# 이분 탐색
for num in mList:
    left = 0
    right = n-1
    flag = False
    while left <= right:
        mid = int((left+right)/2)
        if nList[mid] > num:
            right = mid-1
            continue
        elif nList[mid] < num:
            left = mid+1
            continue
        else:
            # 존재하면 flag를 true로
            flag = True
            break
    if flag:
        print(1)
    else:
        print(0)
