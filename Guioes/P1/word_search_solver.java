import java.util.ArrayList;

public class wss {

	public static void main(String[] args) {
		String file = null;
		boolean timing = false;
		//Flag treatment
		for (int i = 0; i < args.length; i++) {
			switch (args[i]) {
				case "-timing":
					timing = true;
					continue;
				default:
					file = args[i];
					continue;
			}
		}
		double startTime = System.currentTimeMillis();

		//Letter soup Object creation
		Sopa sopa = new Sopa(file);
		//Array of words to find
		ArrayList<String> words = sopa.getWords();
		//Array to fill with found words
		ArrayList<Word> found_words = new ArrayList<Word>();
		
		//Arrays that contain matrix lines of each direction
		ArrayList<String> horz = sopa.getHorizontals();
		ArrayList<String> vert = sopa.getVerticals();
		ArrayList<String> horz_r = Sopa.reverse(horz);
		ArrayList<String> vert_r = Sopa.reverse(vert);
		ArrayList<String> diag_ur = sopa.getDiagonal_UR();
		ArrayList<String> diag_ul = sopa.getDiagonal_UL();
		ArrayList<String> diag_dl = Sopa.reverse(diag_ur);
		ArrayList<String> diag_dr = Sopa.reverse(diag_ul);
		
		//main programm structure, loops through word list and for each one goes through each direction array
		//checking if the word is present in said array. When the word is found in a line of an array, it finds
		//the row and column of the first letter of the word in the matrix. The method varies for each direction.
		//Afterwards a Word object is created with the word info and added to found_words array.
		loop:
		for(String word : words) {
			for(String s : horz) {
				if(s.contains(word)) {
					int col = s.indexOf(word)+1;
					int row = horz.indexOf(s)+1;
					found_words.add(new Word(word,word.length(),row,col,"right"));
					if(!isPalindrome(word)) continue loop;	//if it isn't a palindrome, there is no need to keep searching
				}
			}
			for(String s : vert) {
				if(s.contains(word)) {
					int row = s.indexOf(word)+1;
					int col = vert.indexOf(s)+1;
					found_words.add(new Word(word,word.length(),row,col,"down"));
					if(!isPalindrome(word)) continue loop;
				}
			}
			for(String s : horz_r) {
				if(s.contains(word)) {
					int col = sopa.getSize()-(s.indexOf(word));
					int row = horz_r.indexOf(s)+1;
					found_words.add(new Word(word,word.length(),row,col,"left"));
					if(!isPalindrome(word)) continue loop;
				}
			}
			for(String s : vert_r) {
				if(s.contains(word)) {
					int row = sopa.getSize()-s.indexOf(word);
					int col = vert_r.indexOf(s)+1;
					found_words.add(new Word(word,word.length(),row,col,"up"));
					if(!isPalindrome(word)) continue loop;
				}
			}
			for(String s : diag_dr) {
				if(s.contains(word)) {
					int idx = diag_dr.indexOf(s)+1;	//index of diagonal in the array starting at 1
					int drow = idx>sopa.getSize() ? idx-sopa.getSize()+1 : 1;	//row of diagonal start
					int dcol = idx>sopa.getSize() ? 1 : sopa.getSize()-idx+1;	//column of diagonal start
					int row = drow+s.indexOf(word); int col = dcol+s.indexOf(word); //row and column of word
					found_words.add(new Word(word,word.length(),row,col,"downright"));
					if(!isPalindrome(word)) continue loop;
				}
			}
			for(String s : diag_dl) {
				if(s.contains(word)) {
					int idx = diag_dl.indexOf(s)+1;	//index of diagonal in the array starting at 1
					int drow = idx>sopa.getSize() ? idx-sopa.getSize()+1 : 1;	//row of diagonal start
					int dcol = idx>sopa.getSize() ? sopa.getSize() : idx;	//column of diagonal start
					int row = drow+s.indexOf(word); int col = dcol-s.indexOf(word); //row and column of word
					found_words.add(new Word(word,word.length(),row,col,"downleft"));
					if(!isPalindrome(word)) continue loop;
				}
			}
			for(String s : diag_ul) {
				if(s.contains(word)) {
					int idx = diag_ul.indexOf(s)+1;	//index of diagonal in the array starting at 1
					int drow = idx>sopa.getSize() ? sopa.getSize() : idx;	//row of diagonal start
					int dcol = idx>sopa.getSize() ? (2*sopa.getSize())-idx : sopa.getSize();	//column of diagonal start
					int row = drow-s.indexOf(word); int col = dcol-s.indexOf(word); //row and column of word
					found_words.add(new Word(word,word.length(),row,col,"upleft"));
					if(!isPalindrome(word)) continue loop;
				}
			}
			for(String s : diag_ur) {
				if(s.contains(word)) {
					int idx = diag_ur.indexOf(s)+1;	//index of diagonal in the array starting at 1
					int drow = idx>sopa.getSize() ? sopa.getSize() : idx;	//row of diagonal start
					int dcol = idx>sopa.getSize() ? idx-sopa.getSize()+1 : 1;	//column of diagonal start
					int row = drow-s.indexOf(word); int col = dcol+s.indexOf(word); //row and column of word
					found_words.add(new Word(word,word.length(),row,col,"upright"));
					if(!isPalindrome(word)) continue loop;
				}
			}
		}
		
		//Time check
		double endTime = System.currentTimeMillis();
		double duration = (endTime - startTime) / 1000;
		if (timing) {
			System.out.printf("Elapsed time (secs): %.3f\n", duration);
		}

		//Print results
		for (Word w : found_words) {
			System.out.println(w);
		}
		
		
	}

	public static boolean isPalindrome(String word){
		return word.equals(new StringBuilder(word).reverse().toString());
	}
}