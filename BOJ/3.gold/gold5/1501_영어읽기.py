# 1501번. 영어 읽기


# 첫 문자와 제일 끝 문자가 일치하고, 그 사이의 문자들은
# 순서가 어떻게 뒤바뀌어 있더라도 읽는 데 지장이 없다고 한다.


def get_bit(s):
    if len(s) < 3:  # 길이가 2면 자를 수 없다.
        return -1
    else:
        s = list(s[1:-1])  # 여기만 사용
        s.sort()  # 정렬 해주고
        return ''.join(s)  # 다시 문자열로 합쳐줌


nList = []
for i in range(int(input())):
    s = input()
    nList.append([s, s[0], s[-1], get_bit(s)])

m = int(input())
for i in range(m):
    # 문장을 분리
    sList = list(input().rstrip().split(' '))

    ans = 1
    pList = [0 for i in range(len(sList))]
    index = 0
    for s in sList:  # 단어 하나씩 꺼내서
        bit = get_bit(s)
        for n in nList:  # 알고 있는 단어와 비교
            if len(s) == len(n[0]):
                if s[0] == n[1] and s[-1] == n[2]:
                    if bit == n[-1]:
                        # 해석 가능하면
                        pList[index] += 1  # 경우의 수 늘려줌
        index += 1

    for p in pList:  # 모든 경우의 수를 곱연산
        ans *= p
    print(ans)
