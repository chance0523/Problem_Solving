# 17496번. 스타후르츠


n, t, c, p = map(int, input().split())
# (n-1)//t -> 총 몇 번 수확 할 수 있는지
print(((n-1)//t)*c*p)
