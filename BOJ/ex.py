n=int(input())
name = input().rstrip()
ans = 0
for _ in range(n):
    old = input().rstrip()
    flag = False
    for gan in range(1, len(old)):
        if flag:
            break
        flag = True
        for s in range(len(old)-gan*(len(name)-1)):
            cnt = 0
            for i in range(len(name)):
                if old[s + gan*i] != name[i]:
                    flag = False
                    break
                else:
                    cnt += 1
                if cnt == len(name):
                    flag = True
                    break
            if flag:
                ans += 1
                break

print(ans)