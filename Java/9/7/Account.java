import java.util.Date;

public class Account {
    private int id = 0; // Initial id 0
    private double balance = 0; // Initial balance 0
    private double annualInterestRate = 0; // Initial annualInterestRate
    private Date dateCreated = new Date(); // Initial dateCreated with current time
    public Account () {} // No-args constructor
    public Account (int id, double balance) { // Constructor with specified id and balance
        this.id = id;
        this.balance = balance;
    }
    public int getId() { // Return Account.id
        return this.id;
    }
    public double getBalance() { // Return Account.balance
        return this.balance;
    }
    public double getAnnualInterestRate() { // Return Account.annualInterestRate
        return this.annualInterestRate;
    }
    public void setId(int id) { // A method to modify id
        this.id = id;
    }
    public void setBalance(double balance) { // A method to modify balance
        this.balance = balance;
    }
    public void setAnnualInterestRate(double annualInterestRate) { // A method to modify annualInterestRate
        this.annualInterestRate = annualInterestRate;
    }
    public Date getDate() { // Return Account.dateCreated
        return dateCreated;
    }
    public double getMonthlyInterest() { // Calculate Monthly Interest and Return it's result
        double monthlyInterestRate = getMonthlyInterestRate();
        return (monthlyInterestRate*this.balance);
    }
    public double getMonthlyInterestRate() { // Calculate Monthly Interest Rate and Return it's result
        return (this.annualInterestRate/12);
    }
    public void withdraw(double amount) { // A method to withdraw
        this.balance = this.balance - amount;
    }
    public void deposit(double amount) { // A method to deposit
        this.balance = this.balance + amount;
    }
}