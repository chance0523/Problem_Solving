# 17388번. 와글와글 숭고한


s, k, h = map(int, input().split())
if s + k + h >= 100:
    print('OK')
else:
    m = min(s, k, h)
    if m == s:
        print('Soongsil')
    if m == k:
        print('Korea')
    if m == h:
        print('Hanyang')