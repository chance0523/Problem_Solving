# 1251번. 단어나누기


word = list(input())
answer = []
wordList = []

for i in range(1, len(word) - 1):
    for j in range(i + 1, len(word)):
        a = word[:i]
        b = word[i:j]
        c = word[j:]
        a.reverse()
        b.reverse()
        c.reverse()
        wordList.append(a + b + c)

for w in wordList:
    answer.append(''.join(w))

answer.sort()
print(answer[0])