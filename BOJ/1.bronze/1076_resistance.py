# 1076번. 저항


rDict = {
    'black': 0,
    'brown': 1,
    'red': 2,
    'orange': 3,
    'yellow': 4,
    'green': 5,
    'blue': 6,
    'violet': 7,
    'grey': 8,
    'white': 9
}

a1 = input()
a2 = input()
a3 = input()
ans = (rDict[a1]*10+rDict[a2])*(10**rDict[a3])
print(ans)
