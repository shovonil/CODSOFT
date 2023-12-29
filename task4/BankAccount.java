package task4;
	
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BankAccount {
   
	private double balance;
	
	public BankAccount(double initialBalance) {
		this.balance=initialBalance;
	}
	public double getBalance() {
		return balance;
	}
	public void deposit(double amount) {
		balance+=amount;
	}
	public boolean withdraw(double amount) {
		if(amount<=balance) {
			balance-=amount;
			return true;
		}else {
			JOptionPane.showMessageDialog(null, "Insuficient funds!", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
}
