// 약수의 합
// https://programmers.co.kr/learn/courses/30/lessons/12928

class Solution {
    fun solution(n: Int): Int = (1..n).filter{ n % it == 0 }.sum()
}