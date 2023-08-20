package Plotto;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Lotto checker ! Intro of arrays rather than  6 ints for the user's options and 6 winning
 * balls. Cuts down on previous repetitive code of several IF - ELSE to populate winning numbers and user selections etc..  
 * Sort included on the arrays of numbers too. 
 * Then displays the output of both sets to screen and checks for winning
 * numbers using nested FOR loops. Includes a count of the number of
 * winning numbers. 
 * The numbers of the lotto balls are randomly generated. User input for their selection (6 balls).
 * Note use of CONSTANTS that allow the game parameters to easily change ie MAX_NUMBER_RANGE and MAX_OF_BALLS_IN_DRAW
 * 
 * @author Aidan McG
 *
 */
public class LottoChecker {

    // declaring a constant to represent the max range value of the lotto  
    public static final int MAX_NUMBER_RANGE =38;
    
    public static final int MAX_OF_BALLS_IN_DRAW =6;
    
    /**
     * Main start point for program.
     * @param args
     */
    public static void main(String[] args) {

        int winningBalls;
    
        // now using arrays
        int[] userSelections = new int[MAX_OF_BALLS_IN_DRAW];
        int[] winners = new int[MAX_OF_BALLS_IN_DRAW];
        
        
        // initialising to zero
        winningBalls = 0;
        
        // get the Random class.
        Random random = new Random();
        
        // scanner for getting user input
        Scanner scanner = new Scanner(System.in);
        
        // randomising the winning numbers - generate a number 0 - 38(MAX) - but we don't want 0 and we do want to potentially include 38 so adding 1 
        // note now with a loop (array enabled)
        for (int loop=0; loop< winners.length; loop++) {
            winners[loop] = random.nextInt(MAX_NUMBER_RANGE) + 1;
        }
        
        // going to sort these - better for user  
        Arrays.sort(winners);
        
        System.out.println("Lotto checker ......");
        
        // user options - getting user selections
        int selected =0;
        System.out.println("Select your six numbers (1-"+MAX_NUMBER_RANGE + ")");
        do {
            System.out.println("Enter selection "+(selected+1) +" : "); // note (selected+1) will output current selection opportunity but not update the actual value
            userSelections[selected] = scanner.nextInt();
            selected++;
        } while(selected<MAX_OF_BALLS_IN_DRAW);
        
        Arrays.sort(userSelections);
    
        // got all the user's selections - print out to screen
        System.out.println("Your selection ...");

        for (int userSelection : userSelections) {
            System.out.print(userSelection +" ");
        }
        
        System.out.println();

        // print out the winning numbers
        System.out.println("Winning balls");
        for (int winner : winners) {
            System.out.print(winner +" ");
        }
        
        System.out.println();

        System.out.println("\nChecking for winners ...");

        // checking for winning matches - using a nested for
        // nested for loop - goes through each winning ball and then checks if the user had selected that ball
        for (int userSelection : userSelections) {    
            for (int winner : winners) {
                if (userSelection==winner) {
                    // winner winner chicken dinner!
                    winningBalls++;
                    System.out.println("A winner  : "+userSelection);
                    break;
                }
            }
        }    
            
        // adding output of overall matched (winning) balls
        System.out.println("\nOverall result");
        System.out.println("Number of winning balls : " + winningBalls);
        // using switch here to filter output responses based on the number of winning
        // balls
        switch (winningBalls) {
        case 0:
            System.out.println("No luck at all!");
            break;
        case 1:
        case 2:
            System.out.println("Not bad");
            break;
        case 3:
            System.out.println("Good, maybe a trip to the shops");
            break;
        case 4:
            System.out.println("Don't give up your job but maybe a holiday");
        case 5:
            System.out.println("Pay your uni fees ");
            break;
        case 6:
            System.out.println("Tell the boss where to go ....");
            break;
        default:
            System.out.println("Error");
        }
        
        // closing the scanner - potential resource leak!
        scanner.close();
    }
}