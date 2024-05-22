class Solution {
    public String[] solution(String[] str_list) {
        String[] answer = {};
        for (int i = 0; i < str_list.length; i++) {
            if (str_list[i].equals("l")) {
                answer = new String[i];
                for (int  j = 0; j < answer.length; j++) {
                    answer[j] = str_list[j];
                }
                return answer;
            }
            else if (str_list[i].equals("r")) {
                if (i == str_list.length - 1) {
                    return answer;
                }
                answer = new String[str_list.length - i - 1];
                for (int  j = i + 1; j < str_list.length; j++) {
                    answer[j - i - 1] = str_list[j];
                }
                return answer;
            }
        }
        return answer;
    }
}
