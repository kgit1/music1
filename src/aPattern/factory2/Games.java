package aPattern.factory2;

public class Games {

	public static void main(String[] args) {
		playGame(new CheckersFactory());
		System.out.println("=============");
		playGame(new ChessFactory());

	}

	public static void playGame(GameFactory factory){
		Game game = factory.getGame();
		while(game.move()){}
	}
}
