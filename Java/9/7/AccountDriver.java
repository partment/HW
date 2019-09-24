import java.util.Scanner;

public class AccountDriver {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in); // Defined a Scanner
		Account account = new Account(1122, 20000); // Construct Account with specified id and balance
		account.setAnnualInterestRate(0.045); // Set AnnualInterestRate to 4.5%
		System.out.println("Enter an amount you want to withdraw.");
		account.withdraw(input.nextDouble());
		System.out.println("Enter an amount you want to deposit.");
		account.deposit(input.nextDouble());
		System.out.println("Balance: "+account.getBalance());
		System.out.println("Monthly Interest: "+account.getMonthlyInterest());
		System.out.println("Date Created: "+account.getDate());
	}
}