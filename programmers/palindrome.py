import time
import sys
input = sys.stdin.readline

# string = 'bbrrg'
# string = 'raingoawrngbowarnhoaenbeatinboeatihntaeoibhnaetoibnteaonaewoibnrebinaetpbnatepbonapaennwrvnwroibnrowaibnorainb'
string = 'raingoawrngbowarnhoaenbeatinboeatihntaeoibhnaetoibnteaonaewoibnrebinaetpbnatepbonapaennwrvnwroibnrowaibnorainbiubrwjbgkjrwbvruvozunvkrnbkwrngawrngoawrngwraubgrawubgoreangoawrngvorwanoraweuboraweuoawinboawrenboeaungawrungorwangowanovbrwagvnwraoorwnboarnbotaeinboeainboteangiaurbgviurweaorawnboiawnboiatngbotaengotneagoaenivnrwoavbinatobinteaobnatweogbantoraebvoawrngoiawrnboetaboetainboreianbvoteainboetainoretgvoaurwgvoarnboiaenobiatentopibnarweogvinawrogvnrwaobnwraorloawrigvhowarigvnroawiborabrowa'


def scatter(string):
    sList = list(string)
    scatterList = []
    for i in range(len(sList)+1):
        for j in range(i+1, len(sList)+1):
            s = sList[i:j]
            scatterList.append(s)
    return scatterList


def isPalindrome_raw(string):
    answer = 0
    for s in scatter(string):
        alpha = [0]*26
        for i in range(len(s)):
            c = ord(s[i])-97
            if alpha[c]:
                alpha[c] -= 1
            else:
                alpha[c] += 1
        if sum(alpha) <= 1:
            answer += 1
    return answer


def isPalindrome_bitmask(string):
    answer = 0
    for s in scatter(string):
        cnt = 0
        for i in range(len(s)):
            cnt = cnt ^ (1 << (ord(s[i])-97))
        if (cnt & (cnt-1)) == 0:
            # print(s, cnt)
            answer += 1
    return answer


start = time.perf_counter()

# print(isPalindrome_raw(string))
print(isPalindrome_bitmask(string))

print(time.perf_counter()-start)
