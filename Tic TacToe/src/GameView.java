import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GameView extends JPanel {

	//view members
	private Adapter adapter;
	public JButton[][] squares;

	//constructor
	public GameView() {
		//set gridLayout and background color
		setLayout(new GridLayout(3,3, 5,5));
		setBackground(Color.BLUE);
		//instantiate squares
		squares=new JButton[3][3];
		//assign tiles an id num?

		// x,o, or null?

		//add buttons to array, place x in each button as test
		//nested for loop
		for(int r=0;r<squares.length; r++) {
			for(int c=0; c<squares[r].length; c++) {
				JButton button= new JButton();
				button.setFont(new Font("Arial",Font.BOLD, 24));
				button.setBorderPainted(true);
				squares[r][c]=button;
				this.add(squares[r][c]);
			}
		}

	}
	public void buildGameView() {
		// create a frame, set title and dimensions
		//make it visible
		JFrame frame= new JFrame();
		frame.setTitle("Tic Tac Toe");
		frame.setSize(500,550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//instantiate a gameView OBJECT and add it to frame
		GameView gv= new GameView();
		frame.add(gv);
		frame.setVisible(true);
	}
	public void setActionListener(Controller control) {
		// adapter needs reference of controller and view class
		this.adapter = new Adapter(control,this);
		for(int r=0; r<3; r++) {
			for(int c=0; c<3; c++) {
				squares[r][c].addActionListener(adapter);
			}
		}
		// reset.addActionListener(adapter);
	}
	public ArrayList<Integer> getPosition(ActionEvent e) {
		ArrayList<Integer> position = new ArrayList<Integer>();
		for(int row = 0; row<3 ;row++) {
			for(int column = 0; column<3 ;column++) {
				if(e.getSource() == squares[row][column]) {
					position.add(row);
					position.add(column);
				}
			}
		}
		return position;
	}
	public void update(int r, int c, char sym) {
		squares[r][c].setText(Character.toString(sym));
		squares[r][c].setEnabled(true);

	}

}

