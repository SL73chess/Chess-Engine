public class Program {
    public static void main(String[] args) {
        Board board = new Board();
        board.FENtoPosition("8/5Q1p/3Nk3/p3P2p/8/7P/1PP2K2/4R3 b - - 1 35");
        board.printBoard();
        System.out.println(board.boardToFEN());
    }
}