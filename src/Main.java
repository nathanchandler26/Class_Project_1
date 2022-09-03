import java.io.*;
import java.util.Scanner;
import java.util.*;
import static java.lang.Integer.parseInt;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Scanner myObj = new Scanner(System.in); // Get the number of groups
        System.out.println("Enter Number of Groups:"); // Display for user input

        int numGroups = parseInt(myObj.nextLine()); // Read the users input

        ArrayList<String> myList = new ArrayList<>(); // Declare an array for the list of names

        // Parsing a CSV file into Scanner class constructor
        Scanner sc = new Scanner(new File("src/Project1_Names.csv"));
        sc.useDelimiter("\n");   // Sets the delimiter pattern

        while (sc.hasNext())  // Returns a boolean value
        {
            String name = sc.next();
            myList.add(name);
        }

        Collections.shuffle(myList);
        System.out.print(myList);

        ArrayList<List<String>> teams = new ArrayList<>(); // Declare an array for the list of names


        int size = myList.size() / numGroups;
        int extra = myList.size() % numGroups;


        for (int i = 0; i < numGroups; i++) {
            teams.add(new ArrayList<String>(myList.subList(i * size, i * size + size)));
        }

        for (int i = 0; i < extra; i++) {
            List<String> temp = teams.get(i);
            temp.add(myList.get(myList.size() - i - 1));
            teams.set(i, temp);
        }

        System.out.println(teams);

        sc.close();  //closes the scanner
    }
}


