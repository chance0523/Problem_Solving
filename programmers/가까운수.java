class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int min = 10000;
        int diff = 0;
        for (int i = 0; i < array.length; i++) {
            diff = Math.abs(array[i] - n);
            if (diff < min) {
                min = diff;
                answer = array[i];
            }
        }
        
        return answer;
    }
}
