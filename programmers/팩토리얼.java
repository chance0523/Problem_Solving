class Solution {
    public int solution(int n) {
        int fac = 1;
        int num = 1;
        while(true) {
            fac *= num;
            if (fac <= n) {
                num++;
                continue;
            }
            else {
                break;
            }
        }
        return num - 1;
    }
}
