package addressbook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DriverClass {
	
	private static Map<String, AddressBook> AddressBookMap = new HashMap<String, AddressBook>();
	public static Scanner myObj = new Scanner(System.in);
	
	
	
	public static void MapAddress(AddressBook e) {
		
		System.out.println("Enter Address Book Name");
		String AddressBookName = myObj.nextLine();
		
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
			System.out.println("6.Exit");
			System.out.println("Enter your choice:");
			int choice = myObj.nextInt();
			switch(choice) {
			
			case 1: AddressBook addressbook = new AddressBook();
					//addressbook.addAdress();
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
					e.addAdress();
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
					
			case 6: return;
			}
		
	}
		
}

}
