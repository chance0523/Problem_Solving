# 4690번. 완전 세제곱


# a <= 100
# b,c,d <= 100
aList = [i**3 for i in range(101)]
ansList = []
for b in range(2, 101):
    for c in range(b, 101):
        for d in range(c, 101):
            a3 = b**3+c**3+d**3
            if a3 in aList:
                # print(a3, b, c, d)
                ansList.append([aList.index(a3), b, c, d])
ansList.sort()

for i in range(len(ansList)):
    print(
        f"Cube = {ansList[i][0]}, Triple = ({ansList[i][1]},{ansList[i][2]},{ansList[i][3]})")
