package atm.flex;

public class Atm {

	private int balance;
	private String pin;

	public int getBalance() {
		return balance;
	}

	public Atm(int balance, String pin) {
		this.balance = balance;
		this.pin = pin;
	}

	// method overloading: methods of same name, doing different things
	public void deposit() {
		balance += 10;
	}

	public void deposit(int depositAmt) {
		balance += depositAmt;
	}

	public void withdraw(int withdrawAmount) {
		if (withdrawAmount > balance) {
			balance -= 0;
			System.out.println("Insufficient funds!");
		} else if (withdrawAmount % 10 != 0) {
			balance -= 0;
			System.out.println("Please enter multiples of 10");
		} else {
			balance -= withdrawAmount;
		}

	}

	public boolean accessAccount(String userEnteredPin) {
		if (pin.equals(userEnteredPin)) {
			return true;
		} else {
			return false;
		}
	}

	

}
