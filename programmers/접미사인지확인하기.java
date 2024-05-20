class Solution {
    public int solution(String my_string, String is_suffix) {
        int answer = 0;
        int len = is_suffix.length();
        if (my_string.length() < len) {
            return 0;
        }
        
        String sub = my_string.substring(my_string.length() - len);
        
        if (sub.equals(is_suffix)) {
            return 1;
        }
        
        return answer;
    }
}
