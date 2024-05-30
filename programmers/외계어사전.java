import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        for (int i = 0; i < dic.length; i++) {
            if (canRead(spell, dic[i])) {
                return 1;
            }
        }
        
        return answer;
    }
    
    private boolean canRead(String[] spell, String word) {
        int len = spell.length;
        if (len != word.length()) {
            return false;
        }
        
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (word.contains(spell[i])) {
                count++;
            }
        }
        
        return count == len;
    }
}
