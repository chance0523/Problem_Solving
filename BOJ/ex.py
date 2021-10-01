while True:
    try:
        a = input()
        b = input()
        alpha1 = [0 for i in range(26)]
        alpha2 = [0 for i in range(26)]
        for i in range(len(a)):
            alpha1[ord(a[i]) - ord('a')] += 1
        for i in range(len(b)):
            alpha2[ord(b[i]) - ord('a')] += 1
        ans = ''
        for i in range(26):
            cnt = min(alpha1[i], alpha2[i])
            ans += chr(i+ord('a'))*cnt
        print(ans) 
    except EOFError:
        break