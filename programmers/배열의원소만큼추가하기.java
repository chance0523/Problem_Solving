import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            for (int j = 0; j < a; j++) {
                list.add(a);
            }
        }
        
        int size = list.size();
        answer = new int[size];
        
        for (int i = 0; i < size; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
