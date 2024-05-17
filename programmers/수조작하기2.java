class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        for (int i = 0; i < numLog.length - 1; i++) {
            int diff = numLog[i + 1] - numLog[i];
            if (diff == 1) {
                answer += "w";
            }
            else if (diff == -1) {
                answer += "s";
            }
            else if (diff == 10) {
                answer += "d";
            }
            else { // -10
                answer += "a";
            }
        }
        
        return answer;
    }
}
