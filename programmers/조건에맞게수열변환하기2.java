class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int[] newArr = new int[arr.length];
        
        while(true) {
            for (int i = 0; i < arr.length; i++) {
                int num = arr[i];
                if (num >= 50 && num % 2 == 0) {
                    newArr[i] = num / 2;
                }
                else if (num < 50 && num % 2 == 1) {
                    newArr[i] = num * 2 + 1;
                }
                else {
                    newArr[i] = num;
                }
            }
            
            if (isEqual(arr, newArr)) {
                return answer;
            }
            
            for (int i = 0; i < arr.length; i++) {
                arr[i] = newArr[i];
            }
            answer++;
        }
    }
    
    private boolean isEqual(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        
        return true;
    }
}
