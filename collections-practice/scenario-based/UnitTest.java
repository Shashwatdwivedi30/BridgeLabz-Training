using System;
using NUnit.Framework;

public class Program
{
    public decimal Balance { get; private set; }
    public Program(decimal initialBalance)
    {
        Balance = initialBalance;
    }

    public void Deposit(decimal amount)
    {
        if (amount < 0)
            throw new Exception("Deposit amount cannot be negative");
        Balance += amount;
    }

    public void Withdraw(decimal amount)
    {
        if (amount > Balance)
            throw new Exception("Insufficient funds.");

        Balance -= amount;
    }
}

[TestFixture]
public class UnitTest
{
    [Test]
    public void Test_Deposit_ValidAmount()
    {
        Program account = new Program(100);
        account.Deposit(50);
        Assert.AreEqual(150, account.Balance);   
    }

    [Test]
    public void Test_Deposit_NegativeAmount()
    {
        Program account = new Program(100);
        Assert.Throws<Exception>(() => account.Deposit(-10));   
    }

    [Test]
    public void Test_Withdraw_ValidAmount()
    {
        Program account = new Program(200);
        account.Withdraw(80);
        Assert.AreEqual(120, account.Balance);   
    }

    [Test]
    public void Test_Withdraw_InsufficientFunds()
    {
        Program account = new Program(50);
        Assert.Throws<Exception>(() => account.Withdraw(100));   
    }
}