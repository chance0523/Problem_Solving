# 10773번. 제로

k = int(input())
stack = []
for i in range(k):
    num = int(input())
    if num != 0:
        stack.append(num)
    else:
        stack.pop()

print(sum(stack))
