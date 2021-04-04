/*
* Rui Filipe, LEI
* Lucas Sousa, LEI
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Street street = new Street();

    public static void main(String[] args) {
        String function; // ex: "Load filename" or "Add nome x1 x2"
        Scanner sc;
        int nArgs = args.length;
        boolean dynamic;
            try {
                if (nArgs == 1) {
                    File f = new File(args[nArgs - 1]);
                    sc = new Scanner(f);
                    dynamic = false;
                } else{
                    sc = new Scanner(System.in);
                    dynamic = true;
                }
                main_loop: while (true) {
                System.out.print("OP > ");
                function = sc.nextLine();
                String[] arguments = function.split("\\s+"); // ex: ["Add", "nome", "x1", "x2"]
                String command = arguments[0].toUpperCase();
                switch (command) {
                    case "LOAD":
                        System.out.println("LOADING..");
                        String fileName = arguments[1];
                        ArrayList<String> fileData = readFileData(fileName); // return array with PERSON info in each
                                                                             // index
                        ArrayList<Person> people = stringToPerson(fileData); // takes the previous STRING array and
                                                                             // transforms it to a PERSON array
                        for (Person person : people) {
                            street.addPerson(person);
                        }

                        break;
                    case "MAP":
                        System.out.println("MAPING..");
                        street.sort();
                        street.printStreet();
                        break;
                    case "ADD":
                        // ["Add", "nome", "x1", "x2"]s
                        try {
                            String name = arguments[1];
                            String x1 = arguments[2];
                            String x2 = arguments[3];

                            String standardFormatPerson = x1 + "-" + x2 + " " + name; // puts values in the
                                                                                      // standard
                                                                                      // format:
                                                                                      // x1-x1 name
                            Person newPerson = Person.Create(standardFormatPerson); // creates PERSON object
                            street.addPerson(newPerson); // adds person to street (and families)
                            System.out.println("ADDING "+name);
                        } catch (Exception e) {
                            System.out.println("Not enough arguments in command");
                        }
                        break;
                    case "REMOVE":
                    String nameToRemove;
                    try {
                        nameToRemove = arguments[1];
                    } catch (Exception e) {
                        if(dynamic){
                            System.out.println("Not enough arguments in command");
                            break;
                        }else{
                            nameToRemove = sc.nextLine();
                        }
                    }
                    System.out.println("REMOVING "+nameToRemove);
                    street.removePerson(nameToRemove);
                    break;
                    case "LIST":
                        System.out.println("LISTING..");
                        street.list();
                        break;
                    case "LOOKUP":
                        String personToFind;
                        try {
                            personToFind = arguments[1];
                        } catch (Exception e) {
                            if(dynamic){
                                System.out.println("Not enough arguments in command");
                                break;
                            }else{
                                personToFind = sc.nextLine();
                            }
                        }
                        System.out.println("LOOKING for "+personToFind);

                        street.lookup(personToFind);
                        break;
                    case "CLEAR":
                        System.out.println("CLEARING..");
                        street.reset();
                        break;
                    case "QUIT":
                        System.out.println("QUITING..");
                        System.exit(0);
                    default:
                        System.out.println("Invalid Operation");
                        continue main_loop;
                }
            }
        } catch (Exception e) {
                System.out.println("Error -- ");
        }   
    }

    /*
     * Function used in "LOAD" case
     */
    /*
     * This reads a file like "exemplo1.txt" and stores its lines in an array list
     * of strings
     */
    public static ArrayList<String> readFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        File file = new File(fileName);
        try {
            Scanner sc = new Scanner(file);
            String firstLine = sc.nextLine();

            if (firstLine.contains(">")) {
                // discard fist line and read the rest
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    fileData.add(line);
                }

            } else {
                fileData.add(firstLine);
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    fileData.add(line);
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Invalid File... " + fileName + " does not exist.");
        }
        return fileData;
    }

    /*
     * Function used in "LOAD" case
     */
    /*
     * This reads an array list from the function "readFileData" and 'converts' the
     * strings into actual PERSON objects. So, it returns an array list of PERSONs
     */
    public static ArrayList<Person> stringToPerson(ArrayList<String> fileData) {
        ArrayList<Person> people = new ArrayList<Person>();

        for (String personInfo : fileData) {
            Person p = Person.Create(personInfo);
            if (p == null) {
                System.out.println("PERSON_INFO: " + personInfo + " IS INVALID!!");
                continue;
            }
            people.add(p);
        }
        return people;
    }
}
