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
						
						// Diagonal going to index [8][8]
						int rankIndex = rank;
						int fileIndex = file;
						while (rankIndex < 7 && fileIndex < 7 && Character.isUpperCase(board[rankIndex + 1][fileIndex + 1]) == false) { // while the square is empty
							System.out.println("Execute branch 1");
							Move legalBishopMove = new Move(new Square(rank, file), new Square(rankIndex + 1, fileIndex + 1));
							bishopMovesList.add(legalBishopMove);
							rankIndex++;
							fileIndex++;
							if (board[rankIndex][fileIndex] != '-' && Character.isUpperCase(board[rankIndex][fileIndex]) == false) {
								break;
							}
						}
						
						// Diagonal going to index [0][0]
						rankIndex = rank;
						fileIndex = file;
						while (rankIndex > 0 && fileIndex > 0 && Character.isUpperCase(board[rankIndex - 1][fileIndex - 1]) == false) {
							System.out.println("Execute branch 2");
							Move legalBishopMove = new Move(new Square(rank, file), new Square(rankIndex - 1, fileIndex - 1));
							bishopMovesList.add(legalBishopMove);
							rankIndex--;
							fileIndex--;
							if (board[rankIndex][fileIndex] != '-' && Character.isUpperCase(board[rankIndex][fileIndex]) == false) {
								break;
							}
						}
						
						// Diagonal going to index [0][8]
						rankIndex = rank;
						fileIndex = file;
						while (rankIndex > 0 && fileIndex < 7 && Character.isUpperCase(board[rankIndex - 1][fileIndex + 1]) == false) {
							System.out.println("Execute branch 3");
							Move legalBishopMove = new Move(new Square(rank, file), new Square(rankIndex - 1, fileIndex + 1));
							bishopMovesList.add(legalBishopMove);
							rankIndex--;
							fileIndex++;
							if (board[rankIndex][fileIndex] != '-' && Character.isUpperCase(board[rankIndex][fileIndex]) == false) {
								break;
							}
						}
						
						// Diagonal going to index [8][0]
						rankIndex = rank;
						fileIndex = file;
						while (rankIndex > 0 && fileIndex < 7 && Character.isUpperCase(board[rankIndex + 1][fileIndex - 1]) == false) {
							System.out.println("Execute branch 4");
							Move legalBishopMove = new Move(new Square(rank, file), new Square(rankIndex + 1, fileIndex - 1));
							bishopMovesList.add(legalBishopMove);
							rankIndex++;
							fileIndex--;
							if (board[rankIndex][fileIndex] != '-' && Character.isUpperCase(board[rankIndex][fileIndex]) == false) {
								break;
							}
						}
					}
				}
			}
		}
		
		if (color == 'B') {
			for (int rank = 0; rank < 8; rank++) {
				for (int file = 0; file < 8; file++) {
					if (board[rank][file] == 'b') {
						/// If black's turn, and there's a black bishop on said square
						
						// Diagonal going to index [8][8]
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
						
						// Diagonal going to index [0][0]
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
						
						// Diagonal going to index [0][8]
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
						
						// Diagonal going to index [8][0]
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
	
	
	public int[] KnightMoves(char[][] board, char turn) {
		// Gives list of all squares the knight can theoretically move to
		// Does not check if the move is legal (if it leaves the king in check)\
		
		// Behavior: Knights can only move onto empty squares, but can jump over pieces
		// They move 2 squares in any direction up/down/left/right, and then 1 square to make an L
		
		int[] knightMovesList = {};
		
		
		
		return knightMovesList;
	}

	
	
	
	public int[] KingMoves(char[][] board, char turn) {
		// Gives list of all squares the king can theoretically move to
		// Does not check if the move is legal (if it leaves the king in check)
		
		// Behavior: King can move 1 square in any direction, can only move onto empty squares
		
		int[] kingMovesList = {};
	
	
	
		return kingMovesList;
	}
	
	
	public static void main(String[] args) {
		String fen = "r2qk2r/pppb1ppp/5n2/4b3/8/2P1B1N1/PP3PPP/R2QKB1R w KQkq - 0 11";
		char[][] board = FEN.FENtoPosition(fen);
		
		ArrayList<Move> moves = LegalMoves.bishopMoves(board, 'W');
		
		
//		for (int i = 0; i < 8; i++) {
//			for (int j = 0; j < 8; j++) {
//				System.out.print(board[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		for (int i = 0; i < moves.size(); i++) {
			System.out.print(moves.get(i).currSquare.rank + " ");
			System.out.print(moves.get(i).currSquare.file + " ");
			System.out.print(moves.get(i).newSquare.rank + " ");
			System.out.print(moves.get(i).newSquare.file + "\n");

		}
		System.out.println(moves.size());
		
		}
}
