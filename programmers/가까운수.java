class Solution {
    public int solution(int[] array, int n) {
        int answer = array[0];
        int min = 10000;
        int diff = 0;
        for (int i = 0; i < array.length; i++) {
            diff = Math.abs(array[i] - n);
            if (diff < min) {
                min = diff;
                answer = array[i];
            }
            else if (diff == min) {
                if (array[i] < answer) {
                    answer = array[i];
                }
            }
        }
        
        return answer;
    }
}
