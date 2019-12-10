import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Controller {
	
	private GameModel m;
	
	// model reference
	public void setModel(GameModel m) {
		this.m = m;
	}
	
	// update board
	public void setRequest(ArrayList<Integer> position) {
		m.PlayMove(position.get(0), position.get(1));
	}
	
	// reset?
	

}
