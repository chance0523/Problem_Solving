# 5904번. Moo 게임


n = int(input())
i = 0  # S(i)
s = 3  # 초기값
k = 4  # 가운데 1 + k+2 (mooo)

while s <= n:  # n을 넘어가기 직전까지
    i += 1
    s = s + k + s  # 전체 문자열 길이 업데이트
    k += 1

k -= 1  # 하나를 빼줘야 인덱스를 맞출 수 있다.

while i >= 0:
    rest = (s - k) // 2  # 가운데 moooo를 뺀 나머지 한쪽. S(k-1)의 길이
    # 왼쪽 S(k-1)
    if n <= rest:
        s = rest  # 탐색할 문자열의 길이를 rest로 바꿔줌
        k -= 1  # S(k-1)

    # 가운데 moooo...
    elif rest < n <= rest + k:
        if n == rest + 1:  # 이게 가운데의 첫번째 인덱스
            print('m')
            break
        else:
            print('o')
            break

    # 오른쪽 S(k-1)
    else:
        n = n - rest - k  # 왼쪽 S(k-1)과 가운데 mooo...를 빼준 상태로 업데이트
        s = rest  # 탐색할 문자열의 길이를 rest로 바꿔줌
        k -= 1  # S(k-1)
    i -= 1
