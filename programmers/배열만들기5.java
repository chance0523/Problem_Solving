import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < intStrs.length; i++) {
            String intStr = intStrs[i];
            String subStr = intStr.substring(s, s + l);
            int subInt = Integer.parseInt(subStr);
            if (subInt > k) {
                list.add(subInt);
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
