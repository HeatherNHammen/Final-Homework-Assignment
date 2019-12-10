import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Adapter implements ActionListener{
	private Controller control;
	private GameView gameView;
	
	//constructor-references to the controller and view
	public Adapter(Controller control, GameView gameView) {
		this.control=control;
		this.gameView=gameView;
	}

	//doing the thing-button click
	@Override
	public void actionPerformed(ActionEvent e) {
		//get controller to do the thing based on which button is pressed
		//if(gameView.isReset(e)) {
		//	control.setRequest();
		//}
		//else {
			ArrayList<Integer> position = gameView.getPosition(e);
			control.setRequest(position);
		//}
		
	}

}
