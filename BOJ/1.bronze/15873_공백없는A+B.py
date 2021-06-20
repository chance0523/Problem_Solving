# 15873번. 공백 없는 A+B


n = list(map(int, input()))
# n은 2~4자리이다
if len(n) == 4:  # 1010
    print(20)
elif len(n) == 3:
    # 3자리이면 a0b 또는 ab0이다
    if n[1] == 0:
        print(n[0] * 10 + n[-1])
    else:
        print(n[0] + n[1] * 10)
else:
    # 2자리이면 ab이다
    print(n[0] + n[-1])
