package Code;
public class Control {

	public static void main(String[] args) {
		Minimax m = new Minimax();
		Othello game=new Othello();
		Environment e = new Environment();
		while(!game.is_game_complete()){
			System.out.println(m.minimax(game, 2, true, -9999,9999));
			e.take_action(game, (Two_d_array_indices)(m.best_move_stack.pop()));
			try{Thread.sleep(5000);}catch(Exception exc){exc.printStackTrace();}

		}
	}
}
