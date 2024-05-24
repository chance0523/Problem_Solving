class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        String numStr = String.valueOf(num);
        String kk = String.valueOf(k);
        
        if (!numStr.contains(kk)) {
            return -1;
        }
        
        
        return numStr.indexOf(kk) + 1;
    }
}
