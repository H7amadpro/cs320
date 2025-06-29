import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the ContactService class
 */
public class ContactServiceTest {
    private ContactService contactService;
    
    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }
    
    @Test
    public void testAddContactValid() {
        // Test adding a valid contact
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        
        Contact retrieved = contactService.getContact("123");
        assertNotNull(retrieved);
        assertEquals("123", retrieved.getContactId());
        assertEquals("John", retrieved.getFirstName());
    }
    
    @Test
    public void testAddContactNull() {
        // Test that adding null contact throws exception
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(null);
        });
    }
    
    @Test
    public void testAddContactDuplicateId() {
        // Test that adding contact with duplicate ID throws exception
        Contact contact1 = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("123", "Jane", "Smith", "9876543210", "456 Oak Ave");
        
        contactService.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact2);
        });
    }
    
    @Test
    public void testAddMultipleContactsUniqueIds() {
        // Test adding multiple contacts with unique IDs
        Contact contact1 = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("456", "Jane", "Smith", "9876543210", "456 Oak Ave");
        
        contactService.addContact(contact1);
        contactService.addContact(contact2);
        
        assertEquals(2, contactService.getAllContacts().size());
        assertNotNull(contactService.getContact("123"));
        assertNotNull(contactService.getContact("456"));
    }
    
    @Test
    public void testDeleteContactValid() {
        // Test deleting an existing contact
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        
        contactService.deleteContact("123");
        assertNull(contactService.getContact("123"));
        assertEquals(0, contactService.getAllContacts().size());
    }
    
    @Test
    public void testDeleteContactNull() {
        // Test that deleting with null ID throws exception
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact(null);
        });
    }
    
    @Test
    public void testDeleteContactNotFound() {
        // Test that deleting non-existent contact throws exception
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("999");
        });
    }
    
    @Test
    public void testDeleteContactFromMultiple() {
        // Test deleting one contact from multiple contacts
        Contact contact1 = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("456", "Jane", "Smith", "9876543210", "456 Oak Ave");
        
        contactService.addContact(contact1);
        contactService.addContact(contact2);
        
        contactService.deleteContact("123");
        assertNull(contactService.getContact("123"));
        assertNotNull(contactService.getContact("456"));
        assertEquals(1, contactService.getAllContacts().size());
    }
    
    @Test
    public void testUpdateContactFirstName() {
        // Test updating contact first name
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        
        contactService.updateContact("123", "Jane", null, null, null);
        
        Contact updated = contactService.getContact("123");
        assertEquals("Jane", updated.getFirstName());
        assertEquals("Doe", updated.getLastName()); // Should remain unchanged
    }
    
    @Test
    public void testUpdateContactLastName() {
        // Test updating contact last name
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        
        contactService.updateContact("123", null, "Smith", null, null);
        
        Contact updated = contactService.getContact("123");
        assertEquals("John", updated.getFirstName()); // Should remain unchanged
        assertEquals("Smith", updated.getLastName());
    }
    
    @Test
    public void testUpdateContactPhone() {
        // Test updating contact phone
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        
        contactService.updateContact("123", null, null, "9876543210", null);
        
        Contact updated = contactService.getContact("123");
        assertEquals("9876543210", updated.getPhone());
        assertEquals("123 Main St", updated.getAddress()); // Should remain unchanged
    }
    
    @Test
    public void testUpdateContactAddress() {
        // Test updating contact address
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        
        contactService.updateContact("123", null, null, null, "456 Oak Ave");
        
        Contact updated = contactService.getContact("123");
        assertEquals("456 Oak Ave", updated.getAddress());
        assertEquals("1234567890", updated.getPhone()); // Should remain unchanged
    }
    
    @Test
    public void testUpdateContactAllFields() {
        // Test updating all updatable fields at once
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        
        contactService.updateContact("123", "Jane", "Smith", "9876543210", "456 Oak Ave");
        
        Contact updated = contactService.getContact("123");
        assertEquals("123", updated.getContactId()); // Should remain unchanged
        assertEquals("Jane", updated.getFirstName());
        assertEquals("Smith", updated.getLastName());
        assertEquals("9876543210", updated.getPhone());
        assertEquals("456 Oak Ave", updated.getAddress());
    }
    
    @Test
    public void testUpdateContactNullId() {
        // Test that updating with null ID throws exception
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact(null, "Jane", null, null, null);
        });
    }
    
    @Test
    public void testUpdateContactNotFound() {
        // Test that updating non-existent contact throws exception
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("999", "Jane", null, null, null);
        });
    }
    
    @Test
    public void testUpdateContactInvalidFirstName() {
        // Test that updating with invalid first name throws exception
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("123", "JohnJohnJohn", null, null, null);
        });
    }
    
    @Test
    public void testUpdateContactInvalidLastName() {
        // Test that updating with invalid last name throws exception
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("123", null, "SmithSmithSmith", null, null);
        });
    }
    
    @Test
    public void testUpdateContactInvalidPhone() {
        // Test that updating with invalid phone throws exception
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("123", null, null, "123456789", null);
        });
    }
    
    @Test
    public void testUpdateContactInvalidAddress() {
        // Test that updating with invalid address throws exception
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("123", null, null, null, "123 Main Street, Apartment 456, City");
        });
    }
    
    @Test
    public void testGetContactExists() {
        // Test getting an existing contact
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        
        Contact retrieved = contactService.getContact("123");
        assertNotNull(retrieved);
        assertEquals("123", retrieved.getContactId());
    }
    
    @Test
    public void testGetContactNotExists() {
        // Test getting a non-existent contact
        Contact retrieved = contactService.getContact("999");
        assertNull(retrieved);
    }
    
    @Test
    public void testGetContactNullId() {
        // Test getting contact with null ID
        Contact retrieved = contactService.getContact(null);
        assertNull(retrieved);
    }
    
    @Test
    public void testGetAllContactsEmpty() {
        // Test getting all contacts when list is empty
        assertEquals(0, contactService.getAllContacts().size());
    }
    
    @Test
    public void testGetAllContactsMultiple() {
        // Test getting all contacts with multiple contacts
        Contact contact1 = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("456", "Jane", "Smith", "9876543210", "456 Oak Ave");
        
        contactService.addContact(contact1);
        contactService.addContact(contact2);
        
        assertEquals(2, contactService.getAllContacts().size());
    }
}

