import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String[] answer = {};
        String[] arr = myString.split("x");
        
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++){
            if (arr[i].length() > 0) {
                list.add(arr[i]);
            }
        }
        
        int size = list.size();
        answer = new String[size];
        
        for (int i = 0; i < size; i++) {
            answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);
        return answer;
    }
}
