package controller;

import java.util.Scanner;

import client.BankAccount;
import exceptions.duplicateAccountNumberException;
import exceptions.insufficientBalanceException;
import exceptions.invalidAccountNumberException;
import exceptions.negativeAccountNumberException;
import exceptions.negativeAmmountException;

public class bankmain {
   

	public static void main(String[] args) throws duplicateAccountNumberException, negativeAmmountException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		BankAccount[] bank = new BankAccount[10];
		int index = 0;

		bank[index++] = new BankAccount(101, "Sneha", 10000.0, "Savings");
		bank[index++] = new BankAccount(102, "Dnyanu", 20000.0, "Savings");
		bank[index++] = new BankAccount(103, "Divya", 15000.0, "Current");

		while (true) {
			System.out.println("*******WelCome to Lootera Bank*******");
			System.out.println("\t 1]create new account\n" + "\t 2]display all accounts\n"
					+ "\t 3]Search account by account Number\n" + "\t 4]Deposit Ammount\n" + "\t 5]Withdraw Ammount\n"
					+ "\t 6]Check Balance\n" + "\t 7]Exit\n");
			System.out.println("_____________________________________________");

			System.out.println("Enter Your Choice");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				System.out.println("Enter Acc NO");
				int accNO = sc.nextInt();
				boolean isDuplicate = false;
				boolean isnegative = false;

				try {
					for (BankAccount obj : bank) {
						if (obj != null) {
							if (accNO == obj.accNo) {
								isDuplicate = true;
								break;
							}
						}

					}

					if (isDuplicate) {
						throw new duplicateAccountNumberException("Duplicate acc number..");

					}

					if (accNO <= 0) {
						isnegative = true;
					}

					if (isnegative) {
						throw new negativeAccountNumberException("Account Number Cannot Negative");
					}

					if (index >= bank.length) {
						System.out.println("Cannot create account..");
					}
				}

				catch (negativeAccountNumberException e) {
					e.printStackTrace();
					break;
				} catch (duplicateAccountNumberException e) {
					e.printStackTrace();
					break;
				}

				if (!isDuplicate || !isnegative) {
					System.out.println("Enter Account Holder Name:");
					String name = sc.next();

					System.out.println("Enter Account Balance:");
					double Balance = sc.nextDouble();

					System.out.println("Enter Account type");
					String acctype = sc.next();

					bank[index++] = new BankAccount(accNO, name, Balance, acctype);
					System.out.println("Your Account Created Successfully");
				}

				break;

			case 2:
				for (BankAccount account : bank) {
					if (account != null) {
						System.out.println("User Account NO:" + account.accNo);
						System.out.println("User Account Holder Name:" + account.name);
						System.out.println("User Account Balance:" + account.balance);
						System.out.println("User Account Type:" + account.accType);
						System.out.println("______________________________________________________");

					}
				}
				break;

			case 3:

				try {
					System.out.println("Enter Account NO. to Search Account");
					int accNo = sc.nextInt();

					for (BankAccount account : bank) {
						if (account != null && accNo != account.accNo) {
							throw new invalidAccountNumberException("Invalid Account Number..");
						}

						if (account.accNo == accNo) {
							System.out.println("User Account NO:" + account.accNo);
							System.out.println("User Account Holder Name:" + account.name);
							System.out.println("User Account Balance:" + account.balance);
							System.out.println("User Account Type:" + account.accType);
							System.out.println("______________________________________________________");
							break;
						}

					}
				}

				catch (invalidAccountNumberException e) {
					e.printStackTrace();
				}
				break;

			case 4:
				try {
					System.out.println("Enter Account NO. to Search Account");
					int accNo1 = sc.nextInt();

					boolean isExists = false;
					for (BankAccount account : bank) {

						if (account != null && accNo1 == account.accNo) {
							isExists = true;

							try {
								System.out.println("Enter ammount to deposite:");
								double ammount = sc.nextDouble();

								account.deposit(ammount);
							} catch (negativeAmmountException e) {
								e.printStackTrace();
							}
							break;
						}

					}

					if (!isExists) {

						throw new invalidAccountNumberException("Account not found...");
					}

				}

				catch (invalidAccountNumberException e) {
					e.printStackTrace();
				}
				break;

			case 5:
				try {
					System.out.println("Enter Account NO. to Search Account");
					int accNo1 = sc.nextInt();
					for (BankAccount account : bank) {

						if (account != null && accNo1 != account.accNo) {
							throw new invalidAccountNumberException("Invalid Account Number..");
						}

						else {
							try {
								System.out.println("Enter ammount to Withdraw:");
								double ammount = sc.nextDouble();

								account.withdraw(ammount);
							} catch (insufficientBalanceException e) {
								e.printStackTrace();
							}
						}
						break;
					}
				}

				catch (invalidAccountNumberException e) {
					e.printStackTrace();
				}
				break;

			case 6:
				System.out.println("Enter Account NO. to Search Account");
				int accNo4 = sc.nextInt();
				for (BankAccount account : bank) {
					if (account != null) {
						if (account.accNo == accNo4) {

							account.checkbalance();
						} else
							System.out.println("Account not found..");

					}
				}
				break;
			case 7:
				System.out.println("Exiting");
				System.exit(0);
			default:

				System.out.println("Invalid input");
				break;
			}
		}

	}
}
