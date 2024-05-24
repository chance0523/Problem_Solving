import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        String[] answer = {};
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].contains("ad")) {
                continue;
            }
            list.add(strArr[i]);
        }
        
        int size = list.size();
        answer = new String[size];
        
        for (int i = 0; i < size; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
