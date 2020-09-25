import sys
input = sys.stdin.readline


for _ in range(int(input())):
    aList = list(map(int, input().split()))
    bList = list(map(int, input().split()))
    a = aList.pop(0)  # a,b는 필요없음
    b = bList.pop(0)
    # 별
    if aList.count(4) > bList.count(4):  # 개수 세주기
        print('A')
    elif aList.count(4) < bList.count(4):
        print('B')
    else:
        # 동그라미
        if aList.count(3) > bList.count(3):
            print('A')
        elif aList.count(3) < bList.count(3):
            print('B')
        else:
            # 네모
            if aList.count(2) > bList.count(2):
                print('A')
            elif aList.count(2) < bList.count(2):
                print('B')
            else:
                # 세모
                if aList.count(1) > bList.count(1):
                    print('A')
                elif aList.count(1) < bList.count(1):
                    print('B')
                else:
                    print('D')
