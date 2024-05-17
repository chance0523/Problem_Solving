class Solution {
    public int solution(int n, String control) {
        for (int i = 0; i < control.length(); i++) {
            String c = String.valueOf(control.charAt(i));
            switch (c) {
                case "w":
                    n++;
                    continue;
                case "s":
                    n--;
                    continue;
                case "d":
                    n += 10;
                    continue;
                case "a":
                    n -= 10;
                    continue;
            }
        }
        return n;
    }
}
