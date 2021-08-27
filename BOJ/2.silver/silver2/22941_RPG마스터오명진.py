# 22941번. RPG 마스터 오명진


yhp, yatk, mhp, matk = map(int,input().split())
p,s = map(int, input().split())

if yatk >= mhp:
    print('Victory!')
elif matk >= yhp:
    print('gg')
else:
    t = yhp // matk # 이 턴이면 마왕이 용사의 체력을 모두 깎는다.
    if yhp % matk:
        t += 1
    t1 = (mhp - p) // yatk # 이 턴이면 마왕이 체력을 회복할때까지 깎는다.
    if (mhp - p) % yatk:
        t1 += 1
    
    hp = mhp - t1 * yatk # 이 체력까지 깎는다
    if hp <= 0:
        if t>=t1:
            print('Victory!')
        else:
            print('gg')
        exit(0)
    hp += s # 체력 회복

    t2 = hp // yatk
    if hp % yatk:
        t2 += 1
    if t>=(t1+t2):
        print('Victory!')
    else:
        print('gg')