package task5;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class AddressBookGUI {
   
	private JFrame frame;
	private JTextArea displayArea;
	private JTextField nameField, phoneField, emailField;
	private AddressBook addressBook;
	
	public AddressBookGUI() {
		addressBook=new AddressBook();
		initialize();
	}
	private void initialize() {
		frame=new JFrame("Address Book System");
		frame.setBounds(100,100,400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6,2,5,5));
		
		JLabel nameLabel=new JLabel("Name:");
		nameField=new JTextField();
		JLabel phoneLabel=new JLabel("Phoner:");
		phoneField=new JTextField();
		JLabel emailLabel=new JLabel("Email:");
		emailField=new JTextField();
		
		JButton addButton=new JButton("Add Contact");
		JButton removeButton=new JButton("Remove Contact");
		JButton searchButton=new JButton("Search Contact");
		JButton displayButton=new JButton("Display All Contacts");
		
		displayArea=new JTextArea();
		displayArea.setEditable(false);
		
		panel.add(nameLabel);
		panel.add(nameField);
		panel.add(phoneLabel);
		panel.add(phoneField);
		panel.add(emailLabel);
		panel.add(emailField);
		panel.add(addButton);
		panel.add(removeButton);
		panel.add(searchButton);
		panel.add(displayButton);
		panel.add(new JLabel());
		panel.add(new JLabel());
		
		frame.getContentPane().add(BorderLayout.NORTH, panel);
		frame.getContentPane().add(BorderLayout.CENTER, new JScrollPane(displayArea));
		
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addContact();
			}
		});
		removeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				removeContact();
			}
		});
		searchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				searchContact();
			}
		});
		displayButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				displayAllContact();
			}
		});
	}
	private void addContact() {
		String name=nameField.getText();
		String phone=phoneField.getText();
		String email=emailField.getText();
		
		if(name.isEmpty()|| phone.isEmpty() || email.isEmpty()) {
			JOptionPane.showMessageDialog(frame, "Please fill in all field.", "Input Error",JOptionPane.ERROR_MESSAGE);
			return;
		}
		Contact newContact=new Contact(name,phone,email);
		addressBook.addContact(newContact);
		clearField();
		JOptionPane.showMessageDialog(frame, "Contact added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
	}
	private void removeContact() {
		String nameToRemove=nameField.getText();
		Contact contactToRemove=addressBook.searchContact(nameToRemove);
	}
	private void searchContact() {
		String nameToSearch=nameField.getText();
		Contact contact = addressBook.searchContact(nameToSearch);
		
		if(contact != null) {
			displayArea.setText(contact.toString());
		}else {
			displayArea.setText("Contact not found.");
		}
	}
	private void displayAllContact() {
		ArrayList<Contact>contacts=addressBook.getContacts();
		if(contacts.isEmpty()) {
			displayArea.setText("No contacts to display.");
		}else {
			StringBuilder sb =new StringBuilder();
			for(Contact contact : contacts) {
				sb.append(contact.toString()).append("\n-----------------------------------\n");
			}
			displayArea.setText(sb.toString());
		}
	}
	private void clearField() {
		nameField.setText("");
		phoneField.setText("");
		emailField.setText("");
	}
	public void display() {
		SwingUtilities.invokeLater(()-> frame.setVisible(true));
	}
	public static void main(String[]args) {
		AddressBookGUI addressBookGUI=new AddressBookGUI();
		addressBookGUI.display();
	}
}
