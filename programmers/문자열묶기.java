class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        int[] arr = new int[31];
        for (int i = 0; i < strArr.length; i++) {
            arr[strArr[i].length()]++;
        }
        
        
        for (int i = 0; i < arr.length; i++) {
            answer = Math.max(answer, arr[i]);
        }
        
        return answer;
    }
}
