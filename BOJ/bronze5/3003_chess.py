# 3003번. 킹, 퀸, 룩, 비숍, 나이트, 폰

king, queen, rook, bishop, knight, pawn = map(int, input().split(' '))
# 1,1,2,2,2,8
print(1-king, 1-queen, 2-rook, 2-bishop, 2-knight, 8-pawn)
