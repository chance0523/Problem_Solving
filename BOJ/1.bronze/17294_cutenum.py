# 17294번. 귀여운 수


n = list(map(int, input()))

if len(n) == 1:
    print('◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!')
else:
    d = n[0]-n[1]
    if len(n) == 2:
        print('◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!')
    else:
        flag = True
        for i in range(1, len(n)-1):
            if n[i]-n[i+1] != d:
                print('흥칫뿡!! <(￣ ﹌ ￣)>')
                flag = False
                break
        if flag:
            print('◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!')
