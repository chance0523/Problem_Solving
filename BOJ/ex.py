n = input().rstrip()
f = int(input())
new_n = n[:-2] + '00'
new_n = int(new_n)
for num in range(new_n, 2222222222):
    if num%f == 0:
        ans = str(num)[-2:]
        print(ans)
        break
