# 5554번. 심부름 가는 길

sum = 0
for i in range(4):
    sum += int(input())

x = sum//60
y = sum % 60
print(x)
print(y)
