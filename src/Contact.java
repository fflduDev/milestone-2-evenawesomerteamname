
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * model a Contact 
 * Contact has a name & list of phonebook entries
 * 
 * Support adding phonebookEntry to a contact
 * 
 * @Override hashCode and equals
 * 
 */

class Contact {
	 
    String name;
    List<PhonebookEntry> entries;

    public Contact(String name) {

        this.name = name;
        this.entries = new ArrayList<PhonebookEntry>();

    }

    public void addPhonebookEntry(String number, String location) {

        this.entries.add(new PhonebookEntry(number, location));

    }

    public List<PhonebookEntry> getPhonebookEntries() {

        return entries;

    }

    public boolean equals(Contact other) {

        return this.name.equals(other.name);

    }

    @Override
    public int hashCode() {

        return Objects.hash(this.name);

    }


}
