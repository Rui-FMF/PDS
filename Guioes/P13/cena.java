public class cena {
    public static void main(String[] args) {
        Board b = new Board(8,10);
        b.addBoat("Nau", 3);
        System.out.println();
        b.printBoard();

        int[][] matrix = new int[4][3];
        matrix[1][0]=1; matrix[0][1]=1; matrix[1][1]=1; matrix[2][1]=1; matrix[3][1]=1; matrix[1][2]=1;
        b.addComplexBoat("Jesus", matrix);
        System.out.println();
        b.printBoard();

        b.addBoat("Caravela", 1);
        b.addBoat("Caravela", 1);
        System.out.println();
        b.printBoard();
    }
}