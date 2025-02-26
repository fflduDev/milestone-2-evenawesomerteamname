/**
 *   model a PhonebookEntry 
 *   
 *   PhonebookEntry has a phoneNumber and type
 *   
 *   
 *   
 */

class PhonebookEntry{
	
	private String number;
	private String type;
	
	public PhonebookEntry(String number, String numberType) {
		this.number = number;
		this.type = numberType;
	}
	
	public String getType() {
		return type;
	}
	
	public String getPhoneNumber() {
		return number;
	}
	
	public boolean updateNumber(String number) {
		this.number = number;
		return true;
	}

 
}
	