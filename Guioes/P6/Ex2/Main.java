import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main{

    public static void main(String[] args) {

        try {
            File file = new File("contacts.txt");
            file.createNewFile();
            FileWriter myWriter = new FileWriter(file.toString());
            myWriter.write("Lucas\t912333444\n");
            myWriter.write("Rui\t933222999\n");
            myWriter.write("Zezinho\t999999999\n");
            myWriter.write("Zezoca\t911111111\n");
            myWriter.close();
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

          TxtContactsStorage contacts = new TxtContactsStorage("contacts.txt");

          ContactsImplementation contactApi = new ContactsImplementation();
  
          contactApi.openAndLoad(contacts);
  
          Contact c1 = new Contact("Zezao", 929292929);
          contactApi.add(c1);
          contactApi.add(new Contact("Zezito", 955955955));


          contactApi.remove(c1);
          contactApi.remove(contactApi.getByName("Lucas"));

          System.out.println("Is Rui in Contacts?   "+contactApi.exist(contactApi.getByName("Rui")));
          System.out.println("Is Zezao in Contacts?   "+contactApi.exist(c1));

          contactApi.saveAndClose();

          try {
            File file2 = new File("contacts2.txt");
            file2.createNewFile();
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

          TxtContactsStorage contacts2 = new TxtContactsStorage("contacts2.txt");

          contactApi.saveAndClose(contacts2);

          ContactsImplementation contactApi2 = new ContactsImplementation();

          contactApi2.openAndLoad(contacts2);

    }
}