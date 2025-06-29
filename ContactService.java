import java.util.ArrayList;
import java.util.List;

/**
 * ContactService class manages a collection of contacts with add, delete, and update operations.
 * Uses in-memory data structures to store contacts.
 */
public class ContactService {
    private List<Contact> contacts;

    /**
     * Constructor initializes the contact list
     */
    public ContactService() {
        this.contacts = new ArrayList<>();
    }

    /**
     * Adds a new contact with unique ID
     * @param contact The contact to add
     * @throws IllegalArgumentException if contact ID already exists
     */
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        
        // Check for unique ID
        for (Contact existingContact : contacts) {
            if (existingContact.getContactId().equals(contact.getContactId())) {
                throw new IllegalArgumentException("Contact ID must be unique");
            }
        }
        
        contacts.add(contact);
    }

    /**
     * Deletes a contact by contact ID
     * @param contactId The ID of the contact to delete
     * @throws IllegalArgumentException if contact ID is not found
     */
    public void deleteContact(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }
        
        Contact contactToRemove = null;
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                contactToRemove = contact;
                break;
            }
        }
        
        if (contactToRemove == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        
        contacts.remove(contactToRemove);
    }

    /**
     * Updates contact fields by contact ID
     * @param contactId The ID of the contact to update
     * @param firstName New first name (can be null to skip update)
     * @param lastName New last name (can be null to skip update)
     * @param phone New phone number (can be null to skip update)
     * @param address New address (can be null to skip update)
     * @throws IllegalArgumentException if contact ID is not found
     */
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }
        
        Contact contactToUpdate = null;
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                contactToUpdate = contact;
                break;
            }
        }
        
        if (contactToUpdate == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        
        // Update fields if provided (null values skip the update)
        if (firstName != null) {
            contactToUpdate.setFirstName(firstName);
        }
        if (lastName != null) {
            contactToUpdate.setLastName(lastName);
        }
        if (phone != null) {
            contactToUpdate.setPhone(phone);
        }
        if (address != null) {
            contactToUpdate.setAddress(address);
        }
    }

    /**
     * Gets a contact by ID (for testing purposes)
     * @param contactId The ID of the contact to retrieve
     * @return The contact with the specified ID, or null if not found
     */
    public Contact getContact(String contactId) {
        if (contactId == null) {
            return null;
        }
        
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                return contact;
            }
        }
        return null;
    }

    /**
     * Gets all contacts
     * @return List of all contacts
     */
    public List<Contact> getAllContacts() {
        return new ArrayList<>(contacts);
    }
}

