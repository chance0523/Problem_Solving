class Solution {
    public int[] solution(int[] arr, int[] query) {
        int start = 0;
        int end = arr.length - 1;
        int q = 0;
        for (int i = 0; i < query.length; i++) {
            q = query[i];
            if (i % 2 == 0) {
                end = start + q;
            }
            else {
                start = start + q;
            }
        }
        
        int size = end - start + 1;
        int[] result = new int[size];
        int idx = 0;
        for (int i = start; i <= end; i++) {
            result[idx++] = arr[i];
        }
        return result;
    }
}
