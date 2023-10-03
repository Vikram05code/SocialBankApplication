package com.bank.in;

import java.util.Scanner;

public class SocialBankApp {
   
	public static void main(String[] args) {
		
		int amount = 10000;
		System.out.println("Welcome To Social Bank");
		final String user = "code@55";
		final String userPassword = "code12345";
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter User ID: ");
		String id = sc.next();
		System.out.print("Enter Password: ");
		String password = sc.next();
		
		if(user.equalsIgnoreCase(id) && userPassword.equalsIgnoreCase(password)) {
			while(true) {
				System.out.println("1.Balance Check\n"
						           +"2.Deposit\n"
						           +"3.Withdraw\n"
						           +"4.Send Money\n"
						           +"5.Exit");
				System.out.print("Enter your choice: ");
				int x = sc.nextInt();
				
				if(x==1) { 
				amount = SocialBankApp.checkBalance(amount);
				continue;
				}
				else if(x==2) {
					amount = SocialBankApp.deposit(amount);
					continue;
				}
				else if(x==3) {
					amount = SocialBankApp.withdrawal(amount);
					continue;
				}
				else if(x==4) {
					amount = SocialBankApp.send(amount);
					continue;
				}
				else if(x==5) {
					System.out.println("Thank you, Visit Again");
					System.exit(0);
				}
				else {
					System.out.println("Invalid Input Please Try Again");
				}
			}
		}
		else {
			System.out.println("Incorrect User and Password Details, KIndly check User and Password");
		    System.exit(0);
		    sc.close();
		}
	}
	//1. For balance checking
	private static int checkBalance(int amount) {
		System.out.println("Your Current Balance is RS: "+amount);
		return amount;
	}
	
	//2. Balance deposit
	private static int deposit(int amount) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please Enter the amount to deposit: ");
		int deposit = sc.nextInt();
		amount+=deposit;
		System.out.println("RS "+amount+" is credited into your account");
		System.out.println("Current Available Balance = "+amount);
		return amount;
	}
	
	//3. Balance withdrawal
	private static int withdrawal(int amount) {
	Scanner sc = new Scanner(System.in);
	System.out.print("Please Enter the amount to withdraw: ");
	int withdrawAmount = sc.nextInt();
	if(withdrawAmount<amount) {
		amount -= withdrawAmount;
		System.out.println("RS "+withdrawAmount +" is withdraw from your account");
	    System.out.println("Your Current Available Balance is "+amount);
	    return amount;
	
	}else {
		System.out.println("Low Balance");
		System.out.println("Current available balance is : "+amount);
		return amount;
	}
	
	}
	
	//4. send money
	private static int send(int amount) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("Enter the amount you want to send RS ");
			int sendAmount = sc.nextInt();
			if(sendAmount < amount) {
				System.out.println("Select the option for sending Money\n 1.Mobile Number\n 2.UPI ID\n 3.Bank Account");
				int choice = sc.nextInt();
				if(choice==1) {
					System.out.print("Enter Valid Mobile Number: ");
					Long num = sc.nextLong();
					if(num< 10000000000L && num>999999999L) {
						amount -= sendAmount;
						System.out.println("RS "+sendAmount+" debited from your account");
						System.out.println("Rs "+sendAmount+" is send to mobile number "+num);
						System.out.println("Current Available Balance is Rs "+amount);
						
					}else {
						System.out.println("Entered Mobile Number is not valid Please Try again");
						continue;
					}
					break;
				}
				else if(choice==2) {
					System.out.print("Please Enter your UPI ID: ");
					String upiId = sc.next();
					if(upiId.indexOf("@")>0) {
						amount -= sendAmount;
						System.out.println("Rs "+sendAmount+ " is send to UPI Id "+upiId);
						System.out.println("Current Available Balance is Rs "+amount);
					}else {
						System.out.println("Entered UPI Id is not valid Please Try agian");
						continue;
					}
					break;
				}
				else if(choice==3) {
					System.out.println("Please Enter the Account Holder's Name: ");
					String name = sc.next();
					System.out.println("Please Enter the Account Number: ");
					String accountNum = sc.next();
					System.out.print("Please Enter the IFSC Code ");
					String ifscCode = sc.next();
					amount-=sendAmount;
					System.out.println("Rs "+sendAmount+" is send to "+name+"\nAccount Number: "+accountNum+"\nIFSC Code: "+ifscCode);
					break;
				}
				else {
					System.out.println("Invalid input please try again");
				}
				
			}
			else {
				System.out.println("Low Balance");
				System.out.println("Current Available Balance Rs "+amount);
				
			}
		}
		return amount; 
	}

}
