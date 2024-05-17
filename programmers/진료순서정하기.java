class Solution {
    public int[] solution(int[] emer) {
        int len = emer.length;
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i]++;
            for (int j = 0; j < len; j++) {
                if (emer[i] < emer[j]) {
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
}
