# 9655번. 돌게임


n = int(input())
# 돌은 홀수개씩 줄어듬
if n % 2 == 1:
    print('SK')
else:
    print('CY')

# 숏코딩
# print('SK' if int(input()) % 2 else 'CY')
