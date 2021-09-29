a,b = input().rstrip().split()

m = 1e9
for i in range(len(b) - len(a) + 1):
    cnt = 0
    for j in range(len(a)):
        if a[j] != b[i + j]:
            cnt += 1
    m = min(m, cnt)
print(m)