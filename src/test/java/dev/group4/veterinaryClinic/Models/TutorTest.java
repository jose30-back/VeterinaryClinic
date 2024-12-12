package dev.group4.veterinaryClinic.Models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;

public class TutorTest {

    @Test
    public void testConstructor() {

        Long id = 1L;
        String firstName = "Mickey";
        String lastName = "Mouse";
        String phone = "666438412";

        Tutor tutor = new Tutor(id, firstName, lastName, phone, Collections.emptyList());

        assertEquals(id, tutor.getId());
        assertEquals(firstName, tutor.getFirstName());
        assertEquals(lastName, tutor.getLastName());
        assertEquals(phone, tutor.getPhone());

    }

    @Test
    public void testGettersAndSetters() {
        Tutor tutor = new Tutor(null, null, null, null, null);

        tutor.setId(2L);
        tutor.setFirstName("Rapunzel");
        tutor.setLastName("Princesa");
        tutor.setPhone("123456789");

        assertEquals(2L, tutor.getId());
        assertEquals("Rapunzel", tutor.getFirstName());
        assertEquals("Princesa", tutor.getLastName());
        assertEquals("123456789", tutor.getPhone());
    }

    

}
