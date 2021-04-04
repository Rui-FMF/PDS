import java.util.ArrayList;

public interface JGaloInterface {
	public abstract char getActualPlayer();
	public abstract boolean setJogada(int lin, int col);
	public abstract boolean isFinished();
	public abstract char checkResult();
}

class JogoGalo implements JGaloInterface{
	private char[][] matrix;
	private char player;
	private char winner;
	private int jogadas;

	public JogoGalo(){
		this.matrix = new char[3][3];
		this.player = 'X';
		this.winner = ' ';
		this.jogadas = 0;
	}

	public char getActualPlayer(){
		return player;
	}

	public boolean setJogada(int lin, int col){
		matrix[lin-1][col-1] = player;
		if(player == 'X'){
			player = 'Y';
		} else{
			player = 'X';
		}
		jogadas++;
		return true;
	}

	public boolean isFinished(){
		ArrayList<String> lines = getLines();
		for(String l : lines){
			if(l.equals("XXX")){
				winner = 'X';
				return true;
			}
			if(l.equals("YYY")){
				winner = 'Y';
				return true;
			}
		}
		if(jogadas == 9){
			return true;
		}
		return false;
	}

	public char checkResult(){
		return winner;
	}

	private ArrayList<String> getLines(){
		ArrayList<String> lines = new ArrayList<String>();
		for (int i = 0; i < matrix.length; i++) {
			lines.add(String.valueOf(matrix[i]));
		}
		for (int row = 0; row < matrix.length; row++) {
			String v = "";
			for (int col = 0; col < matrix.length; col++) {
				v = v + matrix[col][row];
			}
			lines.add(v);
		}
		lines.add(""+matrix[0][0]+matrix[1][1]+matrix[2][2]);
		lines.add(""+matrix[0][2]+matrix[1][1]+matrix[2][0]);
		return lines;
	}
}