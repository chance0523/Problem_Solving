class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        int r = my_string.length() / m;
        String[][] arr = new String[r][m];
        
        int idx = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < m; j++) {
                if (j == c - 1) {
                    answer += String.valueOf(my_string.charAt(idx));
                }
                idx++;
            }
        }
        
        return answer;
    }
}
