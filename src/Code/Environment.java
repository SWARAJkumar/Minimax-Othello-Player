package Code;


import java.awt.Color;
import java.util.HashMap;
import java.util.ArrayList;
import javax.swing.JButton;


public class Environment {

	// Data Members
	
	
	Integer[][] value ={{10,3,3,10}, 
						{3, 5, 5,3}, 
						{3, 5, 5,3},
						{10,3,3,10}};
	
	// Member Functions
	public int evaluation_function(Othello game,int player) {//0 for black, 1 for white
		
		int evaluation_value=0;
		JButton[][] buttons = game.get_buttons();

		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons.length; j++) {
				if (buttons[i][j].getBackground() == Color.BLACK && player==0) {
					evaluation_value+=value[i][j];
				}
				if (buttons[i][j].getBackground() == Color.WHITE && player==1) {
					evaluation_value+=value[i][j];
				}
			}
		}
		return evaluation_value;
	}

	public int evaluate(Othello game){
		
		int e_val=0;
		
		if(is_game_complete(game)){
			if(game.get_winner().equals("Black"))// if black wins +30 else -30
				e_val+=30;
			else
				e_val-=30;
		}
		
		
		e_val+=evaluation_function(game, 0)-evaluation_function(game, 1);//black - white 
		
		System.out.println("Evaluation occur : "+e_val);
		return e_val;
	}
	
	public boolean is_game_complete(Othello game) {
		return game.is_game_complete();
	}

	public ArrayList<Two_d_array_indices> get_pink(Othello game) {
		
		ArrayList<Two_d_array_indices> pink_list= new ArrayList<Two_d_array_indices>();
		
		JButton[][] buttons = game.get_buttons();
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(buttons[i][j].getBackground()==Color.PINK)
					pink_list.add(new Two_d_array_indices(i,j));
			}
		}
		return pink_list;
	}

	public boolean take_action(Othello game, Two_d_array_indices action_to_execute) {
		JButton[][] buttons = game.get_buttons();
		JButton button = buttons[action_to_execute.i][action_to_execute.j];

		if (button.getBackground() != Color.pink) {
			System.out.println(action_to_execute.toString()+" didn't work ");
			System.out.println(get_pink(game));
			return false;
		}
		button.doClick();
		return true;
	}
}
