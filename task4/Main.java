package task4;

import javax.swing.SwingUtilities;

public class Main {
    
	public static void main(String[]args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				BankAccount userAccount=new BankAccount(0);
				ATM atm=new ATM(userAccount);
				atm.setVisible(true);
			}
		});
	}
	
}