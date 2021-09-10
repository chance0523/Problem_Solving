from itertools import combinations
from bisect import bisect_left

def solution(info, query):
    ans = []
    infoDict = {}
    for i in range(len(info)):
        infoList = info[i].split()
        k = infoList[:-1] # key
        v = infoList[-1] # value
        for j in range(5):
            for c in combinations(k,j):
                temp = ''.join(c)
                if temp in infoDict:
                    infoDict[temp].append(int(v))
                else:
                    infoDict[temp] = [int(v)]
    
    for k in infoDict:
        infoDict[k].sort()
        
    for q in query:
        qList = q.split()
        while 'and' in qList:
            qList.remove('and')
        while '-' in qList:
            qList.remove('-')
        k = qList[:-1]
        v = qList[-1]
        
        k = ''.join(k)
        
        if k in infoDict:
            scores = infoDict[k]
            if scores:
                left = bisect_left(scores, int(v))
                ans.append(len(scores) - left)
        else:
            ans.append(0)
    return ans