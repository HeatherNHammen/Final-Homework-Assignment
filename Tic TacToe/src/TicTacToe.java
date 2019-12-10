
public class TicTacToe {

	public static void main(String[] args) {
		Controller c = new Controller();  
		GameView gv = new GameView();   
		GameModel gm = new GameModel();   

		// Use aggregation to put the components together
		gv.buildGameView();
		gm.registerView(gv);
		c.setModel(gm);
		gv.setActionListener(c);

	}

}
