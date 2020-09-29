play_time ="02:03:55"
adv_time = "00:14:15"
logs = ["01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"]
def solution(play_time, adv_time, logs):
    answer = ''
    pList = list(map(int,play_time.split(':')))
    aList = list(map(int,adv_time.split(':')))
    print(pList)

    lList = []
    for log in logs:
        a,b = log.split('-')
        lList.append([list(map(int,a.split(':'))),list(map(int,b.split(':')))])
    print(lList)

    # 누적 시간 만들기
    tList = [0 for i in range(pList[0]*3600+pList[1]*60+pList[2]+1)]
    for i in range(len(lList)):
        s = lList[i][0]
        e = lList[i][1]
        for j in range(s[0]*3600+s[1]*60+s[2],e[0]*3600+e[1]*60+e[2]+1):
            tList[j]+=1
    
    # 광고 넣을 곳 정하기
    c = aList[0]*3600+aList[1]*60+aList[2]
    maxsum = -1
    idx = 0
    s = 0
    cursum = sum(tList[s:s+c+1])
    print(cursum)
    
    while True:
        if s+c+1==len(tList):
            break
        if cursum>maxsum:
            maxsum=cursum
            idx = s
        cursum-=tList[s]
        cursum+=tList[s+c+1]
        s+=1

    h = idx//3600
    idx -= h*3600
    m = idx//60
    idx -= m*60
    s = idx
    print(h,m,s)

    if h<10:
        h = '0'+str(h)
    if m<10:
        m = '0'+str(m)
    if s<10:
        s = '0'+str(s)
    answer = str(h)+':'+str(m)+':'+str(s)
    return answer


print(solution(play_time, adv_time, logs))