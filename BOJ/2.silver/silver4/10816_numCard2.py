# 10816번. 숫자 카드 2

_ = int(input())
nList = sorted(map(int, input().split()))
_ = int(input())
mList = list(map(int, input().split()))

i, m_dic = 0, {}

for m in sorted(mList):
    cnt = 0
    if m not in m_dic:
        while i < len(nList):
            # nList를 하나하나 지나면서
            # m과 같은지 확인
            if m == nList[i]:
                cnt += 1
                i += 1
            elif m > nList[i]:
                i += 1
            else:
                break
        m_dic[m] = cnt

print(' '.join(str(m_dic[m]) for m in mList))
