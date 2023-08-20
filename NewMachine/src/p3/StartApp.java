package p3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * PUT YOUR NAME HERE AND YOUR STUDENT NUMBER
 * 
 *
 */
public class StartApp {
	
	/**
	 * Entry point of program - no need to modify this method
	 * @param args
	 */
	public static void main(String[] args) {
		showMenu();	
	}
	
	//TODO modify readData method to populate List appropriately - method partially completed already
	//TODO add static methods to this class as required to achieve tasks outlined in menu
	//TODO modify showMenu method to add calls to new methods you write to accomplish the tasks outlined in the menu

	/**
	 * Launches menu system which in turn calls appropriate methods based on user choices
	 * Partially implemented already
	 * requires updating to add calls to other methods written to achieve the tasks described in tasks 3-10
	 */
	public static void showMenu() {
		List<TopTrumpCard> mainDeck = readData();

		System.out.println();
		Scanner scanner = new Scanner(System.in);
		int option;
		System.out.println("Hero Card Processing");
		do {
			System.out.println("1. (Re)read Data From File (use to restore removed card for example)");
			System.out.println("2. Play Demo Game with Current Deck");
			System.out.println("3. Display the number of Cards in the Current Deck");
			System.out.println("4. Display full details for all cards in the current Deck");
			System.out.println("5. Display summary details of the top 5 strongest Heroes in the Deck");
			System.out.println(
					"6. Display summary details of Villains in the Deck with an agility rating of 75 or more, sorted alphatically by name");
			System.out.println("7. Display the card name and bio of the card/cards with the longest bio in the Deck");
			System.out.println(
					"8. Find Swapsies: Identify and display summary details of any duplicate cards in the Deck");
			System.out.println("9. Remove any duplicate cards from the Deck.");
			System.out.println(
					"10. Sort the deck from highest to lowest determined by average of the 4 main stats. \n\tDisplay summary details of all cards and include the average as part of the summary.");
			System.out.println("11. Quit");
			System.out.println("Enter option ...");
			option = scanner.nextInt();
			System.out.println();
			switch (option) {

			case 1:
				mainDeck = readData();
				break;
			case 2:
				System.out.println("Option currently disabled...");
				/* TODO Uncomment method call to enable this option 
				 * (requires TopTrumpCard class to match expectations of Game Method to compile successfully)
				 * deliberately commented out initially to allow attempting other tasks
				 */
				//CardGame.playDemo(mainDeck);
				break;
			case 3:
				System.out.println("Number of cards in current deck = "+mainDeck.size());
				System.out.println();
				System.out.println();
				
				

				break;
			case 4:
				
				//details of all the cards in the current deck
				System.out.println("Details of all the cards in the current deck");
				
				FullDeets(mainDeck);

				break;
			case 5:
				System.out.println("Not yet implemented...");
				// TODO add required method call(s)
				break;
			case 6:
				System.out.println("Not yet implemented...");
				// TODO add required method call(s)
				break;
			case 7:
				System.out.println("Not yet implemented...");
				// TODO add required method call(s)
				break;
			case 8:
				System.out.println("Not yet implemented...");
				// TODO add required method call(s)
				break;
			case 9:
				System.out.println("Not yet implemented...");
				// TODO add required method call(s)
				break;
			case 10:
				System.out.println("Not yet implemented...");
				// TODO add required method call(s)
				break;
			case 11:
				System.out.println("Quitting");
				break;
			default:
				System.out.println("Try options again...");
			}
		} while (option != 11);
		scanner.close();
	}

	private static void FullDeets(List<TopTrumpCard> mainDeck) {

		for (TopTrumpCard wildcard :mainDeck);
		
		displayAll();
		
		
	}

	/**
	 * Reads in the data from the provided csv and returns a list of TopTrumpCard
	 * objects for further processing - requires updating for full functionality
	 */
	public static List<TopTrumpCard> readData() {

		List<TopTrumpCard> listFromFile = new ArrayList<TopTrumpCard>();

		File file = new File("toptrumpscards.csv"); // hard coded to specific file

		// try with resources - auto closes reader resources when finished/exception
		// occurs
		try (FileReader fr = new FileReader(file); BufferedReader reader = new BufferedReader(fr);) {

			try {
			String line = reader.readLine(); // discard header
			line = reader.readLine(); // read first line

			while (line != null) {

				String[] parts = line.split(",");
				String name = parts[0];
				String realname = parts[1];
				String imgname = parts[2];
				Category cat =Category.valueOf(parts[3].toUpperCase());
				int speed = Integer.parseInt(parts[4]);
				int strength = Integer.parseInt(parts[5]);
				int agility = Integer.parseInt(parts[6]);
				int intelligence = Integer.parseInt(parts[7]);
				String bio = parts[8];
				
				TopTrumpCard card = new TopTrumpCard(name, realname, imgname, cat, speed, strength, agility, intelligence, bio);
				
				listFromFile.add(card);
				
				// TODO instantiate TopTrumpCard object
				// TODO and add to list

				line = reader.readLine();// attempt to read next line and loop again
			}
			}catch (Exception ex) {
				System.out.println("bad data detected, skipping line");
				ex.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found error");
		} catch (IOException e) {
			System.out.println("IO Exception");
		} catch (Exception e) {
			System.out.println("Exception occured");
			System.out.println(listFromFile.size() + " lines read successfully");
			System.out.println(e.getMessage());
		}
		System.out.println(listFromFile.size() + " lines read successfully");
		return listFromFile;
	}

}
