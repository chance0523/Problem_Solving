class Solution {
    public int[] solution(int[] num_list) {
        int len = num_list.length;
        int[] answer = new int[len + 1];
        int last = num_list[len - 1];
        int last_before = num_list[len - 2];
        
        for (int i = 0; i < len; i++) {
            answer[i] = num_list[i];
        }
        
        if (last > last_before) {
            answer[len] = last - last_before;
        }
        else {
            answer[len] = last * 2;
        }
        
        return answer;
    }
}
