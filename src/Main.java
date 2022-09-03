import java.io.*;
import java.util.Scanner;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Scanner myObj = new Scanner(System.in); // Get the number of groups
        System.out.println("Enter Number of Groups:"); // Display for user input

        String numGroups = myObj.nextLine(); // Read the users input

        ArrayList<String> myList = new ArrayList<>(); // Declare an array for the list of names

        // Parsing a CSV file into Scanner class constructor
        Scanner sc = new Scanner(new File("src/Project1_Names.csv"));
        sc.useDelimiter("\n");   // Sets the delimiter pattern

        while (sc.hasNext())  // Returns a boolean value
        {
            //System.out.print(sc.next());  // Find and returns the next complete token from this scanner
            String name = sc.next();
            //myList.add(sc.next());
            myList.add(name);
        }

        //sc.close();  //closes the scanner


        //System.out.println(myList.get(0));

        System.out.print(myList.size());

        //Collections.shuffle(myList);

        //System.out.println(myList);
    }
}


