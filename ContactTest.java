import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Contact class
 */
public class ContactTest {
    
    @Test
    public void testContactCreationValid() {
        // Test valid contact creation
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        
        assertEquals("1234567890", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }
    
    @Test
    public void testContactIdNull() {
        // Test that null contact ID throws exception
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
    }
    
    @Test
    public void testContactIdTooLong() {
        // Test that contact ID longer than 10 characters throws exception
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
    }
    
    @Test
    public void testContactIdMaxLength() {
        // Test that contact ID of exactly 10 characters is valid
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("1234567890", contact.getContactId());
    }
    
    @Test
    public void testFirstNameNull() {
        // Test that null first name throws exception
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", null, "Doe", "1234567890", "123 Main St");
        });
    }
    
    @Test
    public void testFirstNameTooLong() {
        // Test that first name longer than 10 characters throws exception
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "JohnJohnJohn", "Doe", "1234567890", "123 Main St");
        });
    }
    
    @Test
    public void testFirstNameMaxLength() {
        // Test that first name of exactly 10 characters is valid
        Contact contact = new Contact("123", "JohnJohnJo", "Doe", "1234567890", "123 Main St");
        assertEquals("JohnJohnJo", contact.getFirstName());
    }
    
    @Test
    public void testLastNameNull() {
        // Test that null last name throws exception
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", null, "1234567890", "123 Main St");
        });
    }
    
    @Test
    public void testLastNameTooLong() {
        // Test that last name longer than 10 characters throws exception
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "DoeDoeDoeDoeDoe", "1234567890", "123 Main St");
        });
    }
    
    @Test
    public void testLastNameMaxLength() {
        // Test that last name of exactly 10 characters is valid
        Contact contact = new Contact("123", "John", "DoeDoeDoeD", "1234567890", "123 Main St");
        assertEquals("DoeDoeDoeD", contact.getLastName());
    }
    
    @Test
    public void testPhoneNull() {
        // Test that null phone throws exception
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", null, "123 Main St");
        });
    }
    
    @Test
    public void testPhoneTooShort() {
        // Test that phone shorter than 10 digits throws exception
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "123456789", "123 Main St");
        });
    }
    
    @Test
    public void testPhoneTooLong() {
        // Test that phone longer than 10 digits throws exception
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "12345678901", "123 Main St");
        });
    }
    
    @Test
    public void testPhoneNonDigits() {
        // Test that phone with non-digits throws exception
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "123456789a", "123 Main St");
        });
    }
    
    @Test
    public void testPhoneExactly10Digits() {
        // Test that phone with exactly 10 digits is valid
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("1234567890", contact.getPhone());
    }
    
    @Test
    public void testAddressNull() {
        // Test that null address throws exception
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "1234567890", null);
        });
    }
    
    @Test
    public void testAddressTooLong() {
        // Test that address longer than 30 characters throws exception
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "1234567890", "123 Main Street, Apartment 456, City");
        });
    }
    
    @Test
    public void testAddressMaxLength() {
        // Test that address of exactly 30 characters is valid
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main Street, Apt 456, NY");
        assertEquals("123 Main Street, Apt 456, NY", contact.getAddress());
    }
    
    @Test
    public void testSetFirstNameValid() {
        // Test valid first name update
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }
    
    @Test
    public void testSetFirstNameNull() {
        // Test that setting null first name throws exception
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
    }
    
    @Test
    public void testSetFirstNameTooLong() {
        // Test that setting first name too long throws exception
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("JohnJohnJohn");
        });
    }
    
    @Test
    public void testSetLastNameValid() {
        // Test valid last name update
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }
    
    @Test
    public void testSetLastNameNull() {
        // Test that setting null last name throws exception
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });
    }
    
    @Test
    public void testSetLastNameTooLong() {
        // Test that setting last name too long throws exception
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("SmithSmithSmith");
        });
    }
    
    @Test
    public void testSetPhoneValid() {
        // Test valid phone update
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contact.setPhone("9876543210");
        assertEquals("9876543210", contact.getPhone());
    }
    
    @Test
    public void testSetPhoneNull() {
        // Test that setting null phone throws exception
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone(null);
        });
    }
    
    @Test
    public void testSetPhoneInvalid() {
        // Test that setting invalid phone throws exception
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("123456789");
        });
    }
    
    @Test
    public void testSetAddressValid() {
        // Test valid address update
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contact.setAddress("456 Oak Ave");
        assertEquals("456 Oak Ave", contact.getAddress());
    }
    
    @Test
    public void testSetAddressNull() {
        // Test that setting null address throws exception
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
    }
    
    @Test
    public void testSetAddressTooLong() {
        // Test that setting address too long throws exception
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("123 Main Street, Apartment 456, City");
        });
    }
}

