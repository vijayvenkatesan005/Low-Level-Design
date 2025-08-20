// Vijay Venkatesan

public class Main {
    public static void main(String[] args) {
        ContactManager manager = new ContactManager();

        Contact alice = new Contact(
            "Alice Smith",
            "123-456-7890",
            "alice@example.com"
        );

        Contact bob = new Contact(
            "Bob Jones",
            "555-555-5555",
            "bob@example.com"
        );

        manager.addContact(alice);
        manager.addContact(bob);

        System.out.println("All contacts:");

        for (Contact contact : manager.getAllContacts()) {
            System.out.println(contact);
        }

        System.out.println("\nSearching for 'Alice Smith':");
        for (Contact contact: manager.searchContactByName("Alice Smith")) {
            System.out.println(contact);
        }

        boolean removed = manager.removeContactByName("Bob Jones");
        System.out.println("\nRemoved Bob Jones: " + removed);

        System.out.println("\nContacts after removal:");
        for (Contact contact : manager.getAllContacts()) {
            System.out.println(contact);
        }
        
    }
}