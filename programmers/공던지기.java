class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int cnt = 0;
        while (k > 0) {
            answer = numbers[cnt];
            if (cnt + 1 == numbers.length) {
                cnt = 1;
            }
            else if (cnt + 2 == numbers.length) {
                cnt = 0;
            }
            else {
                cnt += 2;
            }
            k--;
        }
        return answer;
    }
}
