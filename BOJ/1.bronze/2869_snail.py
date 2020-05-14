# 2869번. 달팽이는 올라가고 싶다

a, b, v = map(int, input().split())

m = 0
if (v-b) % (a-b) == 0:
    m = (v-b)//(a-b)
else:
    m = ((v-b)//(a-b))+1
print(m)
