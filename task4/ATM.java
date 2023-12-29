package task4;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class ATM extends JFrame{
	
	private BankAccount userAccount;
	private JTextField amountField;
	
	public ATM(BankAccount userAccount) {
		this.userAccount=userAccount;
		
		setTitle("ATM Machine");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
	}
	private void initComponents() {
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(4,2));
		
		JButton withdrawButton=new JButton("Withdraw");
		JButton depositButton=new JButton("Deposit");
		JButton CheckBalanceButton=new JButton("Check Balance");
		JButton exitButton=new JButton("Exit");
		
		amountField=new JTextField();
		
		panel.add(new JLabel("Enter Amount:"));
		panel.add(amountField);
		panel.add(withdrawButton);
		panel.add(depositButton);
		panel.add(CheckBalanceButton);
		panel.add(exitButton);
		
		withdrawButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				processWithdrawl();
			}
		});
		depositButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				processDeposit();
			}
		});
		CheckBalanceButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				displayBalance();
			}
		});
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		add(panel);
	}
	private void processWithdrawl() {
		try {
			double amount=Double.parseDouble(amountField.getText());
			if(amount>0) {
				if(userAccount.withdraw(amount)) {
					JOptionPane.showMessageDialog(null, "Withdrawl successful. Remaining Balance: "+userAccount.getBalance());
				}
			}else {
				JOptionPane.showMessageDialog(null, "Invalid amount for withdrawl.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	private void processDeposit() {
		try {
			double amount=Double.parseDouble(amountField.getText());
			if(amount>0) {
				userAccount.deposit(amount);
				JOptionPane.showMessageDialog(null, "Deposit Successful. New balance: "+userAccount.getBalance());
			}else {
				JOptionPane.showMessageDialog(null, "Invalid Amount for deposit.","Error", JOptionPane.ERROR_MESSAGE);
			}
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.","Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	private void displayBalance() {
		JOptionPane.showMessageDialog(null, "Current balance: "+userAccount.getBalance());
	}
}