class Solution {
    public int solution(String[][] board, int h, int w) {
        int count = 0;
        
        int[] dh = { 0, 1, -1, 0};
        int[] dw = { 1, 0, 0, -1};
        
        int h_check = 0;
        int w_check = 0;
        for (int i = 0; i < 4; i++) {
            h_check = h + dh[i];
            w_check = w + dw[i];
            if (h_check == board.length || h_check < 0) {
                continue;
            }
            if (w_check == board[0].length || w_check < 0) {
                continue;
            }
            if (board[h][w].equals(board[h_check][w_check])) {
                count++;
            }
        }
        
        return count;
    }
}
