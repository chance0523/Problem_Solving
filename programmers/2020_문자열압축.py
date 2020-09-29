def solution(s):
    answer = len(s)
    if len(s) == 1:
        return 1
    for ap in range(1, len(s)//2+1):  # ap == 압축. 절반까지만 돌면 됨
        apstr = s[:ap]
        cnt = 1
        ans = ''
        for i in range(ap, len(s), ap):
            if apstr == s[i:i+ap]:  # 압축 가능할때
                cnt += 1  # 압축 횟수 카운트
            else:  # 압축 불가
                if cnt == 1:  # 압축 한 번도 못 했으면
                    cnt = ''
                ans += str(cnt) + apstr  # 문자열 만들기

                apstr = s[i:i+ap]  # 다음 셋
                cnt = 1  # 초기화

        # 압축 길이 한 번 다 돌았을 때
        if cnt == 1:  # flush
            cnt = ''
        ans += str(cnt)+apstr

        answer = min(answer, len(ans))

    return answer
