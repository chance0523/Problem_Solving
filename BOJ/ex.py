import sys

for _ in range(int(input())):
    start = 2100
    end = 2399
    mid = (start+end) // 2
    # ret = int(sys.stdin.readline().rstrip())
    cnt = 0
    flag = True
    while True:
        print(f'? {mid}')
        sys.stdout.flush()
        ret = int(sys.stdin.readline().rstrip())
        if end - start == 2:
            if ret == 1:
                print(f'? {mid}')
                start += 1
                sys.stdout.flush()
                continue
            else:
                print(f'? {mid-1}')
                end -= 1
                sys.stdout.flush()
                continue
        if end - start == 1:
            start += 1
            if ret == 1:
                print(f'? {end}')
                sys.stdout.flush()
                ret = int(sys.stdin.readline().rstrip())
                if ret == 0:
                    print(f'! {end-1}')
                    sys.stdout.flush()
                    break
        else:
            if start>=end or cnt == 18:
                if flag:
                    print(f'! {start}')
                else:
                    print(f'! {start}')
                sys.stdout.flush()
                break
            if ret == 1:
                start = mid + 1
                mid = (start+end) // 2
                flag = True
            else:
                end = mid - 1
                mid = (start+end) // 2
                flag = False
        cnt += 1
