# 1924번. 2007년


x, y = map(int, input().split())

m = [31, 28, 31, 30, 31, 30,
     31, 31, 30, 31, 30, 31]

td = 0  # 1월 1일부터 얼마나 지났는지
if x > 1:
    for i in range(x-1):
        td += m[i]
    td += y
else:
    td += y

date = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT']
print(date[td % 7])
