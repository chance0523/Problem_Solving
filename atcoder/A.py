import sys
input = sys.stdin.readline

x,y = map(int,input().rstrip().split('.'))
if 0<=y<=2:
    op = '-'
elif 3<=y<=6:
    op = ''
else:
    op = '+'
print(str(x)+op)