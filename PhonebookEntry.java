package template;

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
	
	public String getNumberType() {
		return type;
	}
	
	public int getPhoneNumber() {
		return number;
	}
	
	public boolean updateNumber(int number) {
		this.number = number;
	}

 
}
	