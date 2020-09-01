# 15927번. 회문은 회문아니야!!


s = input()

isnotPalindrome = False
isnotSame = False
# 전체가 같은 문자면 -1
# 전체가 palindrome이 아니면 len(s)
# 전체가 palindrome이면 len(s)-1

if s == s[0]*len(s):  # 전체가 같은 문자열
    print(-1)

elif s != s[::-1]:  # s[::-1]은 문자열 뒤집은것. 비교해서 다르면 팰린드롬이 아니다
    print(len(s))

else:  # 그 외의 경우
    print(len(s)-1)
