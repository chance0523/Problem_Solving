'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline


for t in range(int(input())):
    s = input().rstrip()
    alpha = [0 for i in range(26)]
    aa = ord('a') # 귀찮으니 미리 만들어주자
    zz = ord('z')
    AA = ord('A')
    ZZ = ord('Z')
    for i in range(len(s)):
        if aa <= ord(s[i]) <= zz or AA <= ord(s[i]) <= ZZ: # 알파벳일때만
            alpha[ord(s[i].lower()) - aa] += 1 # 헷갈리니 소문자로 바꿔놓고 계산

    m = 1e9
    for i in range(26):
        m = min(m, alpha[i])

    ans = f'Case {t+1}: '
    if m == 1:
        ans += 'Pangram!'
    elif m == 2:
        ans += 'Double pangram!!'
    elif m == 3:
        ans += 'Triple pangram!!!'
    else:
        ans += 'Not a pangram'

    print(ans)