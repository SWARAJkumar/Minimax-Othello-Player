package Code;


public class Two_d_array_indices{
	
	int i, j;
	public Two_d_array_indices(){
		
	}

	public Two_d_array_indices(int i, int j) {
		this.i = i;
		this.j = j;
	}

	@Override
	public String toString() {
		String retval = "Action: ( " + i + ", " + j + " )";
		return retval;
	}
}
