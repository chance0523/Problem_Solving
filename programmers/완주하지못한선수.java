import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        int j = 0;
        
        for (int i = 0; i < participant.length; i++) {
            if (i == completion.length || !participant[i].equals(completion[j])) {
                return participant[i];
            }
            j++;
        }
        
        return answer;
    }
}
