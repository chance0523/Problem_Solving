class Solution {
    public String solution(String my_string, int[][] queries) {
        StringBuilder ans = new StringBuilder(my_string);
        
        for(int i = 0; i < queries.length; i++) {
            int s = queries[i][0];
            int e = queries[i][1];
            
            StringBuilder sb = new StringBuilder(ans.substring(s, e + 1));
            sb.reverse();
            ans.replace(s, e + 1, sb.toString());
        }
        
        return ans.toString();
    }
}
