N,M=map(int,input().split())
board=[]
for _ in range(N):
    board.append(list(map(str,list(input()))))

num_BW=[[0 for _ in range(M)] for _ in range(N)]
num_WB=[[0 for _ in range(M)] for _ in range(N)]

for i in range(M):
    for j in range(N):
        if (i+j)%2==0:
            if board[j][i]=='B':
                pass
            else:
                num_BW[j][i]+=1
        else:
            if board[j][i]=='W':
                pass
            else:
                num_BW[j][i]+=1

for i in range(M):
    for j in range(N):
        if (i+j)%2==0:
            if board[j][i]=='W':
                pass
            else:
                num_WB[j][i]+=1
        else:
            if board[j][i]=='B':
                pass
            else:
                num_WB[j][i]+=1

min_num=64

for i in range(7,M):
    for j in range(7,N):
        sum_num=0
        for p in range(8):
            for q in range(8):
                if num_BW[j-q][i-p]:
                    sum_num+=1
        if sum_num<=min_num:
            min_num=sum_num

for i in range(7, M):
    for j in range(7, N):
        sum_num = 0
        for p in range(8):
            for q in range(8):
                if num_WB[j-q][i-p]:
                    sum_num += 1
        if sum_num <= min_num:
            min_num = sum_num

print(int(min_num))