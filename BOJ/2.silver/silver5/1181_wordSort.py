# 1181번. 단어 정렬

n = int(input())
wList = []
for i in range(n):
    wList.append(input())

wList = list(set(wList))  # 중복 제거

wListSort = []

# word length와 word를 한번에 저장
for w in wList:
    wListSort.append((len(w), w))

wListSort.sort()

for len_w, w in wListSort:
    print(w)
