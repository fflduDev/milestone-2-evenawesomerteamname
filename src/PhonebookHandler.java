
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
  
        return quickSort(phonebook.keySet().toArray(new Contact[0]));

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

    public List<Contact> quickSort(Contact[] contacts) {

        quickSort(contacts, 0, contacts.length - 1);

        return Arrays.asList(contacts);

    }

    public void quickSort(Contact[] contacts, int left, int right) {

        if (left < right) {

            int pivot = partition(contacts, left, right);

            quickSort(contacts, left, pivot - 1);
            quickSort(contacts, pivot, right);

        }

    }

    public int partition(Contact[] contacts, int left, int right) {

        boolean leftSide = true;
        int pivotIndex = left;
        String pivotValue = contacts[left++].name;

        final int RANGE = right - left;

        for (int i = 0; i < RANGE; i++) {

            if (leftSide) {

                if (contacts[left].name.compareTo(pivotValue) <= 0) {

                    left++;

                } else {

                    leftSide = false;

                }

            } else {

                if (contacts[right].name.compareTo(pivotValue) > 0) {

                    right--;

                } else {

                    swap(contacts, left, right);
                    leftSide = true;
                    left++; right--;

                }

            }

        }

        if (contacts[left].name.compareTo(contacts[right].name) > 0) swap(contacts, left, right);

        if (contacts[left].name.compareTo(pivotValue) < 0) swap(contacts, left, pivotIndex);

        return left;

    }

    public void swap(Contact[] contacts, int i1, int i2) {

        Contact temp = contacts[i1];
        contacts[i1] = contacts[i2];
        contacts[i2] = temp;
        
    }


	public void display(List<Contact> sortedContacts) {

        System.out.println("Phonebook:");

        for (Contact c : sortedContacts) {

            System.out.println(c.name);
            for (PhonebookEntry p : c.getPhonebookEntries()) System.out.println("\t" + p.getType() + ": " + p.getPhoneNumber());

        }

    }
 
}
