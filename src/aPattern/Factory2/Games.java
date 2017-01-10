package aPattern.Factory2;

//pattern Factory - creational pattern that uses factory methods to deal
//with problem of creating objects without having to specify exact class
//of the object that will be created
//we give some object as argument and method knows on his own what to 
//do when get object of that class
public class Games {

	public static void main(String[] args) {
		playGame(new CheckersFactory());
		System.out.println("=============");
		playGame(new ChessFactory());

	}

	public static void playGame(GameFactory factory) {
		Game game = factory.getGame();
		while (game.move()) {
		}
	}
}
