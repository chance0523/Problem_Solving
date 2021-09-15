s = input()
ns = ''
t = input()
nt = ''
for i in range(100):
    ns += s
    nt += t
l = len(s)*len(t)
if ns[:l] == nt[:l]:
    print(1)
else:
    print(0)
