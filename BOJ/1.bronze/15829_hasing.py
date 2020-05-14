# 15829번. Hashing

l = int(input())
s = input()
s = list(s)
# ord('a') == 97
for i in range(l):
    s[i] = ord(s[i])-96


def hashing(s):
    sum = 0
    for i in range(l):
        sum += s[i]*(31**i)
    return (sum % 1234567891)


print(hashing(s))
