class Solution {
    public String solution(int q, int r, String code) {
        String answer = "";
        for (int i = 0; i< code.length(); i++) {
            if (i % q == r) {
                answer += String.valueOf(code.charAt(i));
            } 
        }
        
        return answer;
    }
}
