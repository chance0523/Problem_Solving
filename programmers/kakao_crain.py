def solution(board, moves):
    answer = 0
    result=[]
    for num in moves:
        for i in range(len(board)):
            if board[i][num-1]==0:
                continue
            else:
                result.append(board[i][num-1])
                if len(result)>1:
                    if result[-1]==result[-2]:
                        answer+=2
                        del result[-1]
                        del result[-1]
                board[i][num-1]=0
                break
    return answer