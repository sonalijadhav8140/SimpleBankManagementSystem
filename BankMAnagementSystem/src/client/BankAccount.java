package client;

import exceptions.insufficientBalanceException;
import exceptions.negativeAmmountException;

public class BankAccount {


		public int accNo;
		public String name;
		public double balance;
		public String accType;

		
		public BankAccount(int accNo, String name, double balance, String accType) {

			this.accNo = accNo;
			this.name = name;
			this.balance = balance;
			this.accType = accType;
		}

		public void deposit(double ammount) throws negativeAmmountException {

			if (ammount < 0) {
				throw new negativeAmmountException("Negative Ammount Cannot Deposit NUmber..");
			} else {

				balance = balance + ammount;
				System.out.println(ammount + " Credited to your account " + accNo + " Successfully!!!");
				System.out.println(" Your Current balance is " + balance);

			}

		}

		public void withdraw(double ammount1) throws insufficientBalanceException {
			if (ammount1 > balance) {
				throw new insufficientBalanceException("Insufficient Balance...");
			} else {
				balance = balance - ammount1;
				System.out.println(ammount1 + " debited from Your bank account ");

			}
		}

		public void checkbalance() {
			System.out.println("Your Bank Balance is " + balance);
		}

	}


