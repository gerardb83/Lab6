
import java.util.*;

public class Lab6 {
	static Scanner scnr = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to Grand Circus Casino!");
		
		int dieSides = getSides();
		rollDie(dieSides);
	}

	public static int getSides() {
		System.out.println("\nHow many sides should each die have?");
		
		while (!scnr.hasNextInt()) scnr.next();
		int userDieSides = scnr.nextInt();
		
		if ((userDieSides < 2)) {
			do {
				System.out.println("Must be a number greater than 1");
				while (!scnr.hasNextInt())
					scnr.next();
				userDieSides = scnr.nextInt();
			} while (userDieSides < 2);
		}
		return userDieSides;
	}

	public static void rollDie(int dieSides) {
		String rollAgain = "y";
		int rollCount = 0;
		do {
			rollCount++;
			
			int firstDie = generateRandomDieRoll(dieSides);
			int secondDie = generateRandomDieRoll(dieSides);

			System.out.println("Roll " + rollCount + ":\n" + firstDie + "\n" + secondDie);
			System.out.println(crapsLingo(firstDie, secondDie));

			System.out.println("Roll again? (y/n): ");
			rollAgain = scnr.next();
		} while (rollAgain.equalsIgnoreCase("y"));

		System.out.println("Come back soon!");
	}

	private static int generateRandomDieRoll(int dieType) {// no real reason for private here...
		Random rand = new Random();
		return rand.nextInt((dieType - 1) + 1) + 1;
	}

	private static String crapsLingo(int firstDie, int secondDie) {// or here, just exploring
		if (firstDie == 1 && secondDie == 1) {
			return "Craps! Snake eyes!";
		} else if (firstDie == 12 && secondDie == 12) {
			return "Craps! Boxcars";
		} else if ((firstDie == 2 && secondDie == 1) || (firstDie == 1 && secondDie == 2)) {
			return "Craps.";
		} else if ((firstDie == 1 && secondDie == 3) || (firstDie == 3 && secondDie == 1)) {
			return "Easy four.";
		} else {
			return "";
		}
	}
}
