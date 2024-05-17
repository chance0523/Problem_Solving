class Solution {
    public int solution(int a, int b, int c) {
        int ans1 = a + b + c;
        int ans2 = ans1 * (a * a + b * b + c * c);
        int ans3 = ans2 * (a * a * a + b * b * b + c * c * c);
        
        if (a != b && a != c && b != c) {
            return ans1;
        }
        if (a == b && a != c) {
            return ans2;
        }
        if (a == c && a != b) {
            return ans2;
        }
        if (b == c && a != b) {
            return ans2;
        }
        if (a == b && b == c) {
            return ans3;
        }
        return 0;
    }
}
