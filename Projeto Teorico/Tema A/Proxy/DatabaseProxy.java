import java.util.HashMap;

public class DatabaseProxy implements DatabaseInterface {
	private ImageDatabase db;
	private HashMap<Integer, Image> imgList = new HashMap<Integer, Image>();
	
	public DatabaseProxy() {
		this.db = new ImageDatabase();
	}

	@Override
	public Image getRandomImage() {
		int r = random(1,4);
		if(imgList.containsKey(r)) {
			System.out.println("Getting Image from Local Cache....");
			return imgList.get(r);
		}else {
			Image img = db.getImage(r);
			imgList.put(r, img);
			return img;
		}
	}
	@Override
	public Image getImage(int id) {
		if(imgList.containsKey(id)) {
			System.out.println("Getting Image from Local Cache....");
			return imgList.get(id);
		}else {
			Image img = db.getImage(id); 
			imgList.put(id, img);
			return img;
		}
	}
	
	private int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

}
