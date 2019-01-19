package atm.flex;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class AtmTest {

	Atm underTest = new Atm(new BigDecimal("50.00"), "1111");

	@Test
	public void shouldHaveABalanceOf50() {
		BigDecimal expected = underTest.getBalance();
		assertThat(expected, is(new BigDecimal("50.00")));
	}

	@Test
	public void shouldHaveABalanceOf100() {
		Atm underTest = new Atm(new BigDecimal("100.00"), "1111");
		BigDecimal expected = underTest.getBalance();
		assertThat(expected, is(new BigDecimal("100.00")));
	}

	@Test
	public void defaultDepositShouldIncreaseBalanceFrom50To60() {
		underTest.deposit();
		BigDecimal expected = underTest.getBalance();
		assertThat(expected, is(new BigDecimal("60.00")));
	}

	@Test
	public void shouldIncreaseBalanceByUserRequestedAmount() {
		underTest.deposit(new BigDecimal("25.00"));
		BigDecimal expected = underTest.getBalance();
		assertThat(expected, is(new BigDecimal("75.00")));
	}

	@Test
	public void shouldDecreaseBalanceByUserRequestedAmount() {
		underTest.withdraw(new BigDecimal("10.00"));
		BigDecimal expected = underTest.getBalance();
		assertThat(expected, is(new BigDecimal("40.00")));
	}

	@Test
	public void shouldDecreaseBalanceBy0WhenUserRequestIsOver() {
		underTest.withdraw(new BigDecimal("100.00"));
		BigDecimal expected = underTest.getBalance();
		assertThat(expected, is(new BigDecimal("50.00")));
	}

	@Test
	public void shouldDecreaseBalanceBy0WhenUserRequestIsNotMultipleOf10() {
		underTest.withdraw(new BigDecimal("1.00"));
		BigDecimal expected = underTest.getBalance();
		assertThat(expected, is(new BigDecimal("50.00")));
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
