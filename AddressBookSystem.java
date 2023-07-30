
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contact {
    private final String name;
    private String phoneNumber;
    private String emailAddress;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + emailAddress;
    }
}

class AddressBook {
    private final List<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added: " + contact.getName());
    }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
        System.out.println("Contact removed: " + contact.getName());
    }

    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts in the address book.");
        } else {
            System.out.println("All contacts in the address book:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }
}

public class AddressBookSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a new contact");
            System.out.println("2. Remove a contact");
            System.out.println("3. Search for a contact");
            System.out.println("4. Display all contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter email address: ");
                    String emailAddress = scanner.nextLine();
                    Contact newContact = new Contact(name, phoneNumber, emailAddress);
                    addressBook.addContact(newContact);
                }
                case 2 -> {
                    System.out.print("Enter name to remove: ");
                    String nameToRemove = scanner.nextLine();
                    Contact contactToRemove = addressBook.searchContact(nameToRemove);
                    if (contactToRemove != null) {
                        addressBook.removeContact(contactToRemove);
                    } else {
                        System.out.println("Contact not found.");
                    }
                }
                case 3 -> {
                    System.out.print("Enter name to search: ");
                    String nameToSearch = scanner.nextLine();
                    Contact searchedContact = addressBook.searchContact(nameToSearch);
                    if (searchedContact != null) {
                        System.out.println("Contact found: " + searchedContact);
                    } else {
                        System.out.println("Contact not found.");
                    }
                }
                case 4 -> addressBook.displayAllContacts();
                case 5 -> {
                    System.out.println("Exiting the address book.");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
