public class Board { //all our board specific methods here
    public Board() { //start board
        char[][] board = {
            {'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'},
            {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
            {'-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-'},
            {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
            {'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'}
        };
        this.board = board;
    }
    public void printBoard() { //display board
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void updateBoard(Square s1, Square s2) { //update board (for moves)
        board[s2.rank][s2.file] = board[s1.rank][s1.file];
        board[s1.rank][s1.file] = ' ';
    }
    public void clearBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = ' ';
            }
        }
    }
	public void FENtoPosition(String FEN) { //generate board from FEN notation
		clearBoard();
	    int fileCounter = 0; // is increasing
	    int rankCounter = 7; // is decreasing
	    
	    for (int i = 0; i < FEN.length(); i++ ) {
	        
            char character =  FEN.charAt(i);
	    	if (character == ' ') { // if its the terminating space
	            break;
	        }
	        
	        if (Character.isAlphabetic(character)) {
	        	this.board[rankCounter][fileCounter] = FEN.charAt(i);
	        }
	        else if (Character.isDigit(character)) {
                for (int j = 0; j < Character.getNumericValue(character); j++) {
                    this.board[rankCounter][fileCounter] = '-';
                    fileCounter++;
                }
                fileCounter--;
	        } 
            else if (character == '/') {
                fileCounter--;
	        }
	        fileCounter++;
	        
	        if (fileCounter == 8) {
	            fileCounter = 0;
	            rankCounter -= 1;
	        }
	    }
	}
    public String boardToFEN() { //convert board to FEN notation
        String FEN = "";
        int fileCounter = 0;
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == '-') {
                    fileCounter++;
                }
                else {
                    if (fileCounter != 0) {
                        FEN += fileCounter;
                        fileCounter = 0;
                    }
                    if (!(board[i][j] == '-')) {
                        FEN += board[i][j];
                    }
                }
            }
            if (fileCounter != 0) {
                FEN += fileCounter;
                fileCounter = 0;
            }
            FEN += "/";
        }
        return FEN;
    }
    private char[][] board; //2d array containing the board
}