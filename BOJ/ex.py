for _ in range(int(input())):
    al = list(input().split()) # 모든 울음소리들
    while True:
        st = input() # 문구
        if st == 'what does the fox say?':
            print(' '.join(al)) # 출력 만들기
            break
        st = list(st.split())
        w = st[-1]
        while w in al: # 울음소리 삭제해줌
            al.remove(w)
