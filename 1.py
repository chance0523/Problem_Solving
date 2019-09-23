inp = input()
n = len(inp)
for i in range(n):
    print("["+str(10 ** (n-1-i)*int(inp[i]))+"]")
