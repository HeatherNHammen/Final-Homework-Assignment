
import java.util.Random;

public class GameModel {
	//actual play; 1 or 2 modes- different strategies for the computer
	//use .random generator
	//computer must select random tile, check if open
	//player can select tile, check if open

	private GameView gv;
	private int player;
	private int count;
	private char[][] gameBoard;
	private String message;

	//constructor
	public GameModel() {
		this.gameBoard = new char[3][3];
		this.count = 9;
		this.player = 1;
	}

	//initialize gameview
	public void registerView(GameView gv) {
		this.gv = gv;
	}

	//setters and getters
	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public char[][] getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(char[][] gameBoard) {
		this.gameBoard = gameBoard;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// update board/moves
	public void PlayMove(int x, int y) {

		if(getCount() > 0){
			// mark the board 
			if(player%2 != 0) { 
				//computer player
				///
				//set to random
				int[] arr;
				arr = getRandom();
				//gv.squares[arr[0]][arr[1]] = 'X';
				gameBoard[arr[0]][arr[1]] = 'X';
				gv.update(x, y, gameBoard[x][y]);
			}
			else {
				if(gameBoard[x][y] =='X' || gameBoard[x][y] =='O')
					return;
				else
					gameBoard[x][y] = 'O';
				gv.update(x, y, gameBoard[x][y]);
			}

			// reduce the count of moves left
			setCount(--count);
		}
	}

	private int[] getRandom() {
		//get random number(0-2) for both r and c
		Random random=new Random();
		int r=random.nextInt(3);
		int c=random.nextInt(3);
		int[] arr= new int[] {r,c};
		//check if valid move
		if(gameBoard[r][c] =='X' || gameBoard[r][c] =='O')
			getRandom();
		else
			return arr;
		return arr;//should not need this
	}

	// check if winner?

	// reset? do i want to

}
