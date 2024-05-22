class Solution {
    public int solution(int order) {
        int answer = 0;
        String od = order + "";
        for (int i = 0; i < od.length(); i++) {
            char cur = od.charAt(i);
            if (cur == '3' || cur == '6' || cur == '9') {
                answer++;
            }
        }
        return answer;
    }
}
