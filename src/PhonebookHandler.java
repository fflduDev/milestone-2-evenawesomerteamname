
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

    public List<Contact> sort() {

        Contact[] contacts = phonebook.keySet().toArray(new Contact[0]);

        quickSort(contacts, 0, contacts.length - 1);

        return Arrays.asList(contacts);

    }

    public void quickSort(Contact[] contacts, int left, int right) {

        if (left < right) {

            int pivot = partition(contacts, left, right);

            quickSort(contacts, left, pivot - 1);
            quickSort(contacts, pivot + 1, right);

        }

    }

    public int partition(Contact[] contacts, int left, int right) {
        
        int pivot_index = left;
        String pivot_value = contacts[left++].name;
        

        // MAKE SURE LEFT == RIGHT IS LESS THAN PIVOT OTHERWISE BREAK?? OR HANDLE THAT CASE

        // Until left and right equal partition
        while (left != right) {

            // Move left towards right until value > pivot or index == right
            while (contacts[left].name.compareTo(pivot_value) <= 0 && left != right) {
                left++;
            }

            // Then move right towards left until value < pivot or index == left
            while (contacts[right].name.compareTo(pivot_value) >= 0 && left != right) {
                right--;
            }

            // If left != right, swap left and right, repeat
            if (left != right) {
                swap(contacts, left, right);
            }

            // When left == right, swap pivot with one so it's in right position
            if (left == right) {
                if (contacts[left].name.compareTo(pivot_value) <= 0) {
                    swap(contacts, pivot_index, left);
                } else {
                    swap(contacts, pivot_index, left - 1);
                }
                break;
            }

        }

        return left;

    }

    public void swap(Contact[] contacts, int i1, int i2) {
        Contact temp = contacts[i1];
        contacts[i1] = contacts[i2];
        contacts[i2] = temp;
    }


	public void display(List<Contact> sortedContacts) {}
 
}
