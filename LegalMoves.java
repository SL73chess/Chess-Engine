import java.util.ArrayList;

public class LegalMoves {
	
	public static ArrayList<Move> bishopMoves(char[][] board, char color) { // static suggested by eclipse
		// Gives list of all squares the bishop can theoretically move to
		// Does not check if the move is legal (if it leaves the king in check)
		
		// Behavior: Can go in any direction diagonally, only goes to empty squares, can't jump pieces
		
		ArrayList<Move> bishopMovesList = new ArrayList<Move>();
		
		if (color == 'W') {
			for (int rank = 0; rank < 8; rank++) {
				for (int file = 0; file < 8; file++) {
					if (board[rank][file] == 'B') {
						/// If white's turn, and there's a white bishop on said square
						
						// Diagonal going to index [7][7] H8
						int rankIndex = rank;
						int fileIndex = file;
						while (rankIndex < 7 && fileIndex < 7 && Character.isUpperCase(board[rankIndex + 1][fileIndex + 1]) == false) {
							Move legalBishopMove = new Move(new Square(rank, file), new Square(rankIndex + 1, fileIndex + 1));
							bishopMovesList.add(legalBishopMove);
							rankIndex++;
							fileIndex++;
							if (board[rankIndex][fileIndex] != '-' && Character.isUpperCase(board[rankIndex][fileIndex]) == false) {
								break;
							}
						} // end while
						
						// Diagonal going to index [0][0] A1
						rankIndex = rank;
						fileIndex = file;
						while (rankIndex > 0 && fileIndex > 0 && Character.isUpperCase(board[rankIndex - 1][fileIndex - 1]) == false) {
							Move legalBishopMove = new Move(new Square(rank, file), new Square(rankIndex - 1, fileIndex - 1));
							bishopMovesList.add(legalBishopMove);
							rankIndex--;
							fileIndex--;
							if (board[rankIndex][fileIndex] != '-' && Character.isUpperCase(board[rankIndex][fileIndex]) == false) {
								break;
							}
						} // end while
						
						// Diagonal going to index [0][7] A8
						rankIndex = rank;
						fileIndex = file;
						while (rankIndex > 0 && fileIndex < 7 && Character.isUpperCase(board[rankIndex - 1][fileIndex + 1]) == false) {
							Move legalBishopMove = new Move(new Square(rank, file), new Square(rankIndex - 1, fileIndex + 1));
							bishopMovesList.add(legalBishopMove);
							rankIndex--;
							fileIndex++;
							if (board[rankIndex][fileIndex] != '-' && Character.isUpperCase(board[rankIndex][fileIndex]) == false) {
								break;
							}
						} // end while
						
						// Diagonal going to index [7][0] H1
						rankIndex = rank;
						fileIndex = file;
						while (rankIndex < 7 && fileIndex > 0 && Character.isUpperCase(board[rankIndex + 1][fileIndex - 1]) == false) {
							Move legalBishopMove = new Move(new Square(rank, file), new Square(rankIndex + 1, fileIndex - 1));
							bishopMovesList.add(legalBishopMove);
							rankIndex++;
							fileIndex--;
							if (board[rankIndex][fileIndex] != '-' && Character.isUpperCase(board[rankIndex][fileIndex]) == false) {
								break;
							}
						} // end while
						
					} // end if bishop
				}
			}
		} // end white
		
		else if (color == 'B') {
			for (int rank = 0; rank < 8; rank++) {
				for (int file = 0; file < 8; file++) {
					if (board[rank][file] == 'b') {
						/// If black's turn, and there's a black bishop on said square
						
						// Diagonal going to index [7][7] H8
						int rankIndex = rank;
						int fileIndex = file;
						while (rankIndex < 7 && fileIndex < 7 && Character.isLowerCase(board[rankIndex + 1][fileIndex + 1]) == false) {
							Move legalBishopMove = new Move(new Square(rank, file), new Square(rankIndex + 1, fileIndex + 1));
							bishopMovesList.add(legalBishopMove);
							rankIndex++;
							fileIndex++;
							if (board[rankIndex][fileIndex] != '-' && Character.isLowerCase(board[rankIndex][fileIndex]) == false) {
								break;
							}
						}
						
						// Diagonal going to index [0][0] A1
						rankIndex = rank;
						fileIndex = file;
						while (rankIndex > 0 && fileIndex > 0 && Character.isLowerCase(board[rankIndex - 1][fileIndex - 1]) == false) { // while the square is empty
							Move legalBishopMove = new Move(new Square(rank, file), new Square(rankIndex - 1, fileIndex - 1));
							bishopMovesList.add(legalBishopMove);
							rankIndex--;
							fileIndex--;
							if (board[rankIndex][fileIndex] != '-' && Character.isLowerCase(board[rankIndex][fileIndex]) == false) {
								break;
							}
						}
						
						// Diagonal going to index [0][7] A8
						rankIndex = rank;
						fileIndex = file;
						while (rankIndex > 0 && fileIndex < 7 && Character.isLowerCase(board[rankIndex - 1][fileIndex + 1]) == false) { // while the square is empty
							Move legalBishopMove = new Move(new Square(rank, file), new Square(rankIndex - 1, fileIndex + 1));
							bishopMovesList.add(legalBishopMove);
							rankIndex--;
							fileIndex++;
							if (board[rankIndex][fileIndex] != '-' && Character.isLowerCase(board[rankIndex][fileIndex]) == false) {
								break;
							}
						}
						
						// Diagonal going to index [7][0] H1
						rankIndex = rank;
						fileIndex = file;
						while (rankIndex < 7 && fileIndex > 0 && Character.isLowerCase(board[rankIndex + 1][fileIndex - 1]) == false) { // while the square is empty
							Move legalBishopMove = new Move(new Square(rank, file), new Square(rankIndex + 1, fileIndex - 1));
							bishopMovesList.add(legalBishopMove);
							rankIndex++;
							fileIndex--;
							if (board[rankIndex][fileIndex] != '-' && Character.isLowerCase(board[rankIndex][fileIndex]) == false) {
								break;
							}
						}
					}
				}
			}
		}
		return bishopMovesList;
	} // End bishopMoves
	
	public static ArrayList<Move> knightMoves(char[][] board, char color) {
		// Gives list of all squares the knight can theoretically move to
		// Does not check if the move is legal (if it leaves the king in check)\
		
		// Behavior: Knights can only move onto empty squares, but can jump over pieces
		// They move 2 squares in any direction up/down/left/right, and then 1 square to make an L
		ArrayList<Move> knightMovesList = new ArrayList<Move>();
		int file;
		int rank;
		
		if (color == 'W') {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (board[i][j] == 'N') {
						rank = i; // used to make this easier to think about as a chess player, even though
						file = j; // i/j could be used without a separate variable name
						if (rank+2 < 8 && file+1 < 8 && Character.isUpperCase(board[rank+2][file+1]) == false) {
							Move legalKnightMove = new Move(new Square(rank, file), new Square(rank+2, file+1));
							knightMovesList.add(legalKnightMove);
						}
						if (rank+2 < 8 && file-1 > -1 && Character.isUpperCase(board[rank+2][file-1]) == false) {
							Move legalKnightMove = new Move(new Square(rank, file), new Square(rank+2, file-1));
							knightMovesList.add(legalKnightMove);
						}
						if (rank-2 > -1 && file+1 < 8 && Character.isUpperCase(board[rank-2][file+1]) == false) {
							Move legalKnightMove = new Move(new Square(rank, file), new Square(rank-2, file+1));
							knightMovesList.add(legalKnightMove);
						}
						if (rank-2 > -1 && file+1 < 8 && Character.isUpperCase(board[rank-2][file-1]) == false) {
							Move legalKnightMove = new Move(new Square(rank, file), new Square(rank-2, file+1));
							knightMovesList.add(legalKnightMove);
						}
						if (rank+1 < 8 && file+2 < 8 && Character.isUpperCase(board[rank+1][file+2]) == false) {
							Move legalKnightMove = new Move(new Square(rank, file), new Square(rank+1, file+2));
							knightMovesList.add(legalKnightMove);
						}
						if (rank-1 > -1 && file+2 < 8 && Character.isUpperCase(board[rank-1][file+2]) == false) {
							Move legalKnightMove = new Move(new Square(rank, file), new Square(rank-1, file+2));
							knightMovesList.add(legalKnightMove);
						}
						if (rank+1 < 8 && file-2 > -1 && Character.isUpperCase(board[rank+1][file-2]) == false) {
							Move legalKnightMove = new Move(new Square(rank, file), new Square(rank+1, file-2));
							knightMovesList.add(legalKnightMove);
						}
						if (rank-1 > -1 && file-2 > -1 && Character.isUpperCase(board[rank-1][file-2]) == false) {
							Move legalKnightMove = new Move(new Square(rank, file), new Square(rank-1, file-2));
							knightMovesList.add(legalKnightMove);
						}
					}
				}
			}
		} // end white
		
		if (color == 'B') {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (board[i][j] == 'n') {
						rank = i; // used to make this easier to think about as a chess player, even though
						file = j; // i/j could be used without a separate variable name
						if (rank+2 < 8 && file+1 < 8 && Character.isLowerCase(board[rank+2][file+1]) == false) {
							Move legalKnightMove = new Move(new Square(rank, file), new Square(rank+2, file+1));
							knightMovesList.add(legalKnightMove);
						}
						if (rank+2 < 8 && file-1 > -1 && Character.isLowerCase(board[rank+2][file-1]) == false) {
							Move legalKnightMove = new Move(new Square(rank, file), new Square(rank+2, file-1));
							knightMovesList.add(legalKnightMove);
						}
						if (rank-2 > -1 && file+1 < 8 && Character.isLowerCase(board[rank-2][file-1]) == false) {
							Move legalKnightMove = new Move(new Square(rank, file), new Square(rank-2, file+1));
							knightMovesList.add(legalKnightMove);
						}
						if (rank-2 > -1 && file+1 < 8 && Character.isLowerCase(board[rank-2][file+1]) == false) {
							Move legalKnightMove = new Move(new Square(rank, file), new Square(rank-2, file+1));
							knightMovesList.add(legalKnightMove);
						}
						if (rank+1 < 8 && file+2 < 8 && Character.isLowerCase(board[rank+1][file+2]) == false) {
							Move legalKnightMove = new Move(new Square(rank, file), new Square(rank+1, file+2));
							knightMovesList.add(legalKnightMove);
						}
						if (rank-1 > -1 && file+2 < 8 && Character.isLowerCase(board[rank-1][file+2]) == false) {
							Move legalKnightMove = new Move(new Square(rank, file), new Square(rank-1, file+2));
							knightMovesList.add(legalKnightMove);
						}
						if (rank+1 < 8 && file-2 > -1 && Character.isLowerCase(board[rank+1][file-2]) == false) {
							Move legalKnightMove = new Move(new Square(rank, file), new Square(rank+1, file-2));
							knightMovesList.add(legalKnightMove);
						}
						if (rank-1 > -1 && file-2 > -1 && Character.isLowerCase(board[rank-1][file-2]) == false) {
							Move legalKnightMove = new Move(new Square(rank, file), new Square(rank-1, file-2));
							knightMovesList.add(legalKnightMove);
						}
					}
				}
			}
		} // end black
		return knightMovesList;
	}

	public static ArrayList<Move> kingMoves(char[][] board, char color) {
		// Gives list of all squares the king can theoretically move to
		// Does not check if the move is legal (if it leaves the king in check)
		
		// Behavior: King can move 1 square in any direction, can only move onto empty squares
		
		ArrayList<Move> kingMovesList = new ArrayList<Move>();
	
		if (color == 'W') {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (board[i][j] == 'K') {
						if (i+1 < 8 && j+1 < 8 && Character.isUpperCase(board[i+1][j+1]) == false) {
							Move legalKingMove = new Move(new Square(i, j), new Square(i+1, j+1));
							kingMovesList.add(legalKingMove);
						}
						if (i-1 > -1 && j+1 < 8 && Character.isUpperCase(board[i-1][j+1]) == false) {
							Move legalKingMove = new Move(new Square(i, j), new Square(i-1, j+1));
							kingMovesList.add(legalKingMove);
						}
						if (i+1 < 8 && j-1 > -1 && Character.isUpperCase(board[i+1][j-1]) == false) {
							Move legalKingMove = new Move(new Square(i, j), new Square(i+1, j-1));
							kingMovesList.add(legalKingMove);
						}
						if (i-1 > -1 && j-1 > -1 && Character.isUpperCase(board[i-1][j-1]) == false) {
							Move legalKingMove = new Move(new Square(i, j), new Square(i-1, j-1));
							kingMovesList.add(legalKingMove);
						}
						if (j+1 < 8 && Character.isUpperCase(board[i][j+1]) == false) {
							Move legalKingMove = new Move(new Square(i, j), new Square(i, j+1));
							kingMovesList.add(legalKingMove);
						}
						if (j-1 > -1 && Character.isUpperCase(board[i][j-1]) == false) {
							Move legalKingMove = new Move(new Square(i, j), new Square(i, j-1));
							kingMovesList.add(legalKingMove);
						}
						if (i+1 < 8 && Character.isUpperCase(board[i+1][j]) == false) {
							Move legalKingMove = new Move(new Square(i, j), new Square(i+1, j));
							kingMovesList.add(legalKingMove);
						}
						if (i-1 > -1 && Character.isUpperCase(board[i-1][j]) == false) {
							Move legalKingMove = new Move(new Square(i, j), new Square(i-1, j));
							kingMovesList.add(legalKingMove);
						}
						
					}
				}
			}
		} // end white
		if (color == 'B') {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (board[i][j] == 'k') {
						if (i+1 < 8 && j+1 < 8 && Character.isLowerCase(board[i+1][j+1]) == false) {
							Move legalKingMove = new Move(new Square(i, j), new Square(i+1, j+1));
							kingMovesList.add(legalKingMove);
						}
						if (i-1 > -1 && j+1 < 8 && Character.isLowerCase(board[i-1][j+1]) == false) {
							Move legalKingMove = new Move(new Square(i, j), new Square(i-1, j+1));
							kingMovesList.add(legalKingMove);
						}
						if (i+1 < 8 && j-1 > -1 && Character.isLowerCase(board[i+1][j-1]) == false) {
							Move legalKingMove = new Move(new Square(i, j), new Square(i+1, j-1));
							kingMovesList.add(legalKingMove);
						}
						if (i-1 > -1 && j-1 > -1 && Character.isLowerCase(board[i-1][j-1]) == false) {
							Move legalKingMove = new Move(new Square(i, j), new Square(i-1, j-1));
							kingMovesList.add(legalKingMove);
						}
						if (j+1 < 8 && Character.isLowerCase(board[i][j+1]) == false) {
							Move legalKingMove = new Move(new Square(i, j), new Square(i, j+1));
							kingMovesList.add(legalKingMove);
						}
						if (j-1 > -1 && Character.isLowerCase(board[i][j-1]) == false) {
							Move legalKingMove = new Move(new Square(i, j), new Square(i, j-1));
							kingMovesList.add(legalKingMove);
						}
						if (i+1 < 8 && Character.isLowerCase(board[i+1][j]) == false) {
							Move legalKingMove = new Move(new Square(i, j), new Square(i+1, j));
							kingMovesList.add(legalKingMove);
						}
						if (i-1 > -1 && Character.isLowerCase(board[i-1][j]) == false) {
							Move legalKingMove = new Move(new Square(i, j), new Square(i-1, j));
							kingMovesList.add(legalKingMove);
						}
					}
				}
			}
		} // end black
		return kingMovesList;
	}
	
	
	public static void main(String[] args) {
		
		String fen = "r3r3/pppq1kp1/5n1p/3b4/3P4/3B4/PPPQ1PPP/R3K2R w KQ - 2 14";
		char[][] board = FEN.FENtoPosition(fen);
		ArrayList<Move> moves = LegalMoves.kingMoves(board, 'B');
		
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(moves.size() + " king moves added :)");
		
		
	}
}
