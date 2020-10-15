package addressbook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Set;

public class AddressBookFileIOService {
	public static String INPUT_FROM_FILE_NAME = "address-input-file.txt";
	public static String OUTPUT_TO_FILE_NAME = "address-output-file.txt";

	public static <T> List<T> convertSetToList(Set<T> set) {
		List<T> list = new ArrayList<>();
		for (T t : set)
			list.add(t);
		return list;
	}

	public void readData(Map<String, AddressBook> AddressBookMap) {
		try {
			List<String> lines = Files.readAllLines(Paths.get(INPUT_FROM_FILE_NAME));

			for (String line : lines) {
				String[] k = line.split(" ");
				System.out.println(k.length);
				AddressBook newAddressBook = AddressBookMap.get(k[0]);
				if (newAddressBook == null) {
					AddressBookMap.put(k[0], new AddressBook());
					AddressBookMap.get(k[0]).contactList
							.add(new Contacts(k[1], k[2], k[3], k[4], k[5], k[6], k[7], k[8]));
				} else {
					AddressBookMap.get(k[0]).contactList
							.add(new Contacts(k[1], k[2], k[3], k[4], k[5], k[6], k[7], k[8]));
				}

			}

		} catch (IOException e) {

		}
	}

	@SuppressWarnings("unused")
	public void writeData(Map<String, AddressBook> AddressBookMap) {
		StringBuffer empBuffer = new StringBuffer();

		AddressBookMap.entrySet().forEach(entry -> {
			String contactString = entry.getKey().concat("\n");
			empBuffer.append(contactString);
			entry.getValue().contactList.forEach(contact -> {
				String contacts = contact.toString().concat("\n");
				empBuffer.append(contacts);
			});
		});

		try {
			Files.write(Paths.get(OUTPUT_TO_FILE_NAME), empBuffer.toString().getBytes());
		} catch (IOException e) {

		}

	}

}
