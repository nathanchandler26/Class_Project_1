import java.io.*;
import java.util.Scanner;
import java.util.*;
import static java.lang.Integer.parseInt;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<List<String>> teams = new ArrayList<>(); // Initialize list of teams
        ArrayList<String> myList = new ArrayList<>(); // Initialize list of names

        Scanner myObj = new Scanner(System.in); // Get the number of groups
        System.out.print("Enter Number of Groups: "); // Display for user input

        int numGroups = parseInt(myObj.nextLine()); // Read the users input
        System.out.println();


        // Parsing a CSV file into Scanner class constructor
        Scanner sc = new Scanner(new File("src/Project1_Names.csv"));
        sc.useDelimiter("\n");   // Sets the delimiter pattern

        while (sc.hasNext())  // Returns a boolean value
        {
            String name = sc.next();
            myList.add(name); // add names from input to our list
        }

        sc.close();  //closes the scanner

        Collections.shuffle(myList); // shuffles names

        int size = myList.size() / numGroups;
        int extra = myList.size() % numGroups;

        // initialize teams
        for (int i = 0; i < numGroups; i++) {
            teams.add(new ArrayList<String>(myList.subList(i * size, i * size + size)));
        }

        // add remaining names to teams
        for (int i = 0; i < extra; i++) {
            List<String> temp = teams.get(i);
            temp.add(myList.get(myList.size() - i - 1));
            teams.set(i, temp);
        }

        // print teams
        for (int i = 0; i < teams.size(); i++) {
            System.out.println("Team " + (i + 1) + ":" + teams.get(i));
        }
    }
}


