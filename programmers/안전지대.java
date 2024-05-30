class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int len = board.length;
        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (board[i][j] == 1) {
                    for (int d = 0; d < dx.length; d++) {
                        int x = i + dx[d];
                        int y = j + dy[d];
                        if (x >= 0 && y >= 0 && x < len && y < len && board[x][y] == 0) {
                            board[x][y] = 2;
                        }
                    }
                }
            }
        }
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (board[i][j] == 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
