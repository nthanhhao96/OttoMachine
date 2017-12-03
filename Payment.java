package OttoMachine;

import java.util.Date;

public class Payment {
	private String toAccount;
	private double amount;
	private Date timestamp;
	private String memo;

	/**
	 Create a new transaction with a memo.
	 @param toAccount	the beneficiary account
	 @param memo		the memo for the transaction
	 @param amount	the dollar amount transacted
	 */
	public Payment(String toAccount, String memo, double amount) {
		this.toAccount = toAccount;
		this.memo = memo;
		this.amount = amount;
		this.timestamp = new Date();
	}
	
	/**
	 * Get the transaction amount.
	 * @return	the amount of the transaction
	 */
	public double getAmount() {
		return this.amount;
	}
	
	/**
	 * Get a string of transaction description
	 * @return the description string
	 */
	public String getDescription() {
		
		if (this.amount >= 0) {
			return String.format("%s%n%s : $%.02f %n%n%s", 
					this.toAccount, this.memo, this.amount, this.timestamp.toString());
		} else {
			return String.format("%s%n%s : $(%.02f) %n%n%s", 
					this.toAccount, this.memo, -this.amount, this.timestamp.toString());
		}
	}

}