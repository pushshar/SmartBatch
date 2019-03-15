package com.capgemini.mybank.bl;

import java.util.LinkedList;

import com.capgemini.mybank.beans.Account;
import com.capgemini.mybank.exception.InsufficientBalanceException;
import com.capgemini.mybank.exception.InsufficientOpeningBalanceException;
import com.capgemini.mybank.exception.InvalidAccountNumberException;

public class ICICIBank {

	LinkedList<Account> accounts=new LinkedList<>();
	
	public String createAccount(int accNum,int balance) throws InsufficientOpeningBalanceException
	{
		Account acc=new Account(accNum, balance);
		accounts.add(acc);
		if(balance>500)
		{
			return "Account creatd successfully";
		}
		throw new InsufficientOpeningBalanceException();
	}
	
	public Account traverseAccount(int accNum)throws InvalidAccountNumberException
	{
		for(Account a:accounts)
		{
			if(accNum==a.getAccountNumber())
				return a;
		}
		throw new InvalidAccountNumberException();
	}
	
	public int withdrawMoney(int accNum, int amount) throws InvalidAccountNumberException, InsufficientBalanceException
	{
		Account acc=traverseAccount(accNum);
		
		if((acc.getAmount()-amount)>=0)
		{
			acc.setAmount(acc.getAmount()-amount);
			return acc.getAmount();
			
		}
		throw new InsufficientBalanceException();
		
	}
	
	public int depositAmount(int accNum, int amount) throws InvalidAccountNumberException
	{
		Account acc=traverseAccount(accNum);
		
		int total=acc.getAmount()+amount;
		acc.setAmount(total);
		return total;
	}
	
	public String fundTransfer(int myNum,int transferNum,int amount) throws InvalidAccountNumberException, InsufficientBalanceException
	{
		Account acc1=traverseAccount(myNum);
		Account acc2=traverseAccount(transferNum);
		
		int remain=withdrawMoney(myNum,amount);
		int increase=depositAmount(transferNum,amount);
		
		return "myNum= "+ remain +"  transferNum="+increase;
		
		
	}
}
