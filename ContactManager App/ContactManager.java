// Vijay Venkatesan

import java.util.List;
import java.util.LinkedList;

public class ContactManager {
    private List<Contact> contacts;

    public ContactManager() {
        this.contacts = new LinkedList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public List<Contact> getAllContacts() {
        return List.copyOf(contacts);
    }

    public List<Contact> searchContactByName(String name) {
        List<Contact> possible_contacts = new LinkedList<>();
        
        for (Contact contact: this.contacts) {
            if (contact.getName().equals(name)) {
                possible_contacts.add(contact);
            }
        }
        
        return possible_contacts;
    }

    public boolean removeContactByName(String name) {
        return this.contacts.removeIf(contact -> contact.getName().equals(name));
    }
    
}
