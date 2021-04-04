import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class wsg {
    public static void main(String[] args) {
        String file = null;
        int n = 0;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-i":
                    file = args[i + 1];
                    continue;
                case "-s":
                    n = Integer.parseInt(args[i + 1]);
                    continue;
            }
        }

        try {

            Scanner sc = new Scanner(new File(file));

            // ir buscar palavras ao ficheiro
            ArrayList<String> words = new ArrayList<String>();
            while (sc.hasNextLine()) {

                String line = sc.nextLine();
                String[] list = line.split("\\W+");
                for (int i = 0; i < list.length; i++) {
                    // dado que as palvras têm de ter no mínimo 4 caracteres...
                    if (list[i].length() >= 4) {
                        // assim as palavras que adicionarmos vao estar em upper case
                        words.add(list[i].toUpperCase());
                    }
                }

            }
            for(int i = 0; i<words.size(); i++){
				for(int j = 0; j<words.size(); j++){
					if(i!=j && words.get(i).contains(words.get(j))){
						System.err.println("Redundant words: "+words.get(i)+", "+words.get(j));
						System.exit(1);
					}
				}
			}
            System.out.println("Palavras a inserir: " + words);

            // inicializar o puzzle com o tamanho predefinido
            // vai ser sempre um quadrado porque é usado o mesmo valor (n) para as linhas e
            // colunas, ou seja,
            // é sempre n*n
            char[][] puzzle = new char[n][n];

            // para cada palavra do ficheiro
            for (String word : words) {
                // System.out.println("A inserir " + word);
                main_loop: while (true) {

                    // escolher posiçao atual
                    int initialCol = getRandNum(0, n - 1);
                    int initialRow = getRandNum(0, n - 1);

                    // volta ao inicio, para escolher outra posição, se a posiçao atual
                    // já lá tiver alguma letra
                    if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains(String.valueOf(puzzle[initialRow][initialCol]))) {
                        // System.out.println("Primeira posição invalida");
                        continue;
                    }

                    // row e col vão decidir para que direção a palavra vai ser orientada
                    // while row e col == 0 porque se forem os dois zero não saem da mesma posição
                    // pelo menos um nao pode ser zero

                    int row;
                    int col;
                    do {
                        row = getRandNum(-1, 1);
                        col = getRandNum(-1, 1);
                    } while (row == 0 && col == 0);

                    for (int i = 1; i <= word.length(); i++) {
                        try {
                            char pos = puzzle[initialRow + i * row][initialCol + i * col];
                            // caso haja char na direção dá jump para o inicio e tenta outra vez
                            if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains(String.valueOf(pos))) {
                                // System.out.println("Char encontrado na direção da palavra");
                                continue main_loop;
                            }
                        } catch (Exception e) {
                            // já "jump" para o início se não tiver espaço na direção da palavra
                            // System.out.println("Nao tem espaço para pôr a palavra");
                            continue main_loop;
                        }
                    }

                    for (int i = 0; i < word.length(); i++) {
                        puzzle[initialRow + i * row][initialCol + i * col] = word.charAt(i);
                        // System.out.println("> " + word.charAt(i));
                    }
                    // System.out.println();
                    // para poder passar à proxima palavra
                    break;

                }
            }

            for (int row = 0; row < puzzle.length; row++) {
                for (int col = 0; col < puzzle.length; col++) {
                    if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains(String.valueOf(puzzle[row][col]))) {
                        continue;
                    }
                    // chars aleatorios sao geradas em maiuscula
                    puzzle[row][col] = getRandChar();
                }
            }

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    System.out.print(puzzle[row][col] + " ");
                }
                System.out.println();
            }

        } catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", file);
            e.printStackTrace();
            return;
        }
    }

    private static int getRandNum(int min, int max) {
        Random r = new Random();
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        return r.nextInt((max - min) + 1) + min;
    }

    private static char getRandChar() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random r = new Random();
        return alphabet.charAt(r.nextInt(alphabet.length()));
    }
}