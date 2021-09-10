# 정확성
def solution(info, query):
    ans = []
    for i in range(len(info)):
        info[i] = list(info[i].split())
    for q in query:
        q = list(q.split())
        cnt = 0
        for i in range(len(info)):
            if q[0] != '-' and q[0] != info[i][0]:
                continue
            if q[2] != '-' and q[2] != info[i][1]:
                continue
            if q[4] != '-' and q[4] != info[i][2]:
                continue
            if q[6] != '-' and q[6] != info[i][3]:
                continue
            if int(q[7]) <= int(info[i][4]):
                cnt += 1
        ans.append(cnt)
    return ans
    