import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Board {
    private int[][] board;
    private int max_col;
    private int max_row;
    private List<Boat> boats = new ArrayList<Boat>();
  	
  	public Board(int rows, int cols) {
    	board = new int[cols][rows];
      	max_col=cols;
      	max_row=rows;
    }
  
  	public void addBoat(String name, int size) {
        Boat new_boat = new Boat(name, size);
		main_loop: while (true) {
                    int initialCol = getRandNum(0, this.max_col - 1);
                    int initialRow = getRandNum(0, this.max_row - 1);

                    if (!validPos(initialCol, initialRow)) {
                        continue;
                    }

                    int row;
                    int col;
                    do {
                        row = getRandNum(0, 1);
                        col = getRandNum(0, 1);
                    } while (row==col);
                    System.out.println(name+" ROW: "+row+" COL: "+col);

                    for (int i = 1; i < size; i++) {
                        if (!validPos(initialCol + i * col, initialRow + i * row)) {
                            continue main_loop;
                        }
                    }

                    for (int i = 0; i < size; i++) {
                        new_boat.addPosition(new Position(initialCol + i * col, initialRow + i * row));
                        this.board[initialCol + i * col][initialRow + i * row] = 1;
                    }
                    break;
                }
        System.out.println("DONE "+name);
        this.boats.add(new_boat);
    }

    public void addComplexBoat(String name, int[][] matrix) {
        Boat new_boat = new Boat(name, matrix);
		main_loop: while (true) {
                    int initialCol = getRandNum(0, this.max_col - 1);
                    int initialRow = getRandNum(0, this.max_row - 1);

                    if (!validPos(initialCol, initialRow)) {
                        continue;
                    }


                    for (int col = 0; col < matrix.length; col++) {
                        for (int row = 0; row < matrix[0].length; row++) {
                            if(matrix[col][row]==1){
                                if (!validPos(initialCol + col, initialRow + row)) {
                                    continue main_loop;
                                }
                            }
                        }
                    }

                    for (int col = 0; col < matrix.length; col++) {
                        for (int row = 0; row < matrix[0].length; row++) {
                            if(matrix[col][row]==1){
                                new_boat.addPosition(new Position(initialCol + col, initialRow + row));
                                this.board[initialCol + col][initialRow + row] = 1;
                            }
                        }
                    }
                    break;
                }
        System.out.println("DONE "+name);
        this.boats.add(new_boat);
    }

    private static int getRandNum(int min, int max) {
        Random r = new Random();
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        return r.nextInt((max - min) + 1) + min;
    }

    private boolean validPos(int col, int row){
        for(int c=-1; c<=1; c++){
            for(int r=-1; r<=1; r++){
                try {
                    int pos = this.board[col+c][row+r];
                    if (pos==1) {
                        return false;
                    }
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard(){
        for(int row=0; row<this.max_row; row++){
            for(int col=0; col<this.max_col; col++){
                System.out.print(this.board[col][row] + " ");
            }
            System.out.print("\n");
        }
    }
    public void printBoats(){
        for(Boat b:boats){
            System.out.println(b.getName()+": "+b.getPos());
        }
    }
}

class Boat {
    private String name;
    private int size;
    private int[][] matrix;
    private List<Position> positions = new ArrayList<Position>();

    public Boat(String name, int size) {
        this.name = name;
        this.size = size;
    }
    public Boat(String name, int[][] matrix) {
        this.name = name;
        this.matrix = matrix;
    }

    public void addPosition(Position pos) {
        positions.add(pos);
    }

    public List<Position> getPos(){
        return this.positions;
    }

    public String getName(){
        return this.name;
    }
}

class Position {
    private String column;
    private String row;

    public Position(int col, int row) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase();
        this.column = String.valueOf(alphabet.charAt(col));
        this.row = String.valueOf(row);
    }

    public String toString() {
        return column + row;
    }
}

           
                  
