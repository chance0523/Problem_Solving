for _ in range(int(input())):
    a,b = input().split()
    a = int(a, 2) # 이진수를 십진수로
    b = int(b, 2)
    print(bin(a+b)[2:]) # 십진수를 이진수로. 앞에 b2는 잘라줌
