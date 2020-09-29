info = ["java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"]
query = ["java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"]

def solution(info, query):
    answer = []
    # 언어 직군 경력 소울푸드 점수
    # 1. 나눠서 저장
    info2 = []
    for i in range(len(info)):
        info2.append(info[i].split())
    info2.sort()

    for i in range(len(info2)):
        k = info2[i]
        if k[0][0]=='j':
            k[0] = 'J'
        elif k[0][0] == 'p':
            k[0] = 'P'
        elif k[0][0] =='c':
            k[0] = 'C'
        if k[1][0]=='b':
            k[1] = 'B'
        elif k[1][0] == 'f':
            k[1] = 'F'
        if k[2][0] == 'j':
            k[2] = 'U'
        elif k[2][0]=='s':
            k[2] = 'S'
        if k[3][0] == 'c':
            k[3] = 'H'
        elif k[3][0] == 'p':
            k[3] = 'Z'

    ldict=[
        'CBUH',
        'CBUZ',
        'CBSH',
        'CBSZ',
        'CFUH',
        'CFUZ',
        'CFSH',
        'CFSZ',
        'JBUH',
        'JBUZ',
        'JBSH',
        'JBSZ',
        'JFUH',
        'JFUZ',
        'JFSH',
        'JFSZ',
        'PBUH',
        'PBUZ',
        'PBSH',
        'PBSZ',
        'PFUH',
        'PFUZ',
        'PFSH',
        'PFSZ'    
        ]

    mdict={}
    bi = []
    for i in range(len(ldict)):
        a = 0
        for j in range(4):
            a+=1<<ord(ldict[i][j])-63
        mdict[a]=[]
        bi.append(a)
    
    
    for i in range(len(info2)):
        a=0
        for j in range(4):
            a+=1<<ord(info2[i][j])-63
        mdict[a].extend([int(info2[i][4])])

    q2 = []
    for i in range(len(query)):
        q2.append(query[i].split(' and '))
        st = q2[i][-1]
        a,b = st.split()
        q2[i][-1]=a
        q2[i].append(b)

    for i in range(len(q2)):
        k = q2[i]
        if k[0][0] !='-':
            if k[0][0]=='j':
                k[0] = 'J'
            elif k[0][0] == 'p':
                k[0] = 'P'
            elif k[0][0] =='c':
                k[0] = 'C'
        if k[1][0] !='-':
            if k[1][0]=='b':
                k[1] = 'B'
            elif k[1][0] == 'f':
                k[1] = 'F'
        if k[2][0] !='-':
            if k[2][0] == 'j':
                k[2] = 'U'
            elif k[2][0]=='s':
                k[2] = 'S'
        if k[3][0] !='-':
            if k[3][0] == 'c':
                k[3] = 'H'
            elif k[3][0] == 'p':
                k[3] = 'Z'

    q3=[]
    for i in range(len(q2)):
        st = ''.join(q2[i][:4])
        q3.append([st,int(q2[i][4])])

    for i in range(len(mdict)):
        for j in range(len(bi)):
            if len(mdict[bi[j]])>0:
                mdict[bi[j]].sort(reverse=True)
                # mdict[bi[j]].sort()

    for i in range(len(q3)):
        a=0
        cnt=0
        for j in range(4):
            if q3[i][0][j]!='-':
                a+=1<<ord(q3[i][0][j])-63

        for j in range(len(bi)):
            if bi[j] & a == a:
                aList = mdict[bi[j]]
                if len(aList)==0:
                    continue
                for k in range(len(aList)):
                    if aList[k]>=q3[i][1]:
                        cnt+=1
                    else:
                        break
                
        answer.append(cnt)
                    
    
    return answer

print(solution(info,query))