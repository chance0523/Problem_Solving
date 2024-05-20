class Solution {
    public int solution(int balls, int share) {
        long answer = 1;
        int count = 1;
        for (int i = balls - share + 1; i <= balls; i++) {
            answer *= i;
            answer /= count;
            count++;
        }
        
        return (int) answer;
    }
}
