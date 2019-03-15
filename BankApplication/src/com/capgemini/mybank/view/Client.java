package com.capgemini.mybank.view;

import java.util.Scanner;

import com.capgemini.mybank.beans.Account;
import com.capgemini.mybank.bl.ICICIBank;
import com.capgemini.mybank.exception.InsufficientBalanceException;
import com.capgemini.mybank.exception.InsufficientOpeningBalanceException;
import com.capgemini.mybank.exception.InvalidAccountNumberException;

public class Client {

	static ICICIBank agent=new ICICIBank();
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		
		/*try
		{
		String status=agent.createAccount(101,6000);
		System.out.println(status);
		String status1=agent.createAccount(103,6000);
		System.out.println(status1);
		}
		catch(InsufficientOpeningBalanceException iob)
		{
			System.out.println(iob.getMessage());
			System.exit(0);
		}
		
		try
		{
			int bal=agent.withdrawMoney(101,2000);
			System.out.println("Balance="+bal);
		}
		catch(InvalidAccountNumberException ian)
		{
			System.out.println(ian.getMessage());
		}
		catch(InsufficientBalanceException ib)
		{
			System.out.println(ib.getMessage());
		}
		try
		{
		int finalAmt=agent.depositAmount(101, 2000);
				{
			System.out.println(" total balance:"+finalAmt);
				}
	}
		catch(InvalidAccountNumberException ia)
		{
			System.out.println(ia.getMessage());
		}

		try {
		String message=agent.fundTransfer(101, 103, 2000);
		System.out.println(message);
		}
		catch(InvalidAccountNumberException ian)
		{
			System.out.println(ian.getMessage());
		}
		catch(InsufficientBalanceException ib)
		{
			System.out.println(ib.getMessage());
		}*/
		
		
		while(true)
		{
		
		System.out.println("Welcome to Shandaar Bank:");
		System.out.println("Please choose from valid choices");
		System.out.println("1- open an account");
		System.out.println("2- deposit in account ");
		System.out.println("3- Withdraw from account");
		System.out.println("4- display account details");
		System.out.println("5-Fund transfer");
		System.out.println("any other key to exit");
		int choice =sc.nextInt();
		switch(choice)
		{
		case 1: openAccount();
				break;
		case 2: depositMoney();
				break;
		case 3: withdrawMoney();
				break;
		case 4: display();
				break;
		case 5: fundMovement();
				break;
		default: System.out.println("Thank you for banking with US");
			System.exit(0);
		}
	}
	}
	private static void display() {
		System.out.println("enter account number to display");
		int num=sc.nextInt();
		Account acc=new Account(num,0);
		try {
		acc=agent.traverseAccount(num);
		}
		catch(InvalidAccountNumberException ian)
		{
			System.out.println(ian.getMessage());
		}
		System.out.println("Account= " +num+ " has " +acc.getAmount());
		
	}
	private static void withdrawMoney() {
		
		System.out.println("enter your account number");
		int num=sc.nextInt();
		System.out.println("tell amount to withdraw");
		int with=sc.nextInt();
		try {
		int amount=agent.withdrawMoney(num,with);
		System.out.println("Balance after withdrawal="+amount);
		}
		catch(InvalidAccountNumberException ian)
		{
			System.out.println(ian.getMessage());
		}
		catch(InsufficientBalanceException ib)
		{
			System.out.println(ib.getMessage());
		}
		
		
	}
	private static void depositMoney() {
		// TODO Auto-generated method stub
		System.out.println("enter your account number");
		int num=sc.nextInt();
		System.out.println("tell amount to deposit");
		int depo=sc.nextInt();
		try {
		int b=agent.depositAmount(num,depo);
		System.out.println("balance after deposit ="+b);
		}
		catch(InvalidAccountNumberException ia)
		{
			System.out.println(ia.getMessage());
		}
		
	}
	public static double checkBal(double bal)
	{
		if(bal<500)
		{
			System.out.println("minimum of 500 balance is needed");
			System.out.println("do you want 500 as your initital balance ");
			System.out.println("press 1- yes \n 2- no");
			int n=sc.nextInt();
			if(n==1)
			{
				return 500.0f;
			}
			else if(n==2)
			{
				return 0.0f;
			}
			else
			{
				System.out.println("invalid choice");
			}
		}
		return bal;
	}
	public static void openAccount()
	{
		System.out.println("Be patient and tell basic details");
		System.out.println("enter acc number");
		
		
		int acc=sc.nextInt();
		
		System.out.println("enter your intital balance");
		int bal=sc.nextInt();
		
		try
		{
		String l=agent.createAccount(acc,bal);
		System.out.println(l);
		}
		catch(InsufficientOpeningBalanceException iob)
		{
			System.out.println(iob.getMessage());
			
		}
		
	}
	
	public static void fundMovement()
	{
		System.out.println("enter your account number");
		int num1=sc.nextInt();
		System.out.println("enter sender account number");
		int num2=sc.nextInt();
		System.out.println("tell amount to transfer");
		int t=sc.nextInt();
		try {
		String message=agent.fundTransfer(num1, num2, t);
		System.out.println(message);
		}
		catch(InvalidAccountNumberException ian)
		{
			System.out.println(ian.getMessage());
		}
		catch(InsufficientBalanceException ib)
		{
			System.out.println(ib.getMessage());
		}
}
}
