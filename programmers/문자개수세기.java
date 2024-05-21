class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[26*2];
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            if (c >= 'a' && c <= 'z') {
                answer[26 + c - 'a']++;
            }
            else {
                answer[c - 'A']++;
            }
        } 
        return answer;
    }
}
