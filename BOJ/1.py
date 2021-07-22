N = int(input())
list_words = []
set_alphabet = set()
for _ in range(N):
    cur_word = input()
    list_words.append(cur_word)
    for char in cur_word:
        set_alphabet.add(char)

list_alphabet = list(set_alphabet)
ans = 0
visit_int = [False] * 10
mapping = [-1] * 10
a= 0
def recursion(cnt):
    global a
    global ans
    if cnt == len(list_alphabet):
        temp = 0
        for word in list_words:
            res = 0
            for char in word:
                num = mapping[list_alphabet.index(char)]
                res *= 10
                res += num
            temp += res
        ans = max(ans, temp)
        return
    for i in range(10):
        a+=1
        if visit_int[i]:
            continue
        visit_int[i] = True
        mapping[cnt] = i
        recursion(cnt + 1)
        visit_int[i] = False
recursion(0)
print(ans)
print(a)
