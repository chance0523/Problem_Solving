class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for (int i = 0; i < queries.length; i++) {
            int arr_i = queries[i][0];
            int arr_j = queries[i][1];
            int x = arr[arr_i];
            int y = arr[arr_j];
            arr[arr_i] = y;
            arr[arr_j] = x;
        }
        return arr;
    }
}
