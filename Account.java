package OttoMachine;

public class Account {
	private static final int MAX_BALANCE = 9999999;
	private double balance;
	
	/**
	Constructs a bank account with a zero balance.
	*/
	public Account() {
		this.balance = 0;
	}

	/**
	Deposits money into the account.
	@param amount 	the amount of money to deposit
	*/
	public void deposit(double amount) {
		this.balance = this.balance + amount;
	}
		
	/**
	Withdraws money from the account.
	@param amount 	the amount of money to withdraw
	*/
	public void withdraw(double amount) {
		this.balance = this.balance - amount;

	}
		
	/**
	Gets the account balance.
	@return the account balance
	*/
	public double getBalance() {
		return this.balance;
	}

	
	/**
	Make sure that the maximum balance is 9.999.999
	 */
	public Boolean setBalance (double balance) {
		if (balance < 0 || balance > MAX_BALANCE){
			return false;
		} else {
			return true;
		}
	}
	
	/**
	Resets the machine to the initial state.
	 */
	public void reset() {
		this.balance = 0;
	}
}
