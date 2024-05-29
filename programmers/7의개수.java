class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for (int i = 0; i < array.length; i++) {
            answer += count7(array[i]);
        }
        return answer;
    }
    
    private int count7(int num) {
        int count = 0;
        String str = String.valueOf(num);
        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).equals("7")) {
                count++;
            }
        }
        
        return count;
    }
}
