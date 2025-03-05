
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
    
	public List<PhonebookEntry> binarySearch(List<Contact> sortedContacts, String name) {
		int middle = (int) Math.floor(sortedContacts.size() / 2);
		int cycle = 4;
		while (middle != 0 && middle != sortedContacts.size() - 1) {
			if (sortedContacts.get(middle).name.equals(name)) {
				return sortedContacts.get(middle).getPhonebookEntries();
			}
			else if (sortedContacts.get(middle).name.compareTo(name) > 0) {
				middle = (int) Math.floor(sortedContacts.size() / cycle);
				cycle += 2;
			} else {
				middle = middle + (int) Math.floor(sortedContacts.size() / cycle);
				cycle += 2;
			}
		}
		return null;
	}

	public void display(List<Contact> sortedContacts) {}
 
}
