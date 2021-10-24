'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

e,f,c = map(int,input().split())
cur = e+f
ans = 0
while True:
    if cur < c: # 더이상 빈 병을 바꿀 수 없을 때
        break
    ans += cur//c # 빈 병을 새 병으로
    cur = cur%c + cur//c # 바꾸지 못한 빈 병 + 바꿔진 새 병(이제는 비어진)
print(ans)