package task5;

	import java.util.ArrayList;
public class AddressBook {
	
	private ArrayList<Contact>contacts;
	
	public AddressBook() {
		this.contacts=new ArrayList<>();
	}
	public void addContact(Contact contact) {
		contacts.add(contact);
	}
	public void removeContact(Contact contact) {
		contacts.remove(contact);
	}
	public Contact searchContact(String name) {
		for(Contact contact : contacts) {
			if(contact.getName().equalsIgnoreCase(name)) {
				return contact;
			}
		}
		return null;
	}
	public ArrayList<Contact> getContacts(){
		return contacts;
	}
	
	}
