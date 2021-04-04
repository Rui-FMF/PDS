import java.util.ArrayList;
import java.util.Scanner;

public class Client {
	
	static ArrayList<PC> pcList = new ArrayList<PC>();
	static PCBuilder wbuilder = new workingPCBuilder();
	static PCBuilder lbuilder = new lowCostPCBuilder();
	static PCBuilder gbuilder = new gammingPCBuilder();
	static PCDirector director = new PCDirector(wbuilder);

	public static void main(String[] args) {
		
		int op;
		Scanner sc = new Scanner(System.in);

		do {
		    System.out.println("--------Tech Building--------\n1) Build Computer\n2) See Computer List\n3) Exit");
		    op = sc.nextInt();

		    switch (op)
		    {
		        case 1:
		        	buildingMenu(sc);
		            break;
		        case 2: 
		            for(int i=0;i<pcList.size();i++){
		            	System.out.println("#"+(i+1)+" "+pcList.get(i));
		            }
		            break;
		        case 3: 
		            System.out.println("Thank you for using Tech Building!");
		            break;
		        default:
		            System.out.println("Invalid Operation");
		    }   
		} while (op != 3);
		
		sc.close();

	}
	
	public static void buildingMenu(Scanner sc) {
		int op;
		
		do {
			System.out.println("Choose the computer type you'd like to build:\n1) Low Cost PC\n2) Working PC\n3) Gamming PC");
		    op = sc.nextInt();

		    switch (op)
		    {
		        case 1:
		    		director.setBuilder(lbuilder);
		    		System.out.println("Low Cost PC successfully built!");
		            break;
		        case 2: 
		        	director.setBuilder(wbuilder);
		    		System.out.println("Working PC successfully built!");
		            break;
		        case 3: 
		        	director.setBuilder(gbuilder);
		    		System.out.println("Gamming PC successfully built!");
		            break;
		        default:
		            System.out.println("Invalid Operation");
		    }   
		} while (op>3 || op<1);
		
		director.makePC();
		pcList.add(director.getPC());
	}

}
