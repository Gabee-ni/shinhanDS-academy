package omok;
import java.util.Scanner;
public class Omok {
	public static void main(String[] args) {
        Player user = new Player("사용자", "O");
        Player computer = new Player("컴퓨터", "X");
        Board board = new Board(19);
        play(board, user, computer);
	}
	
   private static void play(Board board, Player user, Player computer) {
        Scanner sc = new Scanner(System.in);
        Player[] players = {user, computer};
        while (board.run) {
        	
        	for (Player player : players) {
        		board.print();
        		System.out.print(player.name+"> ");
            	String position = sc.nextLine();
            	board.enterPosition(position, player);
            	
            	if (!board.run) break;
        	}
        }
        sc.close();
    }
}