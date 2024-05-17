class Solution {
    public int solution(String number) {
        int answer = 0;
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            sum += Integer.parseInt(String.valueOf(number.charAt(i)));
        }
        return sum % 9;
    }
}
