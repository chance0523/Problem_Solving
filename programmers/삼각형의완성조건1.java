import java.util.*;

class Solution {
    public int solution(int[] sides) {
        Arrays.sort(sides);
        int a = sides[0];
        int b = sides[1];
        int c = sides[2];
        if (c < a + b) {
            return 1;
        }
        else {
            return 2;
        }
    }
}
