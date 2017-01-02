package aPattern.Factory2;

public class CheckersFactory implements GameFactory{

	@Override
	public Game getGame() {
		return new Checkers();
	}

}
