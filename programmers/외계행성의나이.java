class Solution {
    public String solution(int age) {
        String answer = "";
        String age962 = "abcdefghij";
        String ageStr = String.valueOf(age);
        for (int i = 0; i < ageStr.length(); i++) {
            answer += age962.charAt(Integer.valueOf(String.valueOf(ageStr.charAt(i))));
        }
        return answer;
    }
}
