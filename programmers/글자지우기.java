import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        Arrays.sort(indices);

        int i = 0; // my_string의 index
        int j = 0; // indices의 index
        while(true) {
            if (i == my_string.length()) {
                break;
            }
            if (j == indices.length) {
                // 나머지 문자열 담아줌
                for (int k = i; k < my_string.length(); k++) {
                    answer += String.valueOf(my_string.charAt(k));
                }
                break;
            }
            if (i == indices[j]) {
                i++;
                j++;
            }
            else {
                answer += String.valueOf(my_string.charAt(i));
                i++;
            }
        }
        return answer;
    }
}
