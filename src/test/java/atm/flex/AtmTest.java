package atm.flex;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AtmTest {
	
	Atm underTest = new Atm(50, "1111");
	
	@Test
	public void shouldHaveABalanceOf50() {
		int expected = underTest.getBalance();
		assertThat(expected, is(50));
	}
	
	@Test
	public void shouldHaveABalanceOf100() {
		Atm underTest = new Atm(100, "1111");
		int expected = underTest.getBalance();
		assertThat(expected, is(100));
	}
	
	@Test
	public void defaultDepositShouldIncreaseBalanceFrom50To60() {
		underTest.deposit();
		int expected = underTest.getBalance();
		assertThat(expected, is(60));
	}
	
	@Test
	public void shouldIncreaseBalanceByUserRequestedAmount() {
		underTest.deposit(25);
		int expected = underTest.getBalance();
		assertThat(expected, is(75));
	}
	
	@Test
	public void shouldDecreaseBalanceByUserRequestedAmount() {
		underTest.withdraw(10);
		int expected = underTest.getBalance();
		assertThat(expected, is(40));
	}
	
	@Test
	public void shouldDecreaseBalanceBy0WhenUserRequestIsOver() {
		underTest.withdraw(100);
		int expected = underTest.getBalance();
		assertThat(expected, is(50));
	}
	
	@Test
	public void shouldDecreaseBalanceBy0WhenUserRequestIsNotMultipleOf10() {
		underTest.withdraw(1);
		int expected = underTest.getBalance();
		assertThat(expected, is(50));
	}
	
	@Test
	public void shouldAllowUserAccessWithCorrectPin() {
		boolean expected = underTest.accessAccount("1111");
		assertThat(expected, is(true));
	}
	
	@Test
	public void shouldDenyUserAccessWithIncorrectPin() {
		boolean expected = underTest.accessAccount("2222");
		assertThat(expected, is(false));
	}
	

}
