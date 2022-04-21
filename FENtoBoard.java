public class FENtoBoard {
	
	static char[][] FENtoPosition(String FEN) {
		
		System.out.println(FEN);
		char[][] board = new char[8][8];
	    int fileCounter = 0; // is increasing
	    int rankCounter = 7; // is decreasing
	    
	 
	    for (int i = 0; i < FEN.length(); i++ ) {
	        
	    	if (FEN.charAt(i) == ' ') { // if its the terminating space
	            break;
	        }
	        
	        char character =  FEN.charAt(i);
	        int alphaNum = -1;
	        
	        if (Character.isAlphabetic(character)) {
	        	alphaNum = 0;
	        }
	        else if (Character.isDigit(character)) {
	        	alphaNum = 1;
	        } else if (character == '/') {
	        	alphaNum = 2;
	        }
	        
	        System.out.println("\nStart Rank counter: " + rankCounter);
        	System.out.println("Start File count: " + fileCounter);
	        System.out.println("Character: " + character);

	        switch(alphaNum){
	            case 0: //if FEN at i is character
	                board[rankCounter][fileCounter] = FEN.charAt(i);
	                break;

	            case 1: // if FEN at i is digit
	                for (int j = 0; j < Character.getNumericValue(character); j++) {
	                    board[rankCounter][fileCounter] = '-';
	                    fileCounter++;
	                }
	                fileCounter--;
	                //System.out.println("End Rank counter: " + rankCounter);
	            	//System.out.println("End File count: " + fileCounter);
	                break;
	                
	            case 2: // if FEN at i is "/"
	            	fileCounter--;
	            	break;
	            	

	            default:
	                break;
	        }
	        fileCounter++;
	        
	        if (fileCounter == 8) {
	            fileCounter = 0;
	            rankCounter -= 1;
	        }
	    }
	    return board;
	} // end FENtoBoard
	
	public static void main(String[] args) {
		String FEN = "8/5Q1p/3Nk3/p3P2p/8/7P/1PP2K2/4R3 b - - 1 35";
	    char[][] board = FENtoBoard.FENtoPosition(FEN);
	    
	    
	    
	    System.out.println("\n");
	    
	    for (int i = 7; i >= 0; i--) {
	    	for (int j = 0; j < 8; j++) {
	    		System.out.print(board[i][j] + " ");
	    	}
	    	System.out.println();
	    }
	} // end main
	
	
	
}