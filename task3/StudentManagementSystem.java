package task3;

import java.util.*;
	public class StudentManagementSystem {
   
		private List<Student> students;
		
	public StudentManagementSystem() {
		
		this.students=new ArrayList<>();
	}
	public void addStudent(Student student) {
		students.add(student);
	}
	public void removeStudent(int rollNumber) {
		Iterator<Student>iterator=students.iterator();
		
		while(iterator.hasNext()) {
			Student student=iterator.next();
			if(student.getRollNumber()== rollNumber) {
				iterator.remove();
				System.out.println("Student remove: "+ student);
				return;
			}
		}
		System.out.println("Student with roll number "+rollNumber+" not found.");
	}
	public Student searchStudent(int rollNumber) {
		for(Student student : students) {
			if(student.getRollNumber()==rollNumber) {
				return student;
			}
		}
		return null;
	}
	public List<Student> getStudents(){
		return students;
	}
}