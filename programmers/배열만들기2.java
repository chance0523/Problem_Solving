import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> arr = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            String str = String.valueOf(i);
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                String cur = String.valueOf(str.charAt(j));
                if (cur.equals("0") || cur.equals("5")) {
                    count++;
                }
            }
            if (count == str.length()) {
                arr.add(i);
            }
        }
        
        if (arr.size() == 0) {
            int[] answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        
        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}
