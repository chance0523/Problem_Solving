class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuffer sb = new StringBuffer(my_string);
        return sb.replace(s, e + 1, new StringBuffer(my_string.substring(s, e + 1)).reverse().toString()).toString();
    }
}
