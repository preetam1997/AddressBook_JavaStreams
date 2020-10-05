package addressbook;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class DriverClass {
	
	private static Map<String, AddressBook> AddressBookMap = new HashMap<String, AddressBook>();
	public static Scanner myObj = new Scanner(System.in);
	private static LinkedList<String>  addressList = new LinkedList<String>();
	private static Map<String,LinkedList> PersonToCity = new HashMap<String,LinkedList>();
	private static Map<String,LinkedList> PersonToState = new HashMap<String,LinkedList>();
	
	
	public static void MapAddress(AddressBook e) {
		
		System.out.println("Enter Address Book Name");
		String AddressBookName = myObj.nextLine();
		addressList.add(AddressBookName);
		
		AddressBookMap.put(AddressBookName, e);
		
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to AddressBook Assignment");
		Scanner myObj = new Scanner(System.in);
		
		while(true){
			System.out.println("1.UC1 Create Your Own Address Book");
			System.out.println("2.UC2 Add Address");
			System.out.println("3.UC3 Edit Entry Based on Name");
			System.out.println("4.UC4 Delete Entry Based on Name");
			System.out.println("5.Display Contacts");
			System.out.println("6.UC8 Search by City Name");
			System.out.println("7.UC8 Search by State Name");
			System.out.println("8.UC9 Search by City Name (Person Mapping)");
			System.out.println("9.UC9 Search by State Name (Person Mapping)");
			System.out.println("10.UC10 Count Persons in a City");
			System.out.println("11.UC10 Count Persons in a State");
			System.out.println("12.Exit");
			System.out.println("Enter your choice:");
			int choice = myObj.nextInt();
			switch(choice) {
			
			case 1: AddressBook addressbook = new AddressBook();
					MapAddress(addressbook);
					break;
					
			case 2: System.out.println("Enter Address Book name");
					Scanner myObj3 = new Scanner(System.in);
					String addressBookName = myObj3.nextLine();
					
					AddressBook e = AddressBookMap.get(addressBookName);
					if(e==null) {
						System.out.println("AddressBook Not Found");
						System.out.println("Creating New AddressBook");
						AddressBook addressBook = new AddressBook();
						MapAddress(addressBook);
						continue;
					
					}
					Contacts c= e.addAdress();
					//MapPerson(c);
					
					break;
			
			case 3: System.out.println("Enter Address Book name");
					Scanner myObj1 = new Scanner(System.in);
					String addressBookName1 = myObj1.nextLine();
					AddressBook e1 = AddressBookMap.get(addressBookName1);
					if(e1==null) {
						System.out.println("AddressBook Not Found");
						
						continue;
					
					}
					e1.editUsingName();
					
					break;
					
			case 4: System.out.println("Enter Address Book name");
					Scanner myObj2 = new Scanner(System.in);
					String addressBookName2 = myObj2.nextLine();
					AddressBook e2 = AddressBookMap.get(addressBookName2);
					if(e2==null) {
						System.out.println("AddressBook Not Found");
						continue;
					
					}
					e2.delete();
					break;
					
			case 5: System.out.println("Enter Address Book name");
					Scanner myObj4 = new Scanner(System.in);
					String addressBookName4 = myObj4.nextLine();
					AddressBook e3 = AddressBookMap.get(addressBookName4);
					if(e3==null) {
						System.out.println("AddressBook Not Found");
						continue;
					
					}
					e3.displayAllContacts();
					break;
					
			case 6:	System.out.println("Enter City name");
					Scanner myObj6 = new Scanner(System.in);
					String city = myObj6.nextLine();
					addressList.stream().forEach(i->AddressBookMap.get(i).SearchNameByCity(city));
					break;
					
			case 7: System.out.println("Enter State name");
					Scanner myObj7 = new Scanner(System.in);
					String State = myObj7.nextLine();
					addressList.stream().forEach(i->AddressBookMap.get(i).SearchNameByState(State));
					break;
					
			case 8:	System.out.println("Enter City Name (Person Mapping)");
					Scanner myObj8 = new Scanner(System.in);
					String City = myObj8.nextLine();
					addressList.stream().
					forEach(i->AddressBookMap.get(i).
							getMappingByCity(City).stream().
							forEach(p -> System.out.println(p.firstName+" "+p.lastName)));
					break;
					
			case 9:	System.out.println("Enter City Name (Person Mapping)");
					Scanner myObj9 = new Scanner(System.in);
					String state = myObj9.nextLine();
					addressList.stream().
					forEach(i->AddressBookMap.get(i).
							getMappingByState(state).stream().
							forEach(p -> System.out.println(p.firstName+" "+p.lastName)));
					break;
			
			case 10:System.out.println("Enter City Name (Person Mapping)");
				   	Scanner myObj10 = new Scanner(System.in);
				   	String City1 = myObj10.nextLine();
				   	System.out.println(PersonToCity.get(City1).size());
				   	break;
	
			case 11:System.out.println("Enter State Name (Person Mapping)");
					Scanner myObj11 = new Scanner(System.in);
					String State1 = myObj11.nextLine();
					System.out.println(PersonToCity.get(State1).size());
					break;
	
			case 12: return;
			}
		
	}
		
}

}