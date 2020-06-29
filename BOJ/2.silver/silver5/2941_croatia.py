# 2941번. 크로아티아 알파벳


s = input().rstrip()
ans = len(s)

ans -= s.count('c=')
ans -= s.count('c-')
ans -= s.count('dz=')
ans -= s.count('d-')
ans -= s.count('lj')
ans -= s.count('nj')
ans -= s.count('s=')
ans -= s.count('z=')

print(ans)
