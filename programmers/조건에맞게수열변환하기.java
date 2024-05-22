class Solution {
    public int[] solution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (num >= 50 && num % 2 == 0) {
                arr[i] = num / 2;
            }
            if (num < 50 && num % 2 == 1) {
                arr[i] = num *  2;
            }
        }
        
        return arr;
    }
}
