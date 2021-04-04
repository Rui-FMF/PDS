import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class ImageDatabase implements DatabaseInterface{
	
	private HashMap<Integer, Image> imgList = new HashMap<Integer, Image>();

	public ImageDatabase() {
		this.imgList.put(1, new Image("chameleon.png"));
		this.imgList.put(2, new Image("mushroom.png"));
		this.imgList.put(3, new Image("fox.png"));
		this.imgList.put(4, new Image("heart.png"));
	}

	@Override
	public Image getRandomImage() {
		int r = random(1,4);
		System.out.println("Loading Image information....");
		Latency();
		
		try {
			ByteArrayOutputStream baos=new ByteArrayOutputStream(1000);
			BufferedImage img;
			img = ImageIO.read(new File("./imgDatabase/"+imgList.get(r).getName()));
			ImageIO.write(img, "png", baos);
			baos.flush();
			String base64String=new String(Base64.getEncoder().encode(baos.toByteArray()));
			baos.close();
	 
			byte[] bytearray = Base64.getDecoder().decode(base64String);
			imgList.get(r).setBytes(bytearray);
			return imgList.get(r);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Image getImage(int id) {
		System.out.println("Loading Image information....");
		Latency();
		try {
			ByteArrayOutputStream baos=new ByteArrayOutputStream(1000);
			BufferedImage img;
			img = ImageIO.read(new File("./imgDatabase/"+imgList.get(id).getName()));
			ImageIO.write(img, "png", baos);
			baos.flush();
			String base64String=new String(Base64.getEncoder().encode(baos.toByteArray()));
			baos.close();
	 
			byte[] bytearray = Base64.getDecoder().decode(base64String);
			imgList.get(id).setBytes(bytearray);
			return imgList.get(id);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void Latency() {
        int randomLatency = random(5, 10);
        for (int i = 0; i < randomLatency; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
	
	private int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

}
