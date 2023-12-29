package task3;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

	public class StudentManagementSystemUI extends JFrame{
			    
		private StudentManagementSystem system;
		private JTextField nameField;
		private JTextField rollNumberField;
		private JTextField gradeField;
		private JTextArea outputArea;
		
		public StudentManagementSystemUI() {
			system=new StudentManagementSystem();
			
			setTitle("Student Management System");
			setSize(400,300);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			createUI();
		}
		public void createUI() {
			JPanel panel=new JPanel();
			panel.setLayout(new GridLayout(6, 2));
			
			JLabel nameLabel=new JLabel("Name:");
			nameField=new JTextField();
			JLabel rollNumberLabel=new JLabel("Roll Number:");
			rollNumberField=new JTextField();
			JLabel gradeLabel=new JLabel("Grade:");
			gradeField=new JTextField();
			
			JButton addButton=new JButton ("Add Student");
			addButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					addStudent();
				}
			});
				JButton editButton =new JButton("Edit Student");
				editButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						editStudent();
					}
				});
				JButton SearchButton = new JButton("Search Student");
				SearchButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						searchStudent();
					}
				});
				JButton displayButton=new JButton("Display All Students");
				displayButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						displayAllStudents();
					}
				});
				JButton exitButton = new JButton("Exit");
				exitButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						exitApplication();
					}
				});
				outputArea = new JTextArea();
				outputArea.setEditable(false);
				
				panel.add(nameLabel);
				panel.add(nameField);
				panel.add(rollNumberLabel);
				panel.add(rollNumberField);
				panel.add(gradeLabel);
				panel.add(gradeField);
				panel.add(addButton);
				panel.add(editButton);
				panel.add(SearchButton);
				panel.add(displayButton);
				panel.add(exitButton);
				
				add(panel, BorderLayout.NORTH);
				add(new JScrollPane(outputArea), BorderLayout.CENTER);
		}
		private void addStudent() {
			String name=nameField.getText();
			String rollNumberText=rollNumberField.getText();
			String grade=gradeField.getText();
			
			try {
				int rollNumber = Integer.parseInt(rollNumberText);
				Student newStudent = new Student(name, rollNumber, grade);
				system.addStudent(newStudent);
				displayMessage("Student added: "+newStudent);
				clearFields();
			}catch(NumberFormatException e) {
				displayMessage("Invalid Roll Number. Please enter a valid number.");
			}					
		}
		
		private void editStudent() {
			String rollNumberText=JOptionPane.showInputDialog("Enter Roll Number to Edit:");
			try {
				int rollNumber = Integer.parseInt(rollNumberText);
				Student student = system.searchStudent(rollNumber);
				if(student != null) {
					String newName=JOptionPane.showInputDialog("Enter new name for student:");
					String newGrade=JOptionPane.showInputDialog("Enter new Grade for student:");
					student.setName(newName);
					student.setGrade(newGrade);
					displayMessage("Student Information edited: "+student);
				}else {
					displayMessage("Student not found.");
				}
			}catch(NumberFormatException e) {
				displayMessage("Invalid Roll Number. Please enter a valid number.");
			}
		}
		private void searchStudent() {
			String rollNumberText= JOptionPane.showInputDialog("Enter Roll Number to search:");
			try {
				int rollNumber=Integer.parseInt(rollNumberText);
				Student student=system.searchStudent(rollNumber);
				if(student!=null) {
					displayMessage("Student found: "+student);
				}else {
					displayMessage("Student not found: "+student);
				}
		}catch(NumberFormatException e) {
			displayMessage("Invalid Roll Number. Please enter a valid number.");
		}
		}
		private void displayAllStudents() {
			outputArea.setText("");
			for(Student student : system.getStudents()) {
				displayMessage(student.toString());
			}
		}
		private void exitApplication() {
			int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?","Exit", JOptionPane.YES_NO_OPTION);
			if(option ==JOptionPane.YES_OPTION) {
			System.exit(0);
			}
		}
		private void displayMessage(String message) {
			outputArea.append(message+"\n");
		}
		private void clearFields() {
			nameField.setText("");
			rollNumberField.setText("");
			gradeField.setText("");
		}
		public static void main(String args[]) {
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					new StudentManagementSystemUI().setVisible(true);
				}
			});
		}
				
			}
