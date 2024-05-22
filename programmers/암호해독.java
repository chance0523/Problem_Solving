class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        for (int i = 0; i < cipher.length(); i++) {
            if (i % code == (code - 1)) {
                answer += String.valueOf(cipher.charAt(i));
            }
        }
        
        return answer;
    }
}
