package atm.flex;

import java.math.BigDecimal;

public class Atm {

	private BigDecimal balance;
	private String pin;

	public BigDecimal getBalance() {
		return balance;
	}

	public Atm(BigDecimal balance, String pin) {
		this.balance = balance;
		this.pin = pin;
	}

	// method overloading: methods of same name, doing different things
	public void deposit() {
		balance = balance.add(new BigDecimal("10.00"));
	}

	public void deposit(BigDecimal depositAmt) {
		balance = balance.add(depositAmt);
	}

	public void withdraw(BigDecimal withdrawAmount) {
		if (withdrawAmount.compareTo(balance) > 0) {
			// balance -= 0;
			System.out.println("Insufficient funds!");
		} else if (withdrawAmount.remainder(new BigDecimal("10.00")).compareTo(BigDecimal.ZERO) > 0) {
			// balance -= 0;
			System.out.println("Please enter multiples of 10");
		} else {
			balance = balance.subtract(withdrawAmount);
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
