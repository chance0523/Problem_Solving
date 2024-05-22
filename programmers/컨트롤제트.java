class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] arr = s.split(" ");
        int mem = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("Z")) {
                answer -= mem;
            }
            else {
                mem = Integer.parseInt(arr[i]);
                answer += mem;
            }
        }
        
        return answer;
    }
}
