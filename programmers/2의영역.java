import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                list.add(i);                
            }
        }
        
        int size = list.size();
    
        if (size == 0) {
            return new int[]{ -1 };
        }
        
        if (size == 1) {
            return new int[]{ 2 };
        }
        
        if (size > 1) {
            int[] result = new int[list.get(size - 1) - list.get(0) + 1];
            int count = 0;
            int idx = 0;
            for (int i = 0; i < arr.length; i++) {
                if (count == size) {
                    return result;
                }
                if (arr[i] == 2 && count < size) {
                    result[idx++] = 2;
                    count++;
                }
                else if (arr[i] != 2 && count > 0 && count < size) {
                    result[idx++] = arr[i];
                }
            }
            return result;
        }
        
        return answer;
    }
}
