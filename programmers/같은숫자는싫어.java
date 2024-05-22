import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();
        int temp = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != temp) {
                list.add(arr[i]);
                temp = arr[i];
            }
        }
        
        int size = list.size();
        answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
