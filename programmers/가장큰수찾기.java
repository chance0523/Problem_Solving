class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        int maxIdx = 0;
        int max = -1;
        
        for (int i = 0; i < array.length; i++) {
            int cur = array[i];
            if (cur > max) {
                max = cur;
                maxIdx = i;
            }
        }
        
        answer[0] = max;
        answer[1] = maxIdx;
        
        return answer;
    }
}
