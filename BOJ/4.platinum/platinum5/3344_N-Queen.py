# 3344번. N-Queen


"""
1. If the remainder from dividing n by 6 is not 2 or 3
then the list is simply all even numbers followed by all odd numbers not greater than n.

2. Otherwise, write separate lists of even and odd numbers (2, 4, 6, 8 – 1, 3, 5, 7).

3. If the remainder is 2, swap 1 and 3 in odd list and move 5 to the end (3, 1, 7, 5).

4. If the remainder is 3, move 2 to the end of even list and 1,3 to the end of odd list (4, 6, 8, 2 – 5, 7, 1, 3).

5. Append odd list to the even list and place queens in the rows given by these numbers,
from left to right (a2, b4, c6, d8, e3, f1, g7, h5).
"""

n = int(input())
ans = 2
# 3번 조건
if n % 6 == 2:
    cnt = n - 4
    while cnt:
        print(ans)
        ans += 2
        if ans > n:
            print(3)
            print(1)
            ans = 7
        cnt -= 1
    print(ans)
    print(5)  # move 5 to end
elif n % 6 == 3:
    ans = 4
    cnt = n - 3
    while cnt:
        print(ans)
        ans += 2
        if ans > n and ans % 2 == 0:
            print(2)
            ans = 5
        cnt -= 1
    print(1)
    print(3)
else:
    # 1번 조건대로 출력
    for i in range(1, n + 1):
        print(ans)
        ans += 2
        if ans > n:
            ans = 1
