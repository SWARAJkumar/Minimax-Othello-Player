package Code;
import java.util.ArrayList;
import java.util.Stack;

public class Minimax extends Environment{
	Stack best_move_stack = new Stack();
	Stack best_score_stack = new Stack();
	
	int score=0;
	// 0 is for black 1 is for white
	public int minimax(Othello game , int depth , boolean isMax, int alpha , int beta){
		Two_d_array_indices best_move = new Two_d_array_indices();
		
		if(depth==0 || is_game_complete(game))
			score=evaluate(game);
		else{
			ArrayList<Two_d_array_indices> move_list= get_pink(game);
			
			if(move_list.isEmpty())
				score=evaluate(game);
			else{
				if(isMax){
					System.out.println("max part");
					int best_score=-999;	
				
					
					for(Two_d_array_indices permutation:move_list){
						
						Othello next_game= new Othello(game, isMax);//blacks turn
						//System.out.println(permutation.toString());
						boolean flag=take_action(next_game, permutation);
						
						if(flag=false)
							System.out.println("something is wrong here");
						
						int minimax_score=minimax(next_game, depth-1,!isMax, alpha, beta);
						best_score= max(best_score, minimax_score);
						alpha= max(alpha, minimax_score);
						if(beta<=alpha)
							break;
						best_move= permutation;
					}
					score=best_score;
					best_score_stack.push(score);
					best_move_stack.push(best_move);
				}	
				else{
					System.out.println("min part");
					int worst_score=999;
				
					for(Two_d_array_indices permutation:move_list){
						
						Othello next_game= new Othello(game, isMax);
						//System.out.println(permutation.toString());
						boolean flag=take_action(next_game, permutation);
						
						if(flag==false)
							System.out.println("something is wrong here");
						
						int minimax_score=minimax(next_game, depth-1,!isMax, alpha, beta);
						worst_score= min(worst_score, minimax_score);
						beta=min(beta, worst_score);
						if(beta<=alpha)
								break;
						best_move=permutation;
					}
					score=worst_score;
					best_score_stack.push(score);
					best_move_stack.push(best_move);
				}
			}
		}
		return score;
	}
	
	public int max(int a, int b){
		
		if(a>b)
			return a;
		else return b;
	
	}
	
	public int min( int a , int b){
		if(a<b)
			return a;
		else
			return b;
	}
}
