class Solution {
    public String solution(String my_string) {
        String answer = "";
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            if (Character.isUpperCase(c)) {
                answer += Character.toLowerCase(c);
            }
            else {
                answer += Character.toUpperCase(c);
            }
        }
        
        return answer;
    }
}
