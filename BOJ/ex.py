n = int(input())
# n<=9로 작아서 brute force로도 가능하다.


def func(l, num):
    global ans
    if l == n:  # n자리수 다 채웠으면
        if num % 3 == 0:  # 3의 배수인지 확인
            ans += 1
        return

    func(l + 1, num + 0)  # 다음 수 채워줌
    func(l + 1, num + 1)
    func(l + 1, num + 2)


ans = 0
func(1, 1)
func(1, 2)

print(ans)
