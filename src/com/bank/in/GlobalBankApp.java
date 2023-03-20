package com.bank.in;

import java.util.Scanner;

public class GlobalBankApp {
   
	public static void main(String[] args) {
		int amount = 100000;
		System.out.println("***Welcome to Global Bank***");
		Scanner sc = new Scanner(System.in);
		final String user ="code@555";
		final String passw ="pass@555";
		System.out.print("Enter User ID: ");
		String id =sc.next();
		System.out.print("Enter User Password: ");
		String passWord =sc.next();
		if(user.equalsIgnoreCase(id) && passw.equalsIgnoreCase(passWord)) {
		while(true) {
		System.out.print("1.Balance Check\n"
				+ "2.Deposit\n"
				+ "3.Withdraw\n"
				+ "4.Send Money\n"
				+ "5.Exit\n"
				+ "Enter your choice : ");
		int x = sc.nextInt();

		if(x==1){
			amount = GlobalBankApp.balanceCheck(amount);
			continue;
		}
		else if(x==2){
			amount = GlobalBankApp.deposit(amount);
			continue;
		}
        else if(x==3){
        	amount = GlobalBankApp.withdraw(amount);
        	continue;
		}
        else if(x==4){
        	amount = GlobalBankApp.send(amount);
        	continue;
		}
        else if(x==5){
        	System.out.println("Thank you,Visit Us Again");
			System.exit(0);
		}
        else {
        	System.out.println("Invalid Input Please try again");
        }
		}
	}
		else {
			System.out.println("Invalid login details");
	        System.exit(0);
		}
		sc.close();
  }
	//1. For Balance Checking
	private static int balanceCheck(int amount) {
		System.out.println("Your Current Account Balance is Rs."+amount);		
	return amount;
	}

	//2.For Deposit
	private static int deposit(int amount) {
		Scanner sc =new Scanner(System.in);
		System.out.print("Please Enter the amount to Deposit Rs.");
		int deposit = sc.nextInt();
		amount += deposit;
		System.out.println("Rs."+deposit+" is credited into your Account");
		System.out.println("Current Available Balance is Rs."+ amount);
		return amount;
		}
	//3.For Withdraw
    private static int withdraw(int amount) {

		System.out.print("Enter the Amount you want to withdraw Rs.");
		Scanner sc= new Scanner(System.in);
		int withdraw =sc.nextInt();
		if(withdraw<amount)
		{
			amount=amount-withdraw;
			System.out.println("Rs."+ withdraw+" is withdraw from your Account");
			System.out.println("Current Available Balance is Rs."+ amount);
			return amount;
		}
		else
		{
			System.out.println("Low Balance");
			System.out.println("Current Available Balance is Rs."+ amount);
			return amount;
		}
	}
	//4.For Sending Money
	private static int send(int amount) {
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.print("Enter the Amount to send Rs.");
		int send =sc.nextInt();
		if(send<amount) {
		System.out.println("Select the option for sending Money\n 1.Mobile Number\n 2.UPI ID\n 3.Bank Account");
		int x =sc.nextInt();
		if(x==1) {
			System.out.println("Please Enter the mobile Number");
			Long num = sc.nextLong();
			if(num<10000000000L && num>999999999L) {
				amount -= send;
			System.out.println("Rs."+send+" debited from your account");
			System.out.println("Rs."+send+" is send to mobie number "+num);
			System.out.println("Current Available Balance is Rs."+ amount);
		   }
			else{
				System.out.println("Entered Mobile no. is not valid Please Try again");
				continue;
			}
			break;
		}
		else if(x==2) {
			System.out.println("Please Enter the UPI ID");
			String id =sc.next(); 
			if(id.indexOf("@")>0) {
				amount -= send;
			System.out.println("Rs."+send+" is send to UPI ID "+id);
			System.out.println("Current Available Balance is Rs."+ amount);
			}else {
				System.out.println("Entered UPI ID is not valid Please Try again");
				continue;
			}
			break;
		}
		else if(x==3) {
			System.out.print("Please Enter the Account Holder's Name:");
			String name =sc.next();
			System.out.print("Please Enter the Account Number:");
			String accountNumber =sc.next();
			System.out.print("Please Enter the IFSC Code:");
			String ifscCode =sc.next(); 
			amount -= send;
			System.out.printf("Rs.%d is send to %s.\nAccount Number:%s\nIFSC Code:%s \n",send,name,accountNumber,ifscCode);
			System.out.println("Current Available Balance is Rs."+ amount+"\n");
			break;
		}
		else {
			System.out.println("Invalid input Please try again");

		}
		}else { 
			System.out.println("Low Balance");
		}
	}
	return amount;
	}

	
}
