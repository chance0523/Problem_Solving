# 2417번. 정수 제곱근


n = int(input())
tempRoot = n**0.5  # 제곱근

if(tempRoot-int(tempRoot) == 0):  # 정수라면
    print(int(tempRoot))

else:
    print(int(tempRoot)+1)
