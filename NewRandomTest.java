// Jiayang Wu
// CTC ID: 202458768
// 4/15/2022
// This program extends the Random class and adds new random methods to the Random class,
// the new methods will include random integer between the lower int and higher int,
// random integer based on the digits the user inputted, random character method, and random special character.
import java.util.Scanner;

public class NewRandomTest {

    // Initialization
    static NewRandom nextRand = new NewRandom();
    static String[] method = new String [6];
    static String[] errorMsg = new String [2];
    static int howManyTest = 20;
    static Scanner input = new Scanner(System.in);


    // Main method to test the new random methods
    public static void main(String[] args) {
        loadMenu();
        loadErrorMsg();
        selectNtest();
    }
    // Sets the String arrays
    public static void loadMenu() {
        method[0] = "nextInt(int low, int high)";
        method[1] = "nextIntDigit(int digits)";
        method[2] = "nextChar()";
        method[3] = "nextChar(char from, char to)";
        method[4] = "nextChar(char from, int i)";
        method[5] = "nextSpecialChar()";
    }
    // Loads the error message
    public static void loadErrorMsg() {
        errorMsg[0] = "Input must be an int from 0 to 6";
        errorMsg[1] = "Must be digit";
    }
    // Prints the error message
    public static void printingErrorMsg(int errNumber) {
        System.out.println(errorMsg[errNumber]);

    }
     // Prints out method menu
    public static void selectNtest() {

        System.out.println("\nProject 1. New Random Class. (Spring Quarter 2022)");
        boolean run = false;
        while (run == false) {
            System.out.println("\nWhat method would you like to test?");
            for (int i=0; i< method.length; i++) {
                System.out.println(i + ". " + method[i]);
            }
            System.out.println(method.length + ": quit");

            int whichTest= input.nextInt();

            if (whichTest == method.length) {
                run = true;
                System.out.println("Bye!");
                break;
            }
            else if (whichTest < 0 || whichTest > 6) {
                System.out.println("Retype an integer from 0 to 6");
            }
            else {
                test(whichTest);
            }
        }
     }
    // Depending on the user's input for index, different method test will run
    public static void test(int index) {

        if (index == 0) {
            System.out.println("Input int value for low");
            int low = input.nextInt();
            System.out.println("Input int value for high");
            int high = input.nextInt();

            System.out.println("\nResult: nextInt(" + low + ", " + high +")");
            for (int i=0; i<howManyTest; i++) {
                int randNum = nextRand.nextInt(low, high);
                System.out.print(randNum + " ");
            }
            System.out.println();
        }
        else if (index == 1){
            System.out.println("Input int value for digits");
            int digits = input.nextInt();

            System.out.println("\nResult: nextIntDigit(" + digits +")");
            for (int i=0; i<howManyTest; i++) {
                int randNum = nextRand.nextIntDigit(digits);
                System.out.print(randNum + " ");
            }
            System.out.println();
        }
        else if (index == 2){

            System.out.println("\nResult: nextChar()");
            for (int i=0; i<howManyTest; i++) {
                char randNum = nextRand.nextChar();
                System.out.print(randNum + " ");
            }
            System.out.println();
        }
        else if (index == 3) {
            System.out.println("Enter the first character");
            char from = input.next().charAt(0);
            System.out.println("Enter the second character");
            char to = input.next().charAt(0);

            System.out.println("\nResult: nextChar(" + from + ", " + to + ")");
            for (int i = 0; i < howManyTest; i++) {
                char randChar = nextRand.nextChar(from, to);
                System.out.print(randChar + " ");
            }
            System.out.println();
        }
        else if (index == 4) {
            System.out.println("Enter a character");
            char from = input.next().charAt(0);
            System.out.println("Enter a integer");
            int num = input.nextInt();

            System.out.println("\nResult: nextChar(" + from + ", " + num + ")");
            for (int i = 0; i < howManyTest; i++) {
                char randChar = nextRand.nextChar(from, num);
                System.out.print(randChar + " ");
            }
            System.out.println();
        }
        else if (index == 5) {

            System.out.println("\nResult: nextSpecialChar()");
            for (int i = 0; i < howManyTest; i++) {
                char randSpecial = nextRand.nextSpecialChar();
                System.out.print(randSpecial + " ");
            }
            System.out.println();
        }
     }
}
