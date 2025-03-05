
import java.util.*;

/**
 * PhonebookHandler - supports 
 * Phonebook operations
 * 
 * Use a map to build the Phonebook
 * key: Contact
 * value: List<phonebookEntries>
 */

public class PhonebookHandler implements iPhonebookHander{

    Map<Contact, List<PhonebookEntry>> phonebook;

    public PhonebookHandler(Map<Contact, List<PhonebookEntry>> phonebook) {
        this.phonebook = phonebook;
    }

    public List<Contact> sortByName() {

        List<Contact> contacts = new ArrayList<Contact>();

        for (Contact c : phonebook.keySet()) contacts.add(c);
  
        contacts.sort((o1, o2) -> o1.name.compareTo(o2.name));

        return contacts;

    }

	public List<PhonebookEntry> binarySearch(List<Contact> sortedContacts, String name) {return null;}
	public void display(List<Contact> sortedContacts) {}
 
}
