class Solution {
    public int solution(int angle) {
        int answer = 0;
        if (angle == 180) {
            return 4;
        }
        if (angle > 90) {
            return 3;
        }
        if (angle == 90) {
            return 2;
        }
        return 1;
    }
}
