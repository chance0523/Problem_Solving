class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int[] result = {};
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        int len = num_list.length;
        int cnt = 0;
        
        switch (n) {
            case 1:
                result = new int[b + 1];
                for (int i = 0; i <= b; i++) {
                    result[i] = num_list[i];
                }
                return result;
            case 2:
                result = new int[len - a];
                cnt = 0;
                for (int i = a; i < len; i++) {
                    result[cnt++] = num_list[i];
                }
                return result;
            case 3:
                result = new int[b - a + 1];
                cnt = 0;
                for (int i = a; i <= b; i++) {
                    result[cnt++] = num_list[i];
                }
                return result;
            case 4:
                result = new int[(b - a) / c + 1];
                cnt = 0;
                for (int i = a; i <= b; i+=c) {
                    result[cnt++] = num_list[i];
                }
                return result;
                
        }
        return result;
    }
}
