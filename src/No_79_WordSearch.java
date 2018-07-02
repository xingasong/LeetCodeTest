public class No_79_WordSearch {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(helper(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int i, int j, int index) {
        if(index==word.length()) return true;
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1 || board[i][j]!=word.charAt(index)) return false;
        board[i][j] = '*';
        boolean res = helper(board, word, i-1, j, index+1) || helper(board, word, i+1, j, index+1) || helper(board, word, i, j-1, index+1) || helper(board, word, i, j+1, index+1);
        board[i][j] = word.charAt(index);
        return res;
    }

    public static void main(String args[]) {
        char[][] board = {{'b'}, {'a'}, {'b'}};
        String word = "bbabab";
        No_79_WordSearch test = new No_79_WordSearch();
        System.out.println(test.exist(board, word));
        int a = Integer.MAX_VALUE;
    }
}
