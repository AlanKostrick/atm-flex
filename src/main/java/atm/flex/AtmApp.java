package atm.flex;

import java.util.Scanner;

public class AtmApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		Atm myAtm = new Atm(100, "1111"); 

		System.out.println("Enter your pin");
		String userEnteredPin = input.nextLine();

		while (myAtm.accessAccount(userEnteredPin) == false) {
			System.out.println("Enter your pin");
			userEnteredPin = input.nextLine();
		}

		System.out.println("Welcome to WCCI ATM");
		System.out.println("Please choose an option");
		System.out.println("Press 1 to check balance");
		System.out.println("Press 2 to do a quick deposit");
		System.out.println("Press 3 to do a custom deposit");
		System.out.println("Press 4 to withdraw");
		System.out.println("Press 5 to exit");
		String userChoice = input.nextLine();

		while (!userChoice.equals("5")) {
			if (userChoice.equals("1")) {
				System.out.println("Your balance is " + myAtm.getBalance());
			} else if (userChoice.equals("2")) {
				System.out.println("Doing a quick deposit of 10 bucks");
				myAtm.deposit();
			} else if (userChoice.equals("3")) {
				System.out.println("How much do you want to deposit?");
				int depositAmount = input.nextInt();
				input.nextLine(); // gives proper cursor spacing
				myAtm.deposit(depositAmount);
			} else if (userChoice.equals("4")) {
				System.out.println("How much do you want to withdraw?");
				int withdrawAmount = input.nextInt();
				input.nextLine(); // gives proper cursor spacing
				myAtm.withdraw(withdrawAmount);
			} else {
				System.out.println("I'm sorry I dont understand...");
			}

			System.out.println("Please choose another option");
			System.out.println("Press 1 to check balance");
			System.out.println("Press 2 to do a quick deposit");
			System.out.println("Press 3 to do a custom deposit");
			System.out.println("Press 4 to withdraw");
			System.out.println("Press 5 to exit");
			userChoice = input.nextLine();
		}

		System.out.println("Thanks for banking with us today!");
		input.close();
	}

}
