'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

n,l,h = map(int,input().split())
nList = list(map(int,input().split()))
nList.sort() # 낮은 점수, 높은 점수 빼주기 위해 정렬한다
s = sum(nList[l:n-h]) # 이 범위에 있는 점수만 계산한다
print(s / (n-l-h))