# 6996번. 애너그램


for _ in range(int(input())):
    a,b = input().split()
    aList = list(a)
    bList = list(b)
    aList.sort()
    bList.sort()
    flag=True
    for i in range(len(aList)):
        if len(a)!=len(b):
            flag = False
            break
        if aList[i]!=bList[i]:
            flag=False
            break
    if flag:
        print(a, '&', b, 'are anagrams.')
    else:
        print(a, '&', b, 'are NOT anagrams.')
