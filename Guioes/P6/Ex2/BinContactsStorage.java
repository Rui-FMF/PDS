import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BinContactsStorage implements ContactsStorageInterface {
    private String fname;

    public BinContactsStorage(String fname) {
        this.fname = fname;
    }

    public List<Contact> loadContacts() {
        List<Contact> contact_list = new ArrayList<>();

        try {
            Path fpath = Paths.get(this.fname);
            BufferedReader reader = new BufferedReader(new FileReader(fpath.toString()));

            String line = reader.readLine();

            while (line != null) {

                String[] contact_info = line.split("\t");
                Contact c = new Contact(contact_info[0], Integer.parseInt(contact_info[1]));
                contact_list.add(c);
                line = reader.readLine();
            }

            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contact_list;
    }

    public boolean saveContacts(List<Contact> list) {

        try {
            Path fpath = Paths.get(this.fname);
            BufferedWriter bwriter = new BufferedWriter(new FileWriter(fpath.toString()));

            for (Contact c : list) {
                bwriter.write(c.toString() + "\n");
            }
            bwriter.close();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;

    };
}