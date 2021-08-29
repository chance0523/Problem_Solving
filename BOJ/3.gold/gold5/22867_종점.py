import sys
input =  sys.stdin.readline


def convert(t):
    h = int(t[:2])
    m = int(t[3:5])
    s = int(t[6:8])
    ss = int(t[9:])
    t = ss + s*1000 + m*1000*60 + h*1000*60*60
    return t
n = int(input())
nList = []
time = []
for i in range(n):
    _in,out = input().rstrip().split()
    time.append([convert(_in), 2]) # 종점에서는 출발이 먼저
    time.append([convert(out), 1])

time.sort()

ans = 0
cnt = 0
for i in range(len(time)):
    if time[i][1] == 2: # 종점으로 들어옴 (자리 필요)
        cnt += 1
    else: # 종점에서 나감
        ans = max(ans,cnt)
        cnt -= 1
print(ans)
