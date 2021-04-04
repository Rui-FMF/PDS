import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Client {

	static DatabaseInterface db = new DatabaseProxy();

	public static void main(String[] args) {
		
		int op;
		Scanner sc = new Scanner(System.in);

		do {
		    System.out.println("--------Image Database--------\n1) Get Random Image\n2) Get Image\n3) Exit");
		    op = sc.nextInt();

		    switch (op)
		    {
		        case 1:
		        	Image rimg = db.getRandomImage();
					try {
			        	BufferedImage rimag=ImageIO.read(new ByteArrayInputStream(rimg.getBytes()));
						ImageIO.write(rimag, "png", new File("./localStorage/"+rimg.getName()));
					} catch (IOException e) {
						e.printStackTrace();
					}
		            break;
		        case 2:
		        	int id;
		        	do {
			        	System.out.println("Insert the id of the image you want (1-4)");
			        	id = sc.nextInt();
		        	} while(id<1 || id>4);
		        	Image img = db.getImage(id);
		        	try {
			        	BufferedImage imag=ImageIO.read(new ByteArrayInputStream(img.getBytes()));
						ImageIO.write(imag, "png", new File("./localStorage/"+img.getName()));
					} catch (IOException e) {
						e.printStackTrace();
					}
		            break;
		        case 3: 
		            System.out.println("Thank you for using our Image Database!");
		            break;
		        default:
		            System.out.println("Invalid Operation");
		    }   
		} while (op != 3);
		
		sc.close();

	}

}
