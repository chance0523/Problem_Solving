'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''
for _ in range(int(input())):
    n = int(input())
    nList = list(map(int,input().split()))

    # 딕셔너리로 해도 되고, 1,000,001짜리 배열로 해도 된다
    nDict = {}
    for i in range(n):
        nDict[nList[i]] = 1

    m = int(input())
    mList = list(map(int,input().split()))
    
    for i in range(m):
        if mList[i] in nDict.keys():
            print(1)
        else:
            print(0)
