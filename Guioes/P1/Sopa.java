import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Sopa {
	private int size;
	private char[][] matrix;
	private ArrayList<String> words;

	public Sopa(String file) {
		
		try {
			Scanner sc = new Scanner(new File(file));
			// read 1st string
			String line = sc.nextLine();
			// number of columns and rows (matrix NxN)
			this.size = line.length();
			if(size>50){
				System.err.println("Puzzle can't be bigger than 50x50");
				System.exit(1);
			}
			//create matrix
			this.matrix = new char[size][size];

			//fill matrix char by char
			for (int row = 0; row < size; row++) {
				for (int col = 0; col < size; col++) {
					char c = line.charAt(col);
					if(c < 'A' || c > 'Z'){
						System.err.println("Puzzle characters need to be uppercase letters");
						System.exit(1);
					}
					matrix[row][col] = c;
				}
				if(row<(size-1)) {
					line = sc.nextLine();	
				}
			}

			this.words = new ArrayList<String>();

			//get words to be found
			while (sc.hasNextLine()) {
				line = sc.nextLine();
				String[] list = line.split("\\W+");
				for (int i = 0; i < list.length; i++) {
					if((list[i].matches("^[a-zA-Z]*$")) && list[i].length()>=4){
					words.add(list[i].toUpperCase());
					}
				}
			}

			//check for redundant words
			for(int i = 0; i<words.size(); i++){
				for(int j = 0; j<words.size(); j++){
					if(i!=j && words.get(i).contains(words.get(j))){
						System.err.println("Redundant words: "+words.get(i)+", "+words.get(j));
						System.exit(1);
					}
				}
			}
			sc.close();

		} catch (Exception e) {
			System.err.format("Exception occurred trying to read '%s'.", file);
			e.printStackTrace();
			return;
		}
	}

	public int getSize() {
		return size;
	}

	public char[][] getMatrix() {
		return matrix;
	}

	public ArrayList<String> getWords() {
		return words;
	}
	
	public static ArrayList<String> reverse(ArrayList<String> arr) {
		ArrayList<String> reversed = new ArrayList<String>();
		for (String s : arr) {
			reversed.add(new StringBuilder(s).reverse().toString());
		}
		return reversed;
	}

	private char[][] reverseLines(){
		char[][] matrix_r = new char[size][size];

		for(int row = 0; row<size; row++){
			String row_r = new StringBuilder(String.valueOf(matrix[row])).reverse().toString();
			matrix_r[row] = row_r.toCharArray();
		}
		return matrix_r;
	}

	private ArrayList<String> getDiagonal(char[][] mat){
		//Default UP RIGHT diagonal
		ArrayList<String> diags = new ArrayList<String>();

        //get first half
        int row =0;
        int col;

        while(row<mat.length){
            col = 0;
			int rowTemp = row;
			String d = "";
            while(rowTemp>=0){
				d = d + mat[rowTemp][col];
                rowTemp--;
                col++;
			}
			diags.add(d);
            row++;
        }

        //get second half
        col = 1;

        while(col<mat.length){
            int colTemp = col;
			row = mat.length-1;
			String d = "";
            while(colTemp<=mat.length-1){
				d = d + mat[row][colTemp];
                row--;
                colTemp++;
            }
			diags.add(d);
            col++;
		}
		return diags;
    }

	public ArrayList<String> getHorizontals() {
		ArrayList<String> horizontais = new ArrayList<String>();
		for (int i = 0; i < matrix.length; i++) {
			horizontais.add(String.valueOf(matrix[i]));
		}
		return horizontais;
	}

	public ArrayList<String> getVerticals() {
		ArrayList<String> verticais = new ArrayList<String>();
		for (int row = 0; row < matrix.length; row++) {
			String v = "";
			for (int col = 0; col < matrix.length; col++) {
				v = v + matrix[col][row];
			}
			verticais.add(v);
		}
		return verticais;
	}

	public ArrayList<String> getDiagonal_UR() {
		ArrayList<String> diags = getDiagonal(matrix);
		return diags;
	}

	public ArrayList<String> getDiagonal_UL() {
		ArrayList<String> diags = getDiagonal(reverseLines());
		return diags;
	}
	
}
