package Game;

public class Main {

	public static void main(String[] args) {
		game(4);
		System.out.println();
		gameRec(4);
		
		
	}
	
	public static void game(int playersNum) {
		Game g = new Game(playersNum);
		int player = playersNum-1;
		while (!isWinner(g, player)) {
			player = g.playerNumNext(player);
			g.turn(player, g.rollDice());
		}
		System.out.println("the winner is player"+(player+1)+"!!!");
		System.out.println("Game statistics: ");
		System.out.println("doublsInGame: ");
		doublsInGame(g, playersNum);
		System.out.println();
		System.out.println("printIncidenceOfRolls: ");
		incidenceOfRolls(g, playersNum);
		
	}
	public static boolean isWinner(Game g, int player) {
		return (g.getPlyerPoints(player) >= 100);
	}
	public static void doublsInGame(Game g, int playersNum) {
		for (int i=0; i<playersNum; i++) {
			System.out.println("player"+(i+1)+": "+g.getPlyerDubleNum(i));
		}
	}
	public static void incidenceOfRolls(Game g, int playersNum) {
		for (int i=0; i<playersNum; i++) {
			g.printIncidenceOfRolls(i);
		}
	}

	public static void gameRec(int playersNum) {
		GameRec g = new GameRec(playersNum);
		int player = playersNum-1;
		while (!isWinner(g, player)) {
			player = g.playerNumNext(player);
			g.turn(player, g.rollDice());
		}
		System.out.println("the winner is player"+(player+1)+"!!!");
		System.out.println("Game statistics: ");
		System.out.println("doublsInGame: ");
		doublsInGame(g, playersNum, 0);
		System.out.println();
		System.out.println("printIncidenceOfRolls: ");
		incidenceOfRolls(g, playersNum, 0);
		
	}
	public static boolean isWinner(GameRec g, int player) {
		return (g.getPlyerPoints(player) >= 100);
	}
	public static void doublsInGame(GameRec g, int playersNum, int i) {
		if (i == playersNum) return;
		System.out.println("player"+(i+1)+": "+g.getPlyerDubleNum(i));
		doublsInGame(g, playersNum, i+1);
	}
	public static void incidenceOfRolls(GameRec g, int playersNum, int i) {
		if (i == playersNum) return;
		g.printIncidenceOfRolls(i);
		incidenceOfRolls(g, playersNum, i+1);
	}

}
