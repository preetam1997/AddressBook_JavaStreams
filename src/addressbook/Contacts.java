package addressbook;

import java.util.Objects;

public class Contacts {
	public String firstName;
	public String lastName;
	public String Address;
	public String City;
	public String State;
	public String zip;
	public String phoneNumber;
	public String email;
	
	public Contacts(String firstName,String lastName,String Address,String City, String State,String zip,String phoneNumber,String email) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.Address = Address;
		this.City = City;
		this.State = State;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, Address, City, State, zip, phoneNumber, email);
		
	}
	
	@Override
	public boolean equals(Object obj) {
	      if (obj == this) {
	         return true;
	      }
	      if (!(obj instanceof Contacts)) {
	         return false;
	      }
	      Contacts c = (Contacts) obj;
	      return firstName.equals(c.firstName)&& lastName.equals(c.lastName);
	   }
	
	public String get_city() {
		return City;
	}
	
	public String get_state() {
		return State;
	}
}